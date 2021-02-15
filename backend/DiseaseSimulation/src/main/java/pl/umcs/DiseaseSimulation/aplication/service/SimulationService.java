package pl.umcs.DiseaseSimulation.aplication.service;

import pl.umcs.DiseaseSimulation.aplication.dto.SimulationSummaryDto;
import pl.umcs.DiseaseSimulation.domain.agregate.Simulation;

public interface SimulationService
{
    SimulationSummaryDto save(Simulation simulation);
}
