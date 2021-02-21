package pl.umcs.diseasesimulation.seirds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.umcs.diseasesimulation.aplication.dto.mapper.SimulationMapper;
import pl.umcs.diseasesimulation.aplication.dto.seirds.SeirdsDto;
import pl.umcs.diseasesimulation.aplication.dto.seirds.SeirdsRecordDto;
import pl.umcs.diseasesimulation.domain.agregate.seirds.Seirds;
import pl.umcs.diseasesimulation.domain.agregate.seirds.SeirdsRecord;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class SimulationMapperTest {

    @Autowired
    SimulationMapper mapper;

    @Test
    void mapped_simulation_is_equal_to_simulation_summary_dto() {
        List<SeirdsRecord> records = Arrays.asList(
                new SeirdsRecord(1, 2, 3, 4, 2, null),
                new SeirdsRecord(5, 1, 2, 3, 1, null),
                new SeirdsRecord(8, 1, 3, 2, 1, null)
        );
        Seirds simulation = Seirds.builder()
                .name("Example name")
                .population(0)
                .initialInfectedNumber(1)
                .daysOfSimulation(9)
                .birthRate(0.1)
                .naturalDeathRate(0.2)
                .reproductionRate(0.3)
                .diseaseDeathRate(0.4)
                .immunityTime(21.2)
                .incubationTime(2)
                .percentageOfPopulationWhenRestrictionsBegins(3)
                .percentageOfPopulationWhenRestrictionsEnds(4)
                .quarantineRate(0.2)
                .reductionByRestrictions(2)
                .records(records)
                .build();

        SeirdsDto simulationDto = mapper.SeirdsToSeirdsDto(simulation);

        areSimulationsEquals(simulation, simulationDto);
    }

    @Test
    void mapped_simulation_dto_is_equal_to_simulation() {
        List<SeirdsRecordDto> records = Arrays.asList(
                new SeirdsRecordDto(1L, 2L, 3L, 4L, 2L),
                new SeirdsRecordDto(5L, 1L, 2L, 3L, 1L),
                new SeirdsRecordDto(8L, 1L, 3L, 2L, 1L)
        );
        SeirdsDto simulationDto = SeirdsDto.builder()
                .name("Example name")
                .population(0L)
                .initialInfectedNumber(1L)
                .daysOfSimulation(9)
                .birthRate(0.1)
                .naturalDeathRate(0.2)
                .reproductionRate(0.3)
                .diseaseDeathRate(0.4)
                .immunityTime(21.2)
                .incubationTime(2.0)
                .percentageOfPopulationWhenRestrictionsBegins(3.0)
                .percentageOfPopulationWhenRestrictionsEnds(4.0)
                .quarantineRate(0.2)
                .reductionByRestrictions(2.0)
                .records(records)
                .diseaseDuration(3.2)
                .build();

        System.out.println(simulationDto);

        Seirds simulation = mapper.SeirdsDtoToSeirds(simulationDto);

        areSimulationsEquals(simulation, simulationDto);
    }

    void areSimulationsEquals(Seirds simulation, SeirdsDto simulationDto) {
        Assertions.assertEquals(simulation.getName(), simulationDto.getName());
        Assertions.assertEquals(simulation.getId(), simulationDto.getId());
        Assertions.assertEquals(simulation.getPopulation(), simulationDto.getPopulation());
        Assertions.assertEquals(simulation.getInitialInfectedNumber(), simulationDto.getInitialInfectedNumber());
        Assertions.assertEquals(simulation.getDaysOfSimulation(), simulationDto.getDaysOfSimulation());
        Assertions.assertEquals(simulation.getBirthRate(), simulationDto.getBirthRate());
        Assertions.assertEquals(simulation.getNaturalDeathRate(), simulationDto.getNaturalDeathRate());
        Assertions.assertEquals(simulation.getDiseaseDuration(), simulationDto.getDiseaseDuration());
        Assertions.assertEquals(simulation.getDiseaseDeathRate(), simulationDto.getDiseaseDeathRate());
        Assertions.assertEquals(simulation.getImmunityTime(), simulationDto.getImmunityTime());
        Assertions.assertEquals(simulation.getIncubationTime(), simulationDto.getIncubationTime());
        Assertions.assertEquals(simulation.getPercentageOfPopulationWhenRestrictionsBegins(), simulationDto.getPercentageOfPopulationWhenRestrictionsBegins());
        Assertions.assertEquals(simulation.getPercentageOfPopulationWhenRestrictionsEnds(), simulationDto.getPercentageOfPopulationWhenRestrictionsEnds());
        Assertions.assertEquals(simulation.getQuarantineRate(), simulationDto.getQuarantineRate());
        Assertions.assertEquals(simulation.getReductionByRestrictions(), simulationDto.getReductionByRestrictions());
        areRecordsEquals(simulation.getRecords(), simulationDto.getRecords());
    }

    void areRecordsEquals(List<SeirdsRecord> records, List<SeirdsRecordDto> recordsDto) {
        Assertions.assertEquals(records.size(), recordsDto.size());
        for (int i=0 ; i<records.size() ; i++) {
            Assertions.assertEquals(records.get(i).getRecovered(), recordsDto.get(i).getRecovered());
            Assertions.assertEquals(records.get(i).getInfected(), recordsDto.get(i).getInfected());
            Assertions.assertEquals(records.get(i).getSusceptible(), recordsDto.get(i).getSusceptible());
            Assertions.assertEquals(records.get(i).getDeaths(), recordsDto.get(i).getDeaths());
            Assertions.assertEquals(records.get(i).getExposed(), recordsDto.get(i).getExposed());
        }
    }
}
