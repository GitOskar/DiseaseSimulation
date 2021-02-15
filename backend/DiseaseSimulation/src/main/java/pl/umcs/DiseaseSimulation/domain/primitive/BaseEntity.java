package pl.umcs.DiseaseSimulation.domain.primitive;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity
{
    @Id @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    protected Integer id;
}
