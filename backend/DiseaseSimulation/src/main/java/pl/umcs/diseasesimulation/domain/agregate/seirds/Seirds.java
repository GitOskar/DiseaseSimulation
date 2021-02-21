package pl.umcs.diseasesimulation.domain.agregate.seirds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import pl.umcs.diseasesimulation.domain.primitive.Simulation;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @SuperBuilder
@Entity @Table(name = "SEIRDS")
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
    @Column(name = "PERCENTAGE_OF_POPULATION_WHEN_RESTRICTIONS_ENDS")
    private double percentageOfPopulationWhenRestrictionsEnds;
    @OneToMany(mappedBy = "simulation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeirdsRecord> records;
}
