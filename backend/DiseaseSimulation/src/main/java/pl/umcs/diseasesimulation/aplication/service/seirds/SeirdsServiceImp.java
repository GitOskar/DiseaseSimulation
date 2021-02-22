package pl.umcs.diseasesimulation.aplication.service.seirds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.umcs.diseasesimulation.aplication.dto.mapper.SimulationMapper;
import pl.umcs.diseasesimulation.aplication.dto.seirds.SeirdsDto;
import pl.umcs.diseasesimulation.domain.agregate.seirds.Seirds;
import pl.umcs.diseasesimulation.infrastructure.persistance.SeirdsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeirdsServiceImp implements SeridsService {

    @Autowired
    SeirdsRepository repository;
    @Autowired
    SimulationMapper mapper;

    public SeirdsServiceImp(SeirdsRepository repository) {
        this.repository = repository;
    }

    @Override
    public SeirdsDto addSimulation(Seirds simulation) {
        return null;
    }

    @Override
    public List<SeirdsDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::SeirdsToSeirdsDto)
                .collect(Collectors.toList());
    }

    @Override
    public SeirdsDto updateSimulation(Seirds simulation) {
        return null;
    }

    @Override @Transactional
    public void deleteSimulation(int id) {
        repository.deleteById(id);
    }
}
