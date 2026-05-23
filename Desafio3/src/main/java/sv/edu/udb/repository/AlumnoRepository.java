package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}