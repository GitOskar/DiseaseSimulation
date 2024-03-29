package pl.umcs.diseasesimulation.aplication.modelingmethods.sir;

import pl.umcs.diseasesimulation.domain.agregate.sir.Sir;
import pl.umcs.diseasesimulation.domain.agregate.sir.SirRecord;

import java.util.ArrayList;
import java.util.List;

public class SirRecordCreator {

    private Sir simulation;
    private double population;
    private double birthRate;
    private double deathRate;
    private double dailyReproductionRate;
    private double recoveryRate;

    public SirRecordCreator(Sir sir) {
        this.simulation = sir;
        population = simulation.getPopulation();
        dailyReproductionRate = simulation.getReproductionRate() / simulation.getDiseaseDuration();
        birthRate = simulation.getBirthRate() / 365;
        deathRate = simulation.getDeathRate() / 365;
        recoveryRate = 1.0 / simulation.getDiseaseDuration();
    }

    public List<SirRecord> createRecords() {
        List<SirRecord> records = new ArrayList<>();
        records.add(initialRecord());

        double[] s = new double[2];
        double[] i = new double[2];
        double[] r = new double[2];

        s[0] = simulation.getPopulation() - simulation.getInitialInfectedNumber();
        i[0] = simulation.getInitialInfectedNumber();

        for (int day=1 ; day<simulation.getDaysOfSimulation() ; day++) {
            double newInfected = (dailyReproductionRate*i[previous(day)]*s[previous(day)]) / population;
            double dSdt = birthRate*population - deathRate*s[previous(day)] - newInfected;
            double dIdt = newInfected - recoveryRate*i[previous(day)] - deathRate*i[previous(day)];
            double dRdt = recoveryRate*i[previous(day)] - deathRate*r[previous(day)];
            
            s[day%2] = s[previous(day)] + dSdt;
            i[day%2] = i[previous(day)] + dIdt;
            r[day%2] = r[previous(day)] + dRdt;

            population += dSdt + dIdt + dRdt;
            SirData data = new SirData(s[day%2], i[day%2], r[day%2]);
            modelNextDay(data);
            records.add(createRecord(data));
        }
        return records;
    }

    private SirRecord initialRecord() {
        return SirRecord.builder()
                .susceptible(simulation.getPopulation() - simulation.getInitialInfectedNumber())
                .infected(simulation.getInitialInfectedNumber())
                .removed(0)
                .sir(simulation)
                .build();
    }

    private int previous(int day) {
        return (day-1)%2;
    }

    private void modelNextDay(SirData data) {
        int diff = (int) (Math.round(population) - Math.floor(data.s) - Math.floor(data.i) - Math.floor(data.r));

        data.addToAll(diff/3);

        SirDayModeler.modelDay(data, diff%3);
    }

    private SirRecord createRecord(SirData data) {
        return SirRecord.builder()
                .susceptible((long) data.s)
                .infected((long) data.i)
                .removed((long) data.r)
                .sir(simulation)
                .build();
    }
}
