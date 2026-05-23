package sv.edu.udb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.udb.entity.Materia;
import sv.edu.udb.repository.MateriaRepository;

import java.util.List;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<Materia> getAll() {
        return materiaRepository.findAll();
    }

    public Materia getById(Long id) {
        return materiaRepository.findById(id).orElse(null);
    }

    public Materia save(Materia materia) {
        return materiaRepository.save(materia);
    }

    public void delete(Long id) {
        materiaRepository.deleteById(id);
    }
}