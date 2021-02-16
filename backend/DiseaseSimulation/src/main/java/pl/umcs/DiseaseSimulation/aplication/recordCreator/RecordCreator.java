package pl.umcs.DiseaseSimulation.aplication.recordCreator;

import pl.umcs.DiseaseSimulation.domain.agregate.Record;
import pl.umcs.DiseaseSimulation.domain.agregate.Simulation;

import java.util.ArrayList;
import java.util.List;

public class RecordCreator
{
    private Simulation simulation;
    private boolean areAnyRestrictions;
    private double dailyInfectionRate;
    private List<Record> records;

    public RecordCreator(Simulation simulation) {
        this.simulation = simulation;
        areAnyRestrictions = false;
        dailyInfectionRate = simulation.getInitialInfectedNumber();
        records = new ArrayList<>();
        addInitialRecord();
    }

    public List<Record> createRecords()
    {
        for (int i=1 ; i<simulation.getDaysOfSimulation() ; i++)
        {
            Record record = new Record(records.get(i-1));
        }

        return records;
    }

    private void addInitialRecord()
    {
        records.add(
                new Record(
                    simulation.getInitialInfectedNumber(),
                    simulation.getPopulation() - simulation.getInitialInfectedNumber(),
                    0L,
                    0L,
                    simulation
                ));
    }
}
