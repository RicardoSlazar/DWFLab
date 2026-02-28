package sv.edu.udb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import sv.edu.udb.entity.*;
import sv.edu.udb.repository.*;

@SpringBootTest
@Transactional
public class Desafio1ApplicationTests {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private AlumnoMateriaRepository alumnoMateriaRepository;

    @Test
    @Commit
    void insertarDatos() {

        Profesor p1 = profesorRepository.save(new Profesor(null, "Ricardo"));
        Profesor p2 = profesorRepository.save(new Profesor(null, "Andres"));

        Materia m1 = materiaRepository.save(new Materia(null, "Base de Datos", p1.getId()));
        Materia m2 = materiaRepository.save(new Materia(null, "Programacion", p2.getId()));

        Alumno a1 = alumnoRepository.save(new Alumno(null, "Kevin", "Ruiz"));
        Alumno a2 = alumnoRepository.save(new Alumno(null, "Daniela", "Flores"));

        alumnoMateriaRepository.save(new AlumnoMateria(a1.getId(), m1.getId()));
        alumnoMateriaRepository.save(new AlumnoMateria(a2.getId(), m2.getId()));
    }
}