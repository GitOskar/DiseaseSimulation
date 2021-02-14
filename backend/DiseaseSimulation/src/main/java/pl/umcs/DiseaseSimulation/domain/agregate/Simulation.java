package pl.umcs.DiseaseSimulation.domain.agregate;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.umcs.DiseaseSimulation.domain.primitive.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data @NoArgsConstructor
@Entity @Table(name = "SIMULATION")
public class Simulation extends BaseEntity
{
    @Column(name = "NAME", length = 25)
    private String name;
    @Column(name = "POPULATION")
    private long population;
    @Column(name = "INITIAL_INFECTED_NUMBER")
    private long initialInfectedNumber;
    @Column(name = "MORTALITY_RATE")
    private double mortalityRate;
    @Column(name = "DISEASE_DURATION")
    private int diseaseDuration;
    @Column(name = "TIME_OF_DYING")
    private int timeOfDying;
    @Column(name = "IMMUNITY_TIME")
    private int immunityTime;
    @Column(name = "DURATION_OF_SYMPTOMS")
    private int durationOfSymptoms;
    @Column(name = "TIME_OF_ONSET_OF_SYMPTOMS_FROM_INCUBATION")
    private int timeOfOnsetOfSymptomsFromIncubation;
    @Column(name = "INCUBATION_TIME")
    private int incubationTime;
    @Column(name = "PERCENT_OF_PEOPLE_QUARANTINED")
    private double percentOfPeopleQuarantined;
    @Column(name = "TIME_OF_INFECT")
    private int timeOfInfect;
    @Column(name = "PERCENTAGE_OF_INFECTED_FROM_POPULATION_WHEN_RESTRICTIONS_BEGINS")
    private double percentageOfInfectedFromPopulationWhenRestrictionsBegins;
    @Column(name = "PERCENTAGE_OF_INFECTED_FROM_POPULATION_WHEN_RESTRICTIONS_ENDS")
    private double percentageOfInfectedFromPopulationWhenRestrictionsEnds;
    @Column(name = "INFECTION_REDUCTION_BY_RESTRICTIONS")
    private double infectionReductionByRestrictions;
    @Column(name = "DAYS_OF_SIMULATION")
    private int daysOfSimulation;
}
