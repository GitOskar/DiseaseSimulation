package pl.umcs.diseasesimulation.aplication.dto.sir;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.umcs.diseasesimulation.domain.agregate.sir.Sir;

@Mapper(componentModel = "spring")
public interface SirMapper {
    SirMapper mapper = Mappers.getMapper(SirMapper.class);

    Sir SirDtoToSir(SirDto sirDto);
    SirDto SirToSirDto(Sir SIR);
}
