package pl.umcs.DiseaseSimulation.aplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RecordSummaryDto
{
    private long infected;
    private long susceptible;
    private long death;
    private long immune;
}
