-- Se crea un usuario en especifico para la creacion y manejo de base de datos. Para que no se ingrese con system y para que solo existan las tablas del proyecto. Se crea dba_user junto con un espacio de trabajo solamente para el; se le otorgan todos los permisos.


create tablespace espaciodba
datafile 'espaciodba.dbf'
size 10M;

alter session set "_ORACLE_SCRIPT"=true;

create user dba_user identified by dba123
default tablespace espaciodba
quota 10M on espaciodba;

grant all privileges to dba_user;

---------------------------------------------------------------------



-- -----------------------------------------------------
-- Table Cuatrimestre
-- -----------------------------------------------------
CREATE TABLE  Cuatrimestre (
                               idCuatri number(10) NOT NULL,
                               cuatrimestre VARCHAR(45) NULL,
                               PRIMARY KEY (idCuatri))
;

CREATE TABLE  Estados (
                          idEstados number(10) NOT NULL,
                          estado VARCHAR(45) NULL,
                          PRIMARY KEY (idEstados))
;
-- estado --
-- 1- Pendiente--
-- 2- Impartida--
-- 3- Falta--
-- 4- Csncelada--
-- 5- Retardo--

-- -----------------------------------------------------
-- Table Carreras
-- -----------------------------------------------------
CREATE TABLE  Carreras (
                           idCarrera number(10) NOT NULL,
                           carreras VARCHAR(45) NULL,
                           PRIMARY KEY (idCarrera))
;

-- -----------------------------------------------------
-- Table Materias
-- -----------------------------------------------------
CREATE TABLE  Materias (
                           idMaterias number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                           nombre VARCHAR(100) not NULL,
                           PRIMARY KEY (idMaterias))
;




-- -----------------------------------------------------
-- Table Usuarios
-- -----------------------------------------------------
CREATE TABLE Users(
                      id_Users number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                      username varchar (50)  not null unique,
                      password varchar(50) not null,
                      estatus number(10),
                      permiso number(10) default 1,
                      PRIMARY KEY (id_Users)
);
-- estatus --
-- 1- estudiante--
-- 2- Profesor--
-- 3- Administrador--


-- -----------------------------------------------------
-- Table Profesores
-- -----------------------------------------------------
drop table Profesores;
CREATE TABLE  Profesores (
                             idProfesores number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                             Fk_User number(10) not null,
                             docente VARCHAR(45) not NULL,
                             apeDocente VARCHAR(45) not NULL,
                             PRIMARY KEY (idProfesores),
                             CONSTRAINT fk_Profesores_Users
                                 FOREIGN KEY (Fk_User)
                                     REFERENCES Users (id_Users))
;

-- -----------------------------------------------------
-- Table Admin
-- -----------------------------------------------------
CREATE TABLE  Administrador (
                                idAdmin number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                                Fk_User number(10) NOT NULL,
                                PRIMARY KEY (idAdmin, Fk_User),
                                CONSTRAINT fk_Administrador_Users
                                    FOREIGN KEY (Fk_User)
                                        REFERENCES Users (id_Users))
;

-- -----------------------------------------------------
-- Table Estudiante
-- -----------------------------------------------------
drop table ESTUDIANTE;
CREATE TABLE  Estudiante (
                             id_Matricula VARCHAR(15) NOT NULL,
                             telefono number(10) NULL,
                             genero number(10) NULL,
                             alumno VARCHAR(45) not NULL,
                             apeAlumno VARCHAR(45) not NULL,
                             Fk_Usuario number(10) NOT NULL,
                             Fk_Carrera number(10) NOT NULL,
                             Fk_Cuatri number(10) NOT NULL,
                             PRIMARY KEY (id_Matricula),
                             CONSTRAINT fk_Estudiante_Users
                                 FOREIGN KEY (Fk_Usuario)
                                     REFERENCES Users (id_Users),
                             CONSTRAINT fk_Estudiante_Carreras
                                 FOREIGN KEY (Fk_Carrera)
                                     REFERENCES Carreras (idCarrera),
                             CONSTRAINT fk_Estudiante_Cuatri1
                                 FOREIGN KEY (Fk_Cuatri)
                                     REFERENCES Cuatrimestre (idCuatri))
