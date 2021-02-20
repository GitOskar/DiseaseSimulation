package pl.umcs.DiseaseSimulation.domain.agregate.sir;

import lombok.*;
import pl.umcs.DiseaseSimulation.domain.primitive.BaseEntity;
import pl.umcs.DiseaseSimulation.domain.primitive.Record;
import pl.umcs.DiseaseSimulation.domain.primitive.Simulation;

import javax.persistence.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder
@Entity @Table(name = "SIR_RECORD")
public class SirRecord extends BaseEntity implements Record {
    @Column(name = "SUSCEPTIBLE")
    private long susceptible;
    @Column(name = "INFECTED")
    private long infected;
    @Column(name = "REMOVED")
    private long removed;
    @ManyToOne @JoinColumn(name = "SIMULATION_ID")
    private Sir sir;
}
