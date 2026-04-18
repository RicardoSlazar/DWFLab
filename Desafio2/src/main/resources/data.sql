INSERT INTO profesor(nombre) VALUES
                                 ('Juan Perez'),
                                 ('Maria Lopez'),
                                 ('Carlos Gomez'),
                                 ('Ana Torres'),
                                 ('Luis Hernandez');

INSERT INTO materia(nombre, id_profesor) VALUES
                                             ('Matematica', 1),
                                             ('Historia', 2),
                                             ('Fisica', 3),
                                             ('Quimica', 4),
                                             ('Ingles', 5);

INSERT INTO alumno(nombre, apellido) VALUES
                                         ('Pedro', 'Martinez'),
                                         ('Sofia', 'Ramirez'),
                                         ('Jose', 'Castro'),
                                         ('Lucia', 'Flores'),
                                         ('Miguel', 'Vargas');

INSERT INTO alumno_materia(id_alumno, id_materia) VALUES
                                                      (1,1),
                                                      (1,2),
                                                      (2,3),
                                                      (3,4),
                                                      (4,5);