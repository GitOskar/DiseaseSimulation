package pl.umcs.diseasesimulation.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.umcs.diseasesimulation.domain.agregate.seirds.Seirds;

@Repository
public interface SeirdsRepository extends JpaRepository<Seirds, Integer> {
}
