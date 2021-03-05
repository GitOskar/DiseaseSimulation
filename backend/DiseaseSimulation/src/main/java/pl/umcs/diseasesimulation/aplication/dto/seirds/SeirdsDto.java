package pl.umcs.diseasesimulation.aplication.dto.seirds;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
public class SeirdsDto {
    private Integer id;
    private String name;
    private Long population;
    private Long initialInfectedNumber;
    private Integer daysOfSimulation;
    private Double reproductionRate;
    private Double immunityTime;
    private Double incubationTime;
    private Double naturalDeathRate;
    private Double quarantineRate;
    private Double birthRate;
    private Double diseaseDuration;
    private Double diseaseDeathRate;
    private Double reductionByRestrictions;
    private Double percentageOfPopulationWhenRestrictionsBegins;
    private Double daysOfRestrictions;
    private Double infectiousTime;
    private Double timeOfOnsetOfSymptoms;
    private Double timeOfDyingFromIncubation;
    private List<SeirdsRecordDto> records;
}
