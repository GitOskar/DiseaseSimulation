package pl.umcs.diseasesimulation.sir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.umcs.diseasesimulation.aplication.modelingmethods.sir.SirRecordCreator;
import pl.umcs.diseasesimulation.domain.agregate.sir.Sir;

@SpringBootTest
public class SirRecordCreatorTest {
    @Test
    void assert_that_susceptible_removed_infected_are_equals_to_population_without_vital_dynamics() {
        long examplePopulation = 40000000;

        Sir simulation = Sir.builder()
                .daysOfSimulation(300)
                .birthRate(0.0)
                .deathRate(0.0)
                .diseaseDuration(10)
                .initialInfectedNumber(5)
                .population(examplePopulation)
                .name("Example name")
                .reproductionRate(3.0)
                .build();

        SirRecordCreator recordCreator = new SirRecordCreator(simulation);
        recordCreator.createRecords()
                .forEach( v -> Assertions.assertEquals(examplePopulation, v.getInfected() + v.getRemoved() + v.getSusceptible()));
    }
}
