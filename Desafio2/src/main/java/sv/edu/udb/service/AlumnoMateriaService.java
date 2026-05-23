package sv.edu.udb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.entity.AlumnoMateria;
import sv.edu.udb.repository.AlumnoMateriaRepository;

import java.util.List;

@Service
public class AlumnoMateriaService {

    @Autowired
    private AlumnoMateriaRepository alumnoMateriaRepository;

    public List<AlumnoMateria> getAll() {
        return alumnoMateriaRepository.findAll();
    }

    public AlumnoMateria save(AlumnoMateria alumnoMateria) {
        return alumnoMateriaRepository.save(alumnoMateria);
    }

    public void delete(Long id) {
        alumnoMateriaRepository.deleteById(id);
    }
}