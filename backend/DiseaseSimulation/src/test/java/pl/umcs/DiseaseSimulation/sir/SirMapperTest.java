package pl.umcs.diseasesimulation.sir;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.umcs.diseasesimulation.aplication.dto.sir.SirRecordDto;
import pl.umcs.diseasesimulation.aplication.dto.sir.SirDto;
import pl.umcs.diseasesimulation.aplication.dto.sir.SirMapper;
import pl.umcs.diseasesimulation.domain.agregate.sir.SirRecord;
import pl.umcs.diseasesimulation.domain.agregate.sir.Sir;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
public class SirMapperTest {
    @Autowired
    SirMapper mapper;

    @Test
    void mapped_simulation_is_equal_to_simulation_summary_dto() {
        List<SirRecord> records = Arrays.asList(
                new SirRecord(1, 2, 3, null),
                new SirRecord(5, 1, 2, null),
                new SirRecord(8, 1, 3, null)
        );
        Sir sir = Sir.builder()
                .name("Example name")
                .population(0)
                .initialInfectedNumber(1)
                .daysOfSimulation(9)
                .birthRate(0.1)
                .deathRate(0.2)
                .reproductionRate(0.3)
                .records(records)
                .build();

        SirDto sirDto = mapper.SirToSirDto(sir);

        areSimulationsEquals(sir, sirDto);
    }

    @Test
    void mapped_simulation_summary_dto_is_equal_to_simulation() {
        List<SirRecordDto> records = Arrays.asList(
            new SirRecordDto(1, 2, 3),
            new SirRecordDto(5, 1, 2),
            new SirRecordDto(8, 1, 3)
        );

        SirDto sirDto = SirDto.builder()
                .name("Example name")
                .population(0L)
                .initialInfectedNumber(1L)
                .diseaseDuration(2)
                .daysOfSimulation(9)
                .birthRate(0.1)
                .deathRate(0.2)
                .reproductionRate(0.3)
                .records(records)
                .build();

        Sir SIR = mapper.SirDtoToSir(sirDto);
        areSimulationsEquals(SIR, sirDto);
    }

    void areSimulationsEquals(Sir sir, SirDto sirDto) {
        Assertions.assertEquals(sir.getName(), sirDto.getName());
        Assertions.assertEquals(sir.getId(), sirDto.getId());
        Assertions.assertEquals(sir.getPopulation(), sirDto.getPopulation());
        Assertions.assertEquals(sir.getInitialInfectedNumber(), sirDto.getInitialInfectedNumber());
        Assertions.assertEquals(sir.getDaysOfSimulation(), sirDto.getDaysOfSimulation());
        Assertions.assertEquals(sir.getBirthRate(), sirDto.getBirthRate());
        Assertions.assertEquals(sir.getDeathRate(), sirDto.getDeathRate());
        Assertions.assertEquals(sir.getDiseaseDuration(), sirDto.getDiseaseDuration());
        areRecordsEquals(sir.getRecords(), sirDto.getRecords());
    }

    void areRecordsEquals(List<SirRecord> record, List<SirRecordDto> sirRecordDto) {
        Assertions.assertEquals(record.size(), sirRecordDto.size());
        for (int i=0 ; i<record.size() ; i++) {
            Assertions.assertEquals(record.get(i).getRemoved(), sirRecordDto.get(i).getRemoved());
            Assertions.assertEquals(record.get(i).getInfected(), sirRecordDto.get(i).getInfected());
            Assertions.assertEquals(record.get(i).getSusceptible(), sirRecordDto.get(i).getSusceptible());
        }
    }
}
