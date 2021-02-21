package pl.umcs.diseasesimulation.aplication.service.seirds;

import pl.umcs.diseasesimulation.aplication.dto.seirds.SeirdsDto;
import pl.umcs.diseasesimulation.domain.agregate.seirds.Seirds;

import java.util.List;

public interface SeridsService {
    SeirdsDto addSimulation(Seirds simulation);
    List<SeirdsDto> findAll();
    SeirdsDto updateSimulation(Seirds simulation);
    void deleteSimulation(int id);
}
