package pl.umcs.DiseaseSimulation.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.umcs.DiseaseSimulation.aplication.dto.SimulationSummaryDto;
import pl.umcs.DiseaseSimulation.aplication.service.SimulationService;
import pl.umcs.DiseaseSimulation.domain.agregate.Simulation;

@RestController
@RequestMapping("api/simulation")
public class SimulationController
{
    @Autowired
    SimulationService service;

    @PostMapping
    public SimulationSummaryDto addSimulation(@RequestBody Simulation simulation)
    {
        return service.save(simulation);
    }
}
