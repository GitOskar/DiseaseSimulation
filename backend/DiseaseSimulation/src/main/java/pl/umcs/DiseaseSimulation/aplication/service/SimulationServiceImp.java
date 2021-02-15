package pl.umcs.DiseaseSimulation.aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umcs.DiseaseSimulation.aplication.dto.SimulationSummaryDto;
import pl.umcs.DiseaseSimulation.domain.agregate.Simulation;
import pl.umcs.DiseaseSimulation.infrastructure.persistance.SimulationRepository;

@Service
public class SimulationServiceImp implements SimulationService
{
    @Autowired
    SimulationRepository repository;

    @Override
    public SimulationSummaryDto save(Simulation simulation) {
        return null;
    }
}
