package pl.umcs.DiseaseSimulation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.umcs.DiseaseSimulation.aplication.dto.RecordSummaryDto;
import pl.umcs.DiseaseSimulation.aplication.dto.SimulationSummaryDto;
import pl.umcs.DiseaseSimulation.aplication.dto.mapper.SimulationMapper;
import pl.umcs.DiseaseSimulation.domain.agregate.Record;
import pl.umcs.DiseaseSimulation.domain.agregate.Simulation;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
public class SimulationMapperTest
{
    @Autowired
    SimulationMapper mapper;

    @Test
    void mapped_simulation_is_equal_to_simulation_summary_dto()
    {
        Record exampleRecord = new Record(10, 10, 10, 10, null);
        List<Record> records = Arrays.asList(
                new Record(1, 2, 3, 4, null),
                new Record(5, 1, 2, 3, null),
                new Record(8, 1, 3, 5, null)
        );
        Simulation simulation = new Simulation
                ("Example name", 0, 1, 0.1, 2, 3,
                        4, 5, 6, 7,
                        0.2, 8, 0.3,
                        0.4, 0.5, 9,
                        records
                );
        SimulationSummaryDto simulationSummaryDto = mapper.SimulationToSimulationSummaryDto(simulation);

        Assertions.assertTrue(
            areSimulationsEquals(simulation, simulationSummaryDto)
        );
    }

    @Test
    void mapped_simulation_summary_dto_is_equal_to_simulation()
    {
        List<RecordSummaryDto> records = Arrays.asList(
            new RecordSummaryDto(1, 2, 3, 4),
            new RecordSummaryDto(5, 1, 2, 3),
            new RecordSummaryDto(8, 1, 3, 5)
        );

        SimulationSummaryDto simulationSummaryDto = new SimulationSummaryDto(
                1, "Example name", 0L, 1L, 0.1, 2, 3,
                        4, 5, 6, 7,
                        0.2, 8, 0.3,
                        0.4, 0.5, 9,
                        records
                );
        Simulation simulation = mapper.SimulationSummaryDtoToSimulation(simulationSummaryDto);
        Assertions.assertTrue(
                areSimulationsEquals(simulation, simulationSummaryDto)
        );
    }



    boolean areSimulationsEquals(Simulation simulation, SimulationSummaryDto simulationSummaryDto)
    {
        return  simulation.getId() == simulationSummaryDto.getId() &&
                simulation.getName().equals(simulationSummaryDto.getName()) &&
                simulation.getPopulation() == simulationSummaryDto.getPopulation() &&
                simulation.getInitialInfectedNumber() == simulationSummaryDto.getInitialInfectedNumber() &&
                simulation.getMortalityRate() == simulationSummaryDto.getMortalityRate() &&
                simulation.getDiseaseDuration() == simulationSummaryDto.getDiseaseDuration() &&
                simulation.getTimeOfDying() == simulationSummaryDto.getTimeOfDying() &&
                simulation.getImmunityTime() == simulationSummaryDto.getImmunityTime() &&
                simulation.getDurationOfSymptoms() == simulationSummaryDto.getDurationOfSymptoms() &&
                simulation.getTimeOfOnsetOfSymptomsFromIncubation() == simulationSummaryDto.getTimeOfOnsetOfSymptomsFromIncubation() &&
                simulation.getIncubationTime() == simulationSummaryDto.getIncubationTime() &&
                simulation.getPercentOfPeopleQuarantined() == simulationSummaryDto.getPercentOfPeopleQuarantined() &&
                simulation.getTimeOfInfect() == simulationSummaryDto.getTimeOfInfect() &&
                simulation.getPercentageOfInfectedFromPopulationWhenRestrictionsBegins() == simulationSummaryDto.getPercentageOfInfectedFromPopulationWhenRestrictionsBegins() &&
                simulation.getPercentageOfInfectedFromPopulationWhenRestrictionsEnds() == simulationSummaryDto.getPercentageOfInfectedFromPopulationWhenRestrictionsEnds() &&
                simulation.getInfectionReductionByRestrictions() == simulationSummaryDto.getInfectionReductionByRestrictions() &&
                simulation.getDaysOfSimulation() == simulationSummaryDto.getDaysOfSimulation() &&
                areRecordsEquals(simulation.getRecords(), simulationSummaryDto.getRecords());
    }

    boolean areRecordsEquals(List<Record> record, List<RecordSummaryDto> recordSummaryDto)
    {
        if (record.size() != recordSummaryDto.size())
            return false;
        for (int i=0 ; i<record.size() ; i++)
            if (
                    record.get(i).getDeath() != recordSummaryDto.get(i).getDeath() ||
                    record.get(i).getImmune() != recordSummaryDto.get(i).getImmune() ||
                    record.get(i).getInfected() != recordSummaryDto.get(i).getInfected() ||
                    record.get(i).getSusceptible() != recordSummaryDto.get(i).getSusceptible()
                ) return false;
        return true;
    }
}
