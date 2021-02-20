package pl.umcs.diseasesimulation.domain.primitive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@MappedSuperclass
@Getter @Setter @SuperBuilder
@NoArgsConstructor @AllArgsConstructor
public abstract class BaseEntity {
    @Id @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
}
