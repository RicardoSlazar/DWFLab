package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import sv.edu.udb.entity.Alumno;
import sv.edu.udb.service.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
@CrossOrigin(origins = "*")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    //OBTENER TODOS

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Alumno> getAll() {
        return alumnoService.getAll();
    }

    //OBTENER POR ID

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Alumno getById(
            @PathVariable Long id
    ) {
        return alumnoService.getById(id);
    }


    //CREAR

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Alumno create(
            @RequestBody Alumno alumno
    ) {
        return alumnoService.save(
                alumno
        );
    }

    //ACTUALIZAR

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Alumno update(
            @PathVariable Long id,
            @RequestBody Alumno alumno
    ) {
        alumno.setId(id);
        return alumnoService.save(
                alumno
        );
    }


    //ELIMINAR

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void delete(
            @PathVariable Long id
    ) {
        alumnoService.delete(id);
    }
}