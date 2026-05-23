package sv.edu.udb.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alumno_materia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(AlumnoMateriaId.class)
public class AlumnoMateria {

    @Id
    @Column(name = "id_alumno")
    private Long idAlumno;

    @Id
    @Column(name = "id_materia")
    private Long idMateria;
}