package pl.umcs.diseasesimulation.domain.agregate.seirds;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.umcs.diseasesimulation.domain.primitive.Simulation;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Data
@Table(name = "SEIRDS")
public class Seirds extends Simulation {
    @Column(name = "IMMUNITY_TIME")
    private double immunityTime;
    @Column(name = "INCUBATION_TIME")
    private double incubationTime;
    @Column(name = "NATURAL_DEATH_RATE")
    private double naturalDeathRate;
    @Column(name = "QUARANTINE_RATE")
    private double quarantineRate;
    @Column(name = "BIRTH_RATE")
    private double birthRate;
    @Column(name = "DISEASE_DURATION")
    private double diseaseDuration;
    @Column(name = "DISEASE_DEATH_RATE")
    private double diseaseDeathRate;
    @Column(name = "REDUCTION_BY_RESTRICTIONS")
    private double reductionByRestrictions;
    @Column(name = "PERCENTAGE_OF_POPULATION_WHEN_RESTRICTIONS_BEGINS")
    private double percentageOfPopulationWhenRestrictionsBegins;
    @Column(name = "DAYS_OF_RESTRICTIONS")
    private int daysOfRestrictions;
    @Column(name = "INFECTIOUS_TIME")
    private double infectiousTime;
    @Column(name = "TIME_OF_ONSET_OF_SYMPTOMS")
    private double timeOfOnsetOfSymptoms;
    @Column(name = "TIME_OF_DYING_FROM_INCUBATION")
    private double timeOfDyingFromIncubation;
    @OneToMany(mappedBy = "simulation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeirdsRecord> records;

    public void deleteAllRecords() {
        records.clear();
    }

    public void update(Seirds simulation) {
        timeOfDyingFromIncubation = simulation.getTimeOfDyingFromIncubation();
        infectiousTime = simulation.getInfectiousTime();
        reproductionRate = simulation.getReproductionRate();
        name = simulation.getName();
        population = simulation.getPopulation();
        initialInfectedNumber = simulation.getInitialInfectedNumber();
        birthRate = simulation.getBirthRate();
        daysOfRestrictions = simulation.getDaysOfRestrictions();
        diseaseDeathRate = simulation.getDiseaseDeathRate();
        immunityTime = simulation.getImmunityTime();
        percentageOfPopulationWhenRestrictionsBegins = simulation.getPercentageOfPopulationWhenRestrictionsBegins();
        incubationTime = simulation.getIncubationTime();
        quarantineRate = simulation.getQuarantineRate();
        diseaseDuration = simulation.getDiseaseDuration();
        timeOfOnsetOfSymptoms = simulation.getTimeOfOnsetOfSymptoms();
        naturalDeathRate = simulation.getNaturalDeathRate();
        reductionByRestrictions = simulation.getReductionByRestrictions();
        daysOfSimulation = simulation.getDaysOfSimulation();
    }

}
