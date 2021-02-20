package pl.umcs.DiseaseSimulation.domain.agregate.sir;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.umcs.DiseaseSimulation.domain.primitive.Record;
import pl.umcs.DiseaseSimulation.domain.primitive.Simulation;

import java.util.List;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @SuperBuilder
@Entity @Table(name = "SIR")
public class Sir extends Simulation {
    @Column(name = "DISEASE_DURATION")
    int diseaseDuration;
    @Column(name = "BIRTH_RATE")
    private double birthRate;
    @Column(name = "DEATH_RATE")
    private double deathRate;
    @OneToMany(mappedBy = "sir", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SirRecord> records;

    public void deleteAllRecords() {
        records.clear();
    }
}
