package pl.umcs.diseasesimulation.aplication.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.umcs.diseasesimulation.aplication.dto.seirds.SeirdsDto;
import pl.umcs.diseasesimulation.aplication.dto.sir.SirDto;
import pl.umcs.diseasesimulation.domain.agregate.seirds.Seirds;
import pl.umcs.diseasesimulation.domain.agregate.sir.Sir;

@Mapper(componentModel = "spring")
public interface SimulationMapper {
    SimulationMapper mapper = Mappers.getMapper(SimulationMapper.class);

    Sir SirDtoToSir(SirDto sirDto);
    SirDto SirToSirDto(Sir sir);
    Seirds SeirdsDtoToSeirds(SeirdsDto seirdsDto);
    SeirdsDto SeirdsToSeirdsDto(Seirds seirds);
}
