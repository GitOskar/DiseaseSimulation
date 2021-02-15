package pl.umcs.DiseaseSimulation.aplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data @AllArgsConstructor
public class SimulationSummaryDto
{
    private String name;
    private Long population;
    private Long initialInfectedNumber;
    private Double mortalityRate;
    private Integer diseaseDuration;
    private Integer timeOfDying;
    private Integer immunityTime;
    private Integer durationOfSymptoms;
    private Integer timeOfOnsetOfSymptomsFromIncubation;
    private Integer incubationTime;
    private Double percentOfPeopleQuarantined;
    private Integer timeOfInfect;
    private Double percentageOfInfectedFromPopulationWhenRestrictionsBegins;
    private Double percentageOfInfectedFromPopulationWhenRestrictionsEnds;
    private Double infectionReductionByRestrictions;
    private Integer daysOfSimulation;
    private List<RecordSummaryDto> records;
}
