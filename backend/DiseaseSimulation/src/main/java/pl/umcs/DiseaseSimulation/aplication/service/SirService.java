package pl.umcs.DiseaseSimulation.aplication.service;

import pl.umcs.DiseaseSimulation.aplication.dto.sir.SirDto;
import pl.umcs.DiseaseSimulation.domain.agregate.sir.Sir;

import java.util.List;

public interface SirService {
    SirDto addSimulation(Sir simulation);
    List<SirDto> findAll();
    SirDto updateSimulation(Sir simulation);
    void deleteSimulation(int id);
}
