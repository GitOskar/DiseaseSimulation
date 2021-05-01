package pl.umcs.diseasesimulation.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.umcs.diseasesimulation.domain.agregate.sir.Sir;

@Repository
public interface SirRepository extends JpaRepository<Sir, Integer> {
}
