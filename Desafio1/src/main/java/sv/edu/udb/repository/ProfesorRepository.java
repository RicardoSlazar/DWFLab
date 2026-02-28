package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.entity.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}