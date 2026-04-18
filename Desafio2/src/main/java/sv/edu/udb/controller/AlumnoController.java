package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.entity.Alumno;
import sv.edu.udb.service.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAll() {
        return alumnoService.getAll();
    }

    @GetMapping("/{id}")
    public Alumno getById(@PathVariable Long id) {
        return alumnoService.getById(id);
    }

    @PostMapping
    public Alumno create(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }

    @PutMapping("/{id}")
    public Alumno update(@PathVariable Long id, @RequestBody Alumno alumno) {
        alumno.setId(id);
        return alumnoService.save(alumno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alumnoService.delete(id);
    }
}