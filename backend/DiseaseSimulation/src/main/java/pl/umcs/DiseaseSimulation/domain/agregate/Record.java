package pl.umcs.DiseaseSimulation.domain.agregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.umcs.DiseaseSimulation.domain.primitive.BaseEntity;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "RECORD")
public class Record extends BaseEntity
{
    @Column(name = "INFECTED")
    private long infected;
    @Column(name = "SUSCEPTIBLE")
    private long susceptible;
    @Column(name = "DEATH")
    private long death;
    @Column(name = "IMMUNE")
    private long immune;
    @ManyToOne @JoinColumn(name = "SIMULATION_ID")
    Simulation simulation;
}
