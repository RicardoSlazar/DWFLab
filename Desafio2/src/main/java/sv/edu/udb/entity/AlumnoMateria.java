package sv.edu.udb.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class AlumnoMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Alumno alumno;

    @ManyToOne
    private Materia materia;
}