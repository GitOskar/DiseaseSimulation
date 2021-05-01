package pl.umcs.diseasesimulation.aplication.modelingmethods.seirds;

import pl.umcs.diseasesimulation.domain.agregate.seirds.Seirds;
import pl.umcs.diseasesimulation.domain.agregate.seirds.SeirdsRecord;

import java.util.ArrayList;
import java.util.List;

public class SeirdsRecordCreator {
    private Seirds simulation;
    private double quarantineRate;
    private double population;
    private double naturalDeathRate;
    private double diseaseDeathRate;
    private double birthRate;
    private double reproductionRate;
    private double immunityLoseRate;
    private double incubationRate;
    private double recoveryRate;
    private boolean areAnyRestrictions;
    private int dayOfRestriction;


    public SeirdsRecordCreator(Seirds simulation) {
        this.simulation = simulation;
        reproductionRate = simulation.getReproductionRate() / simulation.getInfectiousTime();
        birthRate = simulation.getBirthRate() / 365.25;
        naturalDeathRate = simulation.getNaturalDeathRate() / 365.25;
        diseaseDeathRate = simulation.getDiseaseDeathRate() / simulation.getTimeOfDyingFromIncubation();
        quarantineRate = simulation.getQuarantineRate();
        population = simulation.getPopulation();
        immunityLoseRate = 1 / simulation.getImmunityTime();
        incubationRate = 1 / simulation.getIncubationTime();
        recoveryRate = 1 / simulation.getDiseaseDuration();
        areAnyRestrictions = false;
    }

    public List<SeirdsRecord> createRecords() {
        List<SeirdsRecord> records = new ArrayList<>();
        records.add(initialRecord());

        double[] s = new double[2];
        double[] e = new double[2];
        double[] i = new double[2];
        double[] r = new double[2];
        double[] d = new double[2];

        s[0] = simulation.getPopulation() - simulation.getInitialInfectedNumber();
        i[0] = simulation.getInitialInfectedNumber();

        for (int day=1 ; day<simulation.getDaysOfSimulation() ; day++) {
            double newInfected = calculateNewInfectedNumber(s[previous(day)], i[previous(day)],
                    simulation.getTimeOfOnsetOfSymptoms(), simulation.getInfectiousTime());

            double dSdt = -newInfected + immunityLoseRate*r[previous(day)] - naturalDeathRate*s[previous(day)] + birthRate * population;
            double dEdt = newInfected - incubationRate * e[previous(day)] - naturalDeathRate*e[previous(day)];
            double dIdt = incubationRate * e[previous(day)] - recoveryRate * i[previous(day)] - diseaseDeathRate * i[previous(day)] - naturalDeathRate * i[previous(day)];
            double dRdt = recoveryRate * i[previous(day)] - naturalDeathRate * r[previous(day)] - immunityLoseRate*r[previous(day)];
            double dDdt = diseaseDeathRate * i[previous(day)] + naturalDeathRate * (s[previous(day)] + e[previous(day)] + i[previous(day)] + r[previous(day)]);

            s[day%2] = s[previous(day)] + dSdt;
            e[day%2] = e[previous(day)] + dEdt;
            i[day%2] = i[previous(day)] + dIdt;
            r[day%2] = r[previous(day)] + dRdt;
            d[day%2] = d[previous(day)] + dDdt;

            population += dSdt + dEdt + dIdt + dRdt + dDdt;

            SeirdsData data = new SeirdsData(s[day%2], e[day%2], i[day%2], r[day%2], d[day%2]);
            recalculateReproductionNumber(newInfected);
            modelNextDay(data);
            records.add(createRecord(data, calculateQuarantined(i[previous(day)])));
        }

        return records;
    }

    private SeirdsRecord initialRecord() {
        return SeirdsRecord.builder()
                .deaths(0)
                .exposed(simulation.getInitialInfectedNumber())
                .infected(0)
                .susceptible(simulation.getPopulation() - simulation.getInitialInfectedNumber())
                .quarantined(0)
                .recovered(0)
                .simulation(simulation)
                .build();
    }

    private int previous(int day) {
        return (day-1)%2;
    }

    private double calculateNewInfectedNumber(double s, double i, double timeOfOnsetSymptoms, double infectiousTime) {
        return timeOfOnsetSymptoms / infectiousTime * reproductionRate * s * i / population
                + (1 - timeOfOnsetSymptoms / infectiousTime) * reproductionRate * s * i * (1 - quarantineRate) / population;
    }

    private long calculateQuarantined(double i) {
        return Math.round((1 - simulation.getTimeOfOnsetOfSymptoms() / simulation.getInfectiousTime()) * i * quarantineRate);
    }

    private SeirdsRecord createRecord(SeirdsData data, long quarantined) {
        return SeirdsRecord.builder()
                .simulation(simulation)
                .recovered((long) data.r)
                .susceptible((long) data.s)
                .infected((long) data.i)
                .exposed((long) data.e)
                .deaths((long) data.d)
                .quarantined(quarantined)
                .build();
    }

    private void recalculateReproductionNumber(double newInfected) {
        if (!areAnyRestrictions) {
            if (newInfected/population >= simulation.getPercentageOfPopulationWhenRestrictionsBegins()) {
                reproductionRate *= simulation.getReductionByRestrictions();
                dayOfRestriction = simulation.getDaysOfRestrictions();
                areAnyRestrictions = true;
            }
        }
        else {
            if (dayOfRestriction-- == 0) {
                reproductionRate = simulation.getReproductionRate() / simulation.getInfectiousTime();
                areAnyRestrictions = false;
            }
        }
    }

    private void modelNextDay(SeirdsData data) {
        int diff = (int) (Math.round(population)
                - Math.floor(data.s)
                - Math.floor(data.e)
                - Math.floor(data.i)
                - Math.floor(data.r)
                - Math.floor(data.d));

        data.addToAll(diff/5);

        SeirdsDayModeler.modelDay(data, diff%5);
    }
}