;
-- genero --
-- 1- Hombre--
-- 2- Mujer--
-- 3- Otro--



-- -----------------------------------------------------
-- Table materias_imparte
-- -----------------------------------------------------
CREATE TABLE  materias_imparte (
                                   idP number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                                   Fk_Profesores number(10) NOT NULL,
                                   Fk_Materias number(10) NOT NULL,
                                   PRIMARY KEY (idP,Fk_Profesores, Fk_Materias),
                                   CONSTRAINT materias_imparte_Profesores
                                       FOREIGN KEY (Fk_Profesores)
                                           REFERENCES Profesores (idProfesores),
                                   CONSTRAINT materias_imparte_Materias
                                       FOREIGN KEY (Fk_Materias)
                                           REFERENCES Materias (idMaterias)
);

-- -----------------------------------------------------
-- Table carreras_cuatrimestres
-- -----------------------------------------------------
CREATE TABLE datosM (
                        idP number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                        Fk_Carrera number(10) NOT NULL,
                        Fk_Cuatri number(10) NOT NULL,
                        Fk_Materia number(10) NOT NULL,
                        PRIMARY KEY(idP),
                        CONSTRAINT fk_carreras_cuatrimestres_materias_Cuatrimestre
                            FOREIGN KEY (Fk_Cuatri)
                                REFERENCES Cuatrimestre (idCuatri),
                        CONSTRAINT fk_carreras_cuatrimestres_materias_Carreras
                            FOREIGN KEY (Fk_Carrera)
                                REFERENCES Carreras (idCarrera),
                        CONSTRAINT fk_carreras_cuatrimestres_materias_Materias
                            FOREIGN KEY (Fk_Materia)
                                REFERENCES Materias (idMaterias)
);

-- -----------------------------------------------------
-- Table Asesorias
-- -----------------------------------------------------
CREATE TABLE  Asesorias (
                            idAsesorias number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                            tema VARCHAR(80) not NULL,
                            duda VARCHAR(180)  not NULL,
                            tiempo number(10) null,
                            razonCan VARCHAR(80) NULL,
                            visibilidadP number(10) default 1,
                            visibilidadE number(10) default 1,
                            FkEstados number(10) default 1,
                            FkProfesores number(10),
                            FkMatricula varchar(15),
                            FkMateria number(10),
                            fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            PRIMARY KEY (idAsesorias),
                            CONSTRAINT fk_Asesorias_Profesores
                                FOREIGN KEY (FkProfesores)
                                    REFERENCES Profesores (idProfesores),
                            CONSTRAINT fk_Asesorias_Estudiante
                                FOREIGN KEY (FkMatricula)
                                    REFERENCES Estudiante (id_Matricula),
                            CONSTRAINT fk_Asesorias_Materias
                                FOREIGN KEY (FkMateria)
                                    REFERENCES Materias (idMaterias),
                            CONSTRAINT fk_Asesorias_Estados
                                FOREIGN KEY (FkEstados)
                                    REFERENCES Estados (idEstados)
);
-- estado --
-- 1- Pendiente--
-- 2- Impartida--
-- 3- Falta--
-- 4- Csncelada--
-- 5- Desconocido--

-- visivilidad --
-- 1- SI--
-- 2- no--

create table logincount(
                           id number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                           dia timestamp default current_timestamp,
                           FkUser varchar(40),
                           PRIMARY KEY (id),
                           CONSTRAINT fk_logincount_User
                               FOREIGN KEY (FkUser)
                                   REFERENCES users (username)
);


CREATE TABLE  Control_estadistico (
                                      idControl number(10) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
                                      usuario VARCHAR(45) NULL,
                                      fecha DATE NULL,
                                      accion VARCHAR(45) NULL,
                                      tabla VARCHAR(45) NULL,
                                      PRIMARY KEY (idControl))
;

