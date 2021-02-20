package pl.umcs.diseasesimulation.domain.primitive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter @Setter @SuperBuilder
@NoArgsConstructor @AllArgsConstructor
public abstract class Simulation extends BaseEntity {
    @Column(name = "NAME", length = 50)
    protected String name;
    @Column(name = "POPULATION")
    protected long population;
    @Column(name = "INITIAL_INFECTED_NUMBER")
    protected long initialInfectedNumber;
    @Column(name = "DAYS_OF_SIMULATION")
    protected int daysOfSimulation;
    @Column(name = "REPRODUCTION_RATE")
    protected double reproductionRate;
}
