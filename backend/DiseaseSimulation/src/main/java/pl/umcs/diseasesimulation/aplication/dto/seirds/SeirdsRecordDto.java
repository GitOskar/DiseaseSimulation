package pl.umcs.diseasesimulation.aplication.dto.seirds;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class SeirdsRecordDto {
    private Long susceptible;
    private Long exposed;
    private Long infected;
    private Long recovered;
    private Long deaths;
    private Long quarantined;
}
