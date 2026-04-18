package sv.edu.udb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.entity.Alumno;
import sv.edu.udb.repository.AlumnoRepository;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> getAll() {
        return alumnoRepository.findAll();
    }

    public Alumno getById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void delete(Long id) {
        alumnoRepository.deleteById(id);
    }
}