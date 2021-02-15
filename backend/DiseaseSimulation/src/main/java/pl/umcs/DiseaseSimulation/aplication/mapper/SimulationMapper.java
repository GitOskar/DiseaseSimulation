package pl.umcs.DiseaseSimulation.aplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.umcs.DiseaseSimulation.aplication.dto.SimulationSummaryDto;
import pl.umcs.DiseaseSimulation.domain.agregate.Simulation;

@Mapper(componentModel = "spring")
public interface SimulationMapper
{
    SimulationMapper mapper = Mappers.getMapper(SimulationMapper.class);

    Simulation SimulationSummaryDtoToSimulation(SimulationSummaryDto simulationSummaryDto);
    SimulationSummaryDto SimulationToSimulationSummaryDto(Simulation simulation);
}
