package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.entity.Materia;
import sv.edu.udb.service.MateriaService;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public List<Materia> getAll() {
        return materiaService.getAll();
    }

    @GetMapping("/{id}")
    public Materia getById(@PathVariable Long id) {
        return materiaService.getById(id);
    }

    @PostMapping
    public Materia create(@RequestBody Materia materia) {
        return materiaService.save(materia);
    }

    @PutMapping("/{id}")
    public Materia update(@PathVariable Long id, @RequestBody Materia materia) {
        materia.setId(id);
        return materiaService.save(materia);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        materiaService.delete(id);
    }
}