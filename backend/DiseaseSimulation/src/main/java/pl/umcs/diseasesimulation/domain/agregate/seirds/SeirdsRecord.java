package pl.umcs.diseasesimulation.domain.agregate.seirds;

import lombok.*;
import pl.umcs.diseasesimulation.domain.primitive.BaseEntity;
import pl.umcs.diseasesimulation.domain.primitive.Record;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "SEIRDS_RECORD")
public class SeirdsRecord extends BaseEntity implements Record {
    @Column(name = "SUSCEPTIBLE")
    private long susceptible;
    @Column(name = "EXPOSED")
    private long exposed;
    @Column(name = "INFECTED")
    private long infected;
    @Column(name = "REMOVED")
    private long recovered;
    @Column(name = "DEATHS")
    private long deaths;
    @Column(name = "QUARANTINED")
    private long quarantined;
    @ManyToOne @JoinColumn(name = "SIMULATION_ID")
    private Seirds simulation;

    public SeirdsRecord(long susceptible, long exposed, long infected, long recovered, long deaths, long quarantined) {
        this(susceptible, exposed, infected, recovered, deaths, quarantined, null);
    }
}
