package sv.edu.udb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.entity.Profesor;
import sv.edu.udb.repository.ProfesorRepository;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> getAll() {
        return profesorRepository.findAll();
    }

    public Profesor getById(Long id) {
        return profesorRepository.findById(id).orElse(null);
    }

    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public void delete(Long id) {
        profesorRepository.deleteById(id);
    }
}