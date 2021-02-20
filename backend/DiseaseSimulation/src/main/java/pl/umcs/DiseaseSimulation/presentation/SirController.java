package pl.umcs.DiseaseSimulation.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.umcs.DiseaseSimulation.aplication.dto.sir.SirDto;
import pl.umcs.DiseaseSimulation.aplication.service.SirService;
import pl.umcs.DiseaseSimulation.domain.agregate.sir.Sir;
import java.util.List;

@RestController
@RequestMapping("api/sir")
public class SirController {
    @Autowired
    SirService service;

    public SirController(SirService sirService) {
        this.service = sirService;
    }

    @PostMapping
    public SirDto addSimulation(@RequestBody Sir sir) {
        return service.addSimulation(sir);
    }

    @GetMapping("/all")
    public List<SirDto> findAll() {
        return service.findAll();
    }

    @PutMapping()
    public SirDto updateSimulation(@RequestBody Sir simulation) {
        return service.updateSimulation(simulation);
    }

    @DeleteMapping("/{id}")
    public void deleteSimulation(@PathVariable int id) {
        service.deleteSimulation(id);
    }
}
