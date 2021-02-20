package pl.umcs.DiseaseSimulation.aplication.dto.sir;

import lombok.*;

import java.util.List;

@AllArgsConstructor @Builder
@Getter @Setter
public class SirDto {
    private Integer id;
    private String name;
    private Long population;
    private Long initialInfectedNumber;
    private Integer diseaseDuration;
    private Integer daysOfSimulation;
    private Double reproductionRate;
    private Double birthRate;
    private Double deathRate;
    private List<SirRecordDto> records;
}
