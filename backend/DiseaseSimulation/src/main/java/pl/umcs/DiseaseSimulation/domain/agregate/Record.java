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

    public Record(Record record)
    {
        this.infected = record.getInfected();
        this.death = record.getDeath();
        this.immune = record.getImmune();
        this.susceptible = record.getSusceptible();
        this.simulation = record.getSimulation();
    }

    public void addDeaths(long newDeaths)
    {
        this.death += newDeaths;
        this.infected -= newDeaths;
    }

    public void addInfected(long newInfected)
    {
        this.infected += newInfected;
        this.susceptible -= newInfected;
    }

    public void addImmune(long newResistant)
    {
        this.immune += newResistant;
        this.infected -= newResistant;
    }

    public void endOfImmunity(long newSusceptible)
    {
        immune -= newSusceptible;
        susceptible += newSusceptible;
    }
}
