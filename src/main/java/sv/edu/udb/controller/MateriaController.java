package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import sv.edu.udb.entity.Materia;
import sv.edu.udb.service.MateriaService;

import java.util.List;

@RestController
@RequestMapping("/materias")
@CrossOrigin(origins = "*")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    //OBTENER TODOS

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Materia> getAll() {
        return materiaService.getAll();
    }

    //OBTENER POR ID

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Materia getById(
            @PathVariable Long id
    ) {
        return materiaService.getById(id);
    }

    //Crear

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Materia create(
            @RequestBody Materia materia
    ) {
        return materiaService.save(
                materia
        );
    }

    //Actualizar

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Materia update(
            @PathVariable Long id,
            @RequestBody Materia materia
    ) {
        materia.setId(id);
        return materiaService.save(
                materia
        );
    }

    //Eliminar

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void delete(
            @PathVariable Long id
    ) {
        materiaService.delete(id);
    }
}