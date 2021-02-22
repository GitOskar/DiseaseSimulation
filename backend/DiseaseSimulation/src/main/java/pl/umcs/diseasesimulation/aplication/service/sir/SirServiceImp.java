package pl.umcs.diseasesimulation.aplication.service.sir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.umcs.diseasesimulation.aplication.dto.sir.SirDto;
import pl.umcs.diseasesimulation.aplication.dto.mapper.SimulationMapper;
import pl.umcs.diseasesimulation.aplication.modelingmethods.sir.SirRecordCreator;
import pl.umcs.diseasesimulation.domain.agregate.sir.Sir;
import pl.umcs.diseasesimulation.infrastructure.persistance.SirRepository;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class SirServiceImp implements SirService {
    @Autowired
    SirRepository repository;
    @Autowired
    SimulationMapper mapper;

    public SirServiceImp(SirRepository repository) {
        this.repository = repository;
    }

    @Override
    public SirDto addSimulation(Sir simulation) {
        SirRecordCreator recordCreator = new SirRecordCreator(simulation);
        simulation.setRecords(recordCreator.createRecords());
        return mapper.SirToSirDto(repository.save(simulation));
    }

    @Override
    public List<SirDto> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::SirToSirDto)
                .collect(Collectors.toList());
    }

    @Override @Transactional
    public SirDto updateSimulation(Sir simulation) {
        Sir sir = repository.findById(simulation.getId()).orElseThrow();
        sir.deleteAllRecords();

        sir.setBirthRate(simulation.getBirthRate());
        sir.setDeathRate(simulation.getDeathRate());
        sir.setDiseaseDuration(simulation.getDiseaseDuration());
        sir.setDaysOfSimulation(simulation.getDaysOfSimulation());
        sir.setInitialInfectedNumber(simulation.getInitialInfectedNumber());
        sir.setName(simulation.getName());
        sir.setPopulation(simulation.getPopulation());
        sir.setReproductionRate(simulation.getReproductionRate());

        SirRecordCreator recordCreator = new SirRecordCreator(sir);
        recordCreator.createRecords().forEach(v -> sir.getRecords().add(v));
        return mapper.SirToSirDto(sir);
    }

    @Override @Transactional
    public void deleteSimulation(int id) {
        repository.deleteById(id);
    }
}
