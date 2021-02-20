package pl.umcs.DiseaseSimulation.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.umcs.DiseaseSimulation.domain.agregate.sir.Sir;

@Repository
public interface SirRepository extends JpaRepository<Sir, Integer> {
}