-- -----------------------------------------------------
-- Inserts de datos
-- -----------------------------------------------------
insert into Carreras values(1,'DSM');
insert into Carreras values(2,'DM');
insert into Carreras values(3,'IRD');
insert into Carreras values(4,'DD');

insert into Cuatrimestre values(1,'Primero');
insert into Cuatrimestre values(2,'Segundo');
insert into Cuatrimestre values(3,'Tercero');
insert into Cuatrimestre values(4,'Cuarto');
insert into Cuatrimestre values(5,'Quinto');

insert into Materias (nombre) values('Calculo diferencial');
insert into Materias (nombre) values('Base de Datos para Aplicaciones');
insert into Materias (nombre) values('Aplicaciones Web');
insert into Materias (nombre) values('Sistemas Operativos');
insert into Materias (nombre) values('Ingles I');
insert into Materias (nombre) values('Álgebra lineal');
insert into Materias (nombre) values('Desarrollo de habilidades de pensamiento lógico');
insert into Materias (nombre) values('Fundamentos de TI');
insert into Materias (nombre) values('Fundamentos de redes');
insert into Materias (nombre) values('Metodología de la programación');
insert into Materias (nombre) values('Expresion oral y escrita I');
insert into Materias (nombre) values('Formación sociocultural I');
insert into Materias (nombre) values('Funciones matemáticas');
insert into Materias (nombre) values('Metodologías y modelado de desarrollo de software');
insert into Materias (nombre) values('Interconexión de redes');
insert into Materias (nombre) values('Programación orientada a objetos');
insert into Materias (nombre) values('Base de Datos para Aplicaciones');
insert into Materias (nombre) values('Introducción al diseño digital');
insert into Materias (nombre) values('Base de datos');
insert into Materias (nombre) values('Probabilidad y estadística');
insert into Materias (nombre) values('Estándares y métricas para el desarrollo de software');
insert into Materias (nombre) values('Principios para IoT');
insert into Materias (nombre) values('Diseño de apps');
insert into Materias (nombre) values('Estructura de datos aplicadas');
insert into Materias (nombre) values('Aplicaciones web orientadas a servicios');
insert into Materias (nombre) values('Evaluación y mejora para el desarrollo de software');
insert into Materias (nombre) values('Aplicaciones de IoT');
insert into Materias (nombre) values('Desarrollo móvil multiplataforma');
insert into Materias (nombre) values('Aplicaciones web para 14.0');
insert into Materias (nombre) values('Introducción a Big Data');
insert into Materias (nombre) values('Administración de redes de datos');
insert into Materias (nombre) values('Base de Datos para Aplicaciones');
insert into Materias (nombre) values('Programación de redes');
insert into Materias (nombre) values('Bases de datos para cómputo en la nube');
insert into Materias (nombre) values('Infraestructura de redes de datos');
insert into Materias (nombre) values('Electrónica para IdC');
insert into Materias (nombre) values('Conexiones de redes WAN');
insert into Materias (nombre) values('Administración de servidores I');
insert into Materias (nombre) values('Administración de servidores II');
insert into Materias (nombre) values('Infomática para diseño de moda');
insert into Materias (nombre) values('Creatividad del diseño');
insert into Materias (nombre) values('Técnicas de ilustración');
insert into Materias (nombre) values('Patronaje industrial para dama');
insert into Materias (nombre) values('Métodos de confección I');
insert into Materias (nombre) values('Historia del arte y la moda');
insert into Materias (nombre) values('Fundamentos textiles I');
insert into Materias (nombre) values('Teoría del color');
insert into Materias (nombre) values('Ilustración de modas por computadora I');
insert into Materias (nombre) values('Patronaje industrial para caballero y niño');
insert into Materias (nombre) values('Matemáticas');
insert into Materias (nombre) values('Ilustración de modas por computadora II');
insert into Materias (nombre) values('Métodos de confección II');
insert into Materias (nombre) values('Sistemas de graduación industrial');
insert into Materias (nombre) values('Fundamentos textiles II');
insert into Materias (nombre) values('Metodología de la investigación');
insert into Materias (nombre) values('Estadística');
insert into Materias (nombre) values('Costos de manufactura');
insert into Materias (nombre) values('Planeación de la producción');
insert into Materias (nombre) values('Mercadotecnia de la moda');
insert into Materias (nombre) values('Patronaje por computadora');
insert into Materias (nombre) values('Calidad en la industria del vestido');
insert into Materias (nombre) values('Sistemas de confección industrial');
insert into Materias (nombre) values('Procesos de manufactura');
insert into Materias (nombre) values('Graduación por computadora');
insert into Materias (nombre) values('Fundamentos del diseño');
insert into Materias (nombre) values('Representación visual');
insert into Materias (nombre) values('Fundamentos de la comunicación gráfica');
insert into Materias (nombre) values('Informática aplicada al diseño');
insert into Materias (nombre) values('Geometría');
insert into Materias (nombre) values('Elementos del lenguaje visual');
insert into Materias (nombre) values('Ilustración I');
insert into Materias (nombre) values('Modelado manual');
insert into Materias (nombre) values('Representación geométrica');
insert into Materias (nombre) values('Levantamiento de objetos y espacios');
insert into Materias (nombre) values('Proceso administrativo');
insert into Materias (nombre) values('Costos');
insert into Materias (nombre) values('Ilustración II');
insert into Materias (nombre) values('Fotografía digital');
insert into Materias (nombre) values('Mercadotecnia');
insert into Materias (nombre) values('Software CAD');
insert into Materias (nombre) values('Física');
insert into Materias (nombre) values('Animación 2D');
insert into Materias (nombre) values('Guionismo y storyboard');
insert into Materias (nombre) values('Prototipos');
insert into Materias (nombre) values('Proceso de diseño');
insert into Materias (nombre) values('Diseño editorial digital');
insert into Materias (nombre) values('Animación en 3D');
insert into Materias (nombre) values('Edición de audio y video');
insert into Materias (nombre) values('Imagen digital animada');
insert into Materias (nombre) values('Expresión Oral y Escrita II');
insert into Materias (nombre) values('Inglés V');
insert into Materias (nombre) values('Formación sociocultural IV');
insert into Materias (nombre) values('Formación sociocultural III');
insert into Materias (nombre) values('Inglés III');
insert into Materias (nombre) values('Inglés II');
insert into Materias (nombre) values('Formación sociocultural II');
insert into Materias (nombre) values('Integradora I');
insert into Materias (nombre) values('Inglés IV');
insert into Materias (nombre) values('Integradora II');
insert into Materias (nombre) values('Comunicacion en redes de datos');
insert into Materias (nombre) values('Ciberseguridad');

insert into Estados values(1,'Pendiente');
insert into Estados values(2,'Impartida');
insert into Estados values(3,'Falta');
insert into Estados values(4,'Cancelada');
insert into Estados values(5,'Rechazada');
insert into Estados values(6,'Retardo');


-- DSM C1--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,1,5);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,1,6);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,1,7);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,1,8);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,1,9);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,1,10);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,1,11);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,1,12);

-- DSM C2--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,2,13);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,2,14);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,2,15);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,2,16);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,2,18);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,2,19);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,2,96);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,2,95);

-- DSM C3--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,3,1);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,3,2);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,3,3);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,3,4);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,3,5);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,3,93);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,3,94);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,3,97);

-- DSM C4--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,4,21);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,4,22);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,4,23);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,4,24);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,4,25);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,4,26);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,4,92);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,4,98);

-- DSM C5--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,5,27);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,5,29);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,5,28);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,5,34);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,5,90);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,5,91);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(1,5,99);

-- MODAS C1--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,1,40);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,1,41);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,1,42);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,1,43);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,1,44);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,1,5);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,1,12);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,1,11);

-- MODAS C2--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,2,45);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,2,46);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,2,47);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,2,48);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,2,49);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,2,95);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,2,96);

-- MODAS C3--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,3,50);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,3,51);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,3,52);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,3,53);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,3,54);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,3,55);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,3,97);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,3,93);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,3,94);

-- MODAS C4--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,4,56);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,4,87);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,4,58);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,4,59);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,4,60);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,4,92);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,4,98);

