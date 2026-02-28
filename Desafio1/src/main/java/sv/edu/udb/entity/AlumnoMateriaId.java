package sv.edu.udb.entity;

import java.io.Serializable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoMateriaId implements Serializable {
    private Long idAlumno;
    private Long idMateria;
}