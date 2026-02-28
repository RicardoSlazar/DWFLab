package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.entity.AlumnoMateria;
import sv.edu.udb.entity.AlumnoMateriaId;

public interface AlumnoMateriaRepository extends JpaRepository<AlumnoMateria, AlumnoMateriaId> {
}