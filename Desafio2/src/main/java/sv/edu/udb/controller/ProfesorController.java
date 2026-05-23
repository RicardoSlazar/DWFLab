package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.entity.Profesor;
import sv.edu.udb.service.ProfesorService;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<Profesor> getAll() {
        return profesorService.getAll();
    }

    @GetMapping("/{id}")
    public Profesor getById(@PathVariable Long id) {
        return profesorService.getById(id);
    }

    @PostMapping
    public Profesor create(@RequestBody Profesor profesor) {
        return profesorService.save(profesor);
    }

    @PutMapping("/{id}")
    public Profesor update(@PathVariable Long id, @RequestBody Profesor profesor) {
        profesor.setId(id);
        return profesorService.save(profesor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        profesorService.delete(id);
    }
}