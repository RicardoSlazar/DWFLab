package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import sv.edu.udb.entity.AlumnoMateria;
import sv.edu.udb.service.AlumnoMateriaService;

import java.util.List;

@RestController
@RequestMapping("/alumno-materia")
@CrossOrigin(origins = "*")
public class AlumnoMateriaController {

    @Autowired
    private AlumnoMateriaService alumnoMateriaService;

    //Obtener Todos
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<AlumnoMateria> getAll() {
        return alumnoMateriaService.getAll();
    }


    //CREAR

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public AlumnoMateria create(
            @RequestBody AlumnoMateria alumnoMateria
    ) {
        return alumnoMateriaService.save(
                alumnoMateria
        );
    }

    //ELIMINAR

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void delete(
            @PathVariable Long id
    ) {
        alumnoMateriaService.delete(id);
    }
}