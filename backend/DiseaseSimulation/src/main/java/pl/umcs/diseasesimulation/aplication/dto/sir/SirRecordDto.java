package pl.umcs.diseasesimulation.aplication.dto.sir;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class SirRecordDto {
    private long infected;
    private long susceptible;
    private long removed;
}