-- MODAS C5--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,5,61);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,5,62);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,5,63);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,5,64);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,5,90);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,5,91);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(2,5,99);

-- REDES C1--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,1,5);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,1,6);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,1,7);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,1,8);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,1,9);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,1,10);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,1,11);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,1,12);

-- REDES C2--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,2,13);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,2,14);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,2,15);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,2,16);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,2,18);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,2,19);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,2,96);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,2,95);

-- REDES C3--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,3,1);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,3,4);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,3,100);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,3,3);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,3,35);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,3,93);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,3,94);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,3,97);

-- REDES C4--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,4,20);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,4,36);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,4,37);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,4,38);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,4,92);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,4,98);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,4,33);

-- REDES C5--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,5,30);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,5,31);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,5,39);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,5,90);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,5,91);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,5,99);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(3,5,101);

-- DIGITAL C1--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,1,11);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,1,12);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,1,5);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,1,66);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,1,67);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,1,68);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,1,65);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,1,50);

-- DIGITAL C2--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,2,69);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,2,70);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,2,71);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,2,72);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,2,73);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,2,74);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,2,96);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,2,95);

-- DIGITAL C3--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,3,75);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,3,76);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,3,77);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,3,78);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,3,79);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,3,80);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,3,93);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,3,94);

-- DIGITAL C4--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,4,81);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,4,82);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,4,83);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,4,84);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,4,85);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,4,86);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,4,92);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,4,97);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,4,98);

-- DIGITAL C5--
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,5,87);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,5,88);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,5,89);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,5,90);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,5,91);
insert into datosM (Fk_Carrera, Fk_Cuatri, Fk_Materia) values(4,5,99);

insert into Users (username, password, estatus)
values('20193tn142@utez.edu.mx','123',1);
insert into Users (username, password, estatus)
values('20213tn070@utez.edu.mx','234',1);
insert into Users (username, password, estatus)
values('20213tn071@utez.edu.mx','345',2);
insert into Users (username, password, estatus)
values('20213tn068@utez.edu.mx','456',2);
insert into Users (username, password, estatus)
values('20213tn134@utez.edu.mx','567',3);

insert into Estudiante (id_Matricula, alumno, apeAlumno, telefono, genero, Fk_Usuario, Fk_Carrera, Fk_Cuatri)
values(20193142,'Luis Darien', 'Fragoso Valencia','7772135593',1,1,3,1);
insert into Estudiante (id_Matricula, alumno, apeAlumno, telefono, genero, Fk_Usuario, Fk_Carrera, Fk_Cuatri)
values(20213070,'Carlos', 'Lopez Piña','7771029575',1,2,2,3);

insert into Profesores (Fk_User, docente, apeDocente)
values(3,'Diego Antonio', 'Luna Ortiz');
insert into Profesores (Fk_User, docente, apeDocente)
values(4,'Yocelin', 'Reyes López');

insert into Administrador (Fk_User)
values(5);

insert into materias_imparte (Fk_Profesores, Fk_Materias) values(1,1);
insert into materias_imparte (Fk_Profesores, Fk_Materias) values(2,2);
insert into materias_imparte (Fk_Profesores, Fk_Materias) values(1,3);
insert into materias_imparte (Fk_Profesores, Fk_Materias) values(2,4);
insert into materias_imparte (Fk_Profesores, Fk_Materias) values(1,5);

insert into Asesorias (tema, duda, FkProfesores, FkMatricula, FkMateria)
    values ('Cruds1','no se hacer cruds :(',1,20193142,1);
insert into Asesorias (tema, duda, FkProfesores, FkMatricula, FkMateria)
    values ('Cruds2','no se hacer cruds :(',2,20193142,1);
insert into Asesorias (tema, duda, FkProfesores, FkMatricula, FkMateria)
    values ('Cruds3','no se hacer cruds :(',1,20193142,1);
insert into Asesorias (tema, duda, FkProfesores, FkMatricula, FkMateria)
    values ('Cruds4','no se hacer cruds :(',1,20193142,1);
