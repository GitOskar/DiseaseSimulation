package pl.umcs.diseasesimulation.domain.agregate.sir;

import lombok.*;
import pl.umcs.diseasesimulation.domain.primitive.BaseEntity;
import pl.umcs.diseasesimulation.domain.primitive.Record;

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
