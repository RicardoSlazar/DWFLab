package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sv.edu.udb.entity.AlumnoMateria;

@Repository
public interface AlumnoMateriaRepository
        extends JpaRepository<AlumnoMateria, Long> {

    @Transactional
    void deleteByAlumno_Id(Long id);

}