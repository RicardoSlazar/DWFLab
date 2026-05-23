INSERT INTO profesor(nombre) VALUES ('Carlos');
INSERT INTO profesor(nombre) VALUES ('Ana');
INSERT INTO profesor(nombre) VALUES ('Luis');
INSERT INTO profesor(nombre) VALUES ('Maria');
INSERT INTO profesor(nombre) VALUES ('Jose');

INSERT INTO materia(nombre, id_profesor) VALUES ('Matematica', 1);
INSERT INTO materia(nombre, id_profesor) VALUES ('Programacion', 2);
INSERT INTO materia(nombre, id_profesor) VALUES ('Fisica', 3);
INSERT INTO materia(nombre, id_profesor) VALUES ('Quimica', 4);
INSERT INTO materia(nombre, id_profesor) VALUES ('Historia', 5);

INSERT INTO alumno(nombre, apellido) VALUES ('Juan', 'Perez');
INSERT INTO alumno(nombre, apellido) VALUES ('Sofia', 'Lopez');
INSERT INTO alumno(nombre, apellido) VALUES ('Mario', 'Gomez');
INSERT INTO alumno(nombre, apellido) VALUES ('Laura', 'Martinez');
INSERT INTO alumno(nombre, apellido) VALUES ('Pedro', 'Hernandez');

INSERT INTO alumno_materia VALUES (1,1);
INSERT INTO alumno_materia VALUES (2,2);
INSERT INTO alumno_materia VALUES (3,3);
INSERT INTO alumno_materia VALUES (4,4);
INSERT INTO alumno_materia VALUES (5,5);