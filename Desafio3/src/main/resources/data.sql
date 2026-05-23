DELETE FROM alumno_materia;
DELETE FROM alumno;
DELETE FROM materia;
DELETE FROM profesor;

ALTER TABLE alumno AUTO_INCREMENT=1;
ALTER TABLE profesor AUTO_INCREMENT=1;
ALTER TABLE materia AUTO_INCREMENT=1;
ALTER TABLE alumno_materia AUTO_INCREMENT=1;


INSERT INTO profesor(nombre)
VALUES
    ('Juan Perez'),
    ('Maria Lopez'),
    ('Carlos Gomez'),
    ('Ana Torres'),
    ('Luis Hernandez');


INSERT INTO materia(nombre,id_profesor)
VALUES
    ('Matematica',1),
    ('Historia',2),
    ('Fisica',3),
    ('Quimica',4),
    ('Ingles',5);


INSERT INTO alumno(nombre,apellido)
VALUES
    ('Pedro','Martinez'),
    ('Sofia','Ramirez'),
    ('Jose','Castro'),
    ('Lucia','Flores'),
    ('Miguel','Vargas');


INSERT INTO alumno_materia(
    alumno_id,
    materia_id,
    nota
)
VALUES
    (1,1,8.5),
    (1,2,7.0),
    (2,3,9.5),
    (3,4,6.5),
    (4,5,10);