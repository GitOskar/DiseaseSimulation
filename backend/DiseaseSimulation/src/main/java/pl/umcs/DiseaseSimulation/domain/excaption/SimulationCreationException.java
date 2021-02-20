package pl.umcs.diseasesimulation.domain.excaption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SimulationCreationException extends RuntimeException {
    public SimulationCreationException(String message) {
        super(message);
    }
}
