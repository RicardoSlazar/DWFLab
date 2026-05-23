package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import sv.edu.udb.entity.Profesor;
import sv.edu.udb.service.ProfesorService;

import java.util.List;

@RestController
@RequestMapping("/profesores")
@CrossOrigin(origins = "*")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    //Obtener Todos

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Profesor> getAll() {
        return profesorService.getAll();

    }

    //Obtener por ID

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Profesor getById(
            @PathVariable Long id
    ) {
        return profesorService.getById(id);
    }

    //Crear

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Profesor create(
            @RequestBody Profesor profesor
    ) {
        return profesorService.save(
                profesor
        );
    }

    //Actualizar

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Profesor update(
            @PathVariable Long id,
            @RequestBody Profesor profesor
    ) {
        profesor.setId(id);
        return profesorService.save(
                profesor
        );
    }

    //Eliminar

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void delete(
            @PathVariable Long id
    ) {
        profesorService.delete(id);
    }
}