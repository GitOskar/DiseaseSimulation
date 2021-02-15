package pl.umcs.DiseaseSimulation.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.umcs.DiseaseSimulation.domain.agregate.Simulation;

@Repository
public interface SimulationRepository extends JpaRepository<Simulation, Integer> {
}
