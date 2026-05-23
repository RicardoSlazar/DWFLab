package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.entity.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
}