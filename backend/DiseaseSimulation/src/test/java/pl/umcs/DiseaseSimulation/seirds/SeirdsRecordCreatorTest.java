package pl.umcs.diseasesimulation.seirds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.umcs.diseasesimulation.aplication.modelingmethods.seirds.SeirdsRecordCreator;
import pl.umcs.diseasesimulation.domain.agregate.seirds.Seirds;

@SpringBootTest
public class SeirdsRecordCreatorTest {

    @Test
    void assert_that_susceptible_removed_infected_are_equals_to_population_without_vital_dynamics() {
        long examplePopulation = 40000000;

        Seirds simulation = Seirds.builder()
                .daysOfSimulation(300)
                .birthRate(0.0)
                .naturalDeathRate(0.0)
                .initialInfectedNumber(5)
                .population(examplePopulation)
                .name("Example name")
                .reproductionRate(3.0)
                .timeOfOnsetOfSymptoms(5)
                .infectiousTime(4)
                .reductionByRestrictions(0.5)
                .quarantineRate(0.5)
                .percentageOfPopulationWhenRestrictionsBegins(0.01)
                .immunityTime(60)
                .diseaseDeathRate(0.05)
                .daysOfRestrictions(60)
                .diseaseDuration(15)
                .timeOfDyingFromIncubation(7)
                .incubationTime(4)
                .build();

        SeirdsRecordCreator recordCreator = new SeirdsRecordCreator(simulation);
        recordCreator.createRecords()
                .forEach( v -> Assertions.assertEquals(
                        simulation.getPopulation(),
                        v.getSusceptible() + v.getExposed() + v.getInfected() + v.getRecovered() + v.getDeaths()));
    }

}
