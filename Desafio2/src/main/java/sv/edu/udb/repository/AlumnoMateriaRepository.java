package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.entity.AlumnoMateria;

public interface AlumnoMateriaRepository extends JpaRepository<AlumnoMateria, Long> {
}