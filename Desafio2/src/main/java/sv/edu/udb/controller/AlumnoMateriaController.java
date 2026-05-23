package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.entity.AlumnoMateria;
import sv.edu.udb.service.AlumnoMateriaService;

import java.util.List;

@RestController
@RequestMapping("/alumno-materia")
public class AlumnoMateriaController {

    @Autowired
    private AlumnoMateriaService alumnoMateriaService;

    @GetMapping
    public List<AlumnoMateria> getAll() {
        return alumnoMateriaService.getAll();
    }

    @PostMapping
    public AlumnoMateria create(@RequestBody AlumnoMateria alumnoMateria) {
        return alumnoMateriaService.save(alumnoMateria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alumnoMateriaService.delete(id);
    }
}