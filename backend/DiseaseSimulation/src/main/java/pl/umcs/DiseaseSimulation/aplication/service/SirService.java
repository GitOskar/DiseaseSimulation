package pl.umcs.diseasesimulation.aplication.service;

import pl.umcs.diseasesimulation.aplication.dto.sir.SirDto;
import pl.umcs.diseasesimulation.domain.agregate.sir.Sir;

import java.util.List;

public interface SirService {
    SirDto addSimulation(Sir simulation);
    List<SirDto> findAll();
    SirDto updateSimulation(Sir simulation);
    void deleteSimulation(int id);
}