insert into Asesorias (tema, duda, FkProfesores, FkMatricula, FkMateria)
    values ('Cruds5','no se hacer cruds :(',1,20193142,1);
insert into Asesorias (tema, duda, FkProfesores, FkMatricula, FkMateria)
    values ('Cruds6','no se hacer cruds :(',1,20193142,1);


select * from users;
select * from Asesorias;
select * from Profesores;
select * from Estudiante;
select * from logincount;
create or replace view asesoriastotales as SELECT * from Asesorias join Estudiante on Asesorias.FkMatricula = Estudiante.id_Matricula join Profesores on Asesorias.FkProfesores = Profesores.idProfesores join Materias on Asesorias.FkMateria = Materias.idMaterias join Estados on Asesorias.FkEstados = Estados.idEstados JOIN users on users.id_Users = Estudiante.Fk_Usuario;
select * from asesoriastotales;

create or replace view locateUser as SELECT * from logincount order by id fetch next 1 row only;
select * from logincount;
select * from locateUser;

create or replace view asesoriastotalesP as SELECT * from Asesorias join Estudiante on Asesorias.FkMatricula = Estudiante.id_Matricula join Profesores on Asesorias.FkProfesores = Profesores.idProfesores join Materias on Asesorias.FkMateria = Materias.idMaterias join Estados on Asesorias.FkEstados = Estados.idEstados JOIN users on users.id_Users = Profesores.Fk_User;
select * from asesoriastotalesP;


-- update Asesorias set FkEstados = 2, tiempo = 14 where  not idAsesorias = 1 ;e--
update Asesorias set visibilidadP = 2 where FkProfesores = 2 and not(FkEstados = 1);

create or replace view borrarHistD as select * from locateUser join users on locateUser.FkUser = users.username join Profesores on users.id_Users = Profesores.Fk_User;
select * from borrarHistD;

create or replace view conteo as select count(*) as conteo from logincount join users on logincount.FkUser = users.username join Estudiante on users.id_Users = Estudiante.Fk_Usuario where 21 = extract(day from current_timestamp) ;
select * from conteo;

create or replace view conteoH as select count(*) as conteoH from logincount join users on logincount.FkUser = users.username join Estudiante on users.id_Users = Estudiante.Fk_Usuario where 21 = extract(day from current_timestamp) and genero = 1;
select * from conteoH;

create or replace view conteoM as select count(*) as conteoM from logincount join users on logincount.FkUser = users.username join Estudiante on users.id_Users = Estudiante.Fk_Usuario where 21 = extract(day from current_timestamp) and genero = 2;
select * from conteoM;

create or replace view conteoO as select count(*) as conteoO from logincount join users on logincount.FkUser = users.username join Estudiante on users.id_Users = Estudiante.Fk_Usuario where 21 = extract(day from current_timestamp) and genero = 3;
select * from conteoO;

create or replace view asesConteo as select count(*) as asesConteo from Asesorias join Estudiante on Asesorias.FkMatricula = Estudiante.id_Matricula where FkEstados = 2;
select * from asesConteo;

create or replace view asesConteoH as select count(*) as asesConteoH from Asesorias join Estudiante on Asesorias.FkMatricula = Estudiante.id_Matricula where FkEstados = 2 and genero = 1;
select * from asesConteoH;

create or replace view asesConteoM as select count(*) as asesConteoM from Asesorias join Estudiante on Asesorias.FkMatricula = Estudiante.id_Matricula where FkEstados = 2 and genero = 2;
select * from asesConteoM;

create or replace view asesConteoO as select count(*) as asesConteoO from Asesorias join Estudiante on Asesorias.FkMatricula = Estudiante.id_Matricula where FkEstados = 2 and genero = 3;
select * from asesConteoO;

create or replace view TodasMaterias as select * from datosM join Materias on datosM.Fk_Materia = Materias.idMaterias join Carreras on datosM.Fk_Carrera = Carreras.idCarrera join Cuatrimestre on datosM.Fk_Cuatri = Cuatrimestre.idCuatri;
select * from TodasMaterias;

