package pl.umcs.diseasesimulation.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.umcs.diseasesimulation.aplication.dto.seirds.SeirdsDto;
import pl.umcs.diseasesimulation.aplication.service.seirds.SeirdsService;
import pl.umcs.diseasesimulation.domain.agregate.seirds.Seirds;

import java.util.List;

@RestController
@RequestMapping("api/seirds")
@CrossOrigin
public class SeirdsController {
    @Autowired
    SeirdsService service;

    public SeirdsController(SeirdsService service) {
        this.service = service;
    }

    @PostMapping
    public SeirdsDto addSimulation(@RequestBody Seirds simulation) {
        return service.addSimulation(simulation);
    }

    @GetMapping("/all")
    public List<SeirdsDto> findAll() {
        return service.findAll();
    }

    @PutMapping
    public SeirdsDto updateSimulation(@RequestBody Seirds simulation) {
        return service.updateSimulation(simulation);
    }

    @DeleteMapping("/{id}")
    public void deleteSimulation(@PathVariable("id") int id) {
        System.out.println(id);
        service.deleteSimulation(id);
    }
}
