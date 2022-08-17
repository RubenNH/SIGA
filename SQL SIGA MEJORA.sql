DROP DATABASE IF EXISTS SIGA;
CREATE DATABASE SIGA;
use SIGA;

-- -----------------------------------------------------
-- Table Cuatrimestre
-- -----------------------------------------------------
CREATE TABLE  Cuatrimestre (
  idCuatri bigint NOT NULL,
  nombre VARCHAR(45) NULL,
  PRIMARY KEY (idCuatri))
;

-- -----------------------------------------------------
-- Table Carreras
-- -----------------------------------------------------
CREATE TABLE  Carreras (
  idCarrera bigint NOT NULL,
  nombre VARCHAR(45) NULL,
  PRIMARY KEY (idCarrera))
;

-- -----------------------------------------------------
-- Table Materias
-- -----------------------------------------------------
CREATE TABLE  Materias (
  idMaterias bigint NOT NULL auto_increment,
  nombre VARCHAR(45) not NULL,
  PRIMARY KEY (idMaterias))
;

-- -----------------------------------------------------
-- Table As_Estados
-- -----------------------------------------------------
CREATE TABLE  Estados (
  id_Estados bigint NOT NULL,
  estado bigint not NULL,
  PRIMARY KEY (id_Estados))
;
-- estado --
-- 1- Pendiente--
-- 2- Impartida--
-- 3- Falta--
-- 4- Csncelada--
-- 5- Desconocido--


-- -----------------------------------------------------
-- Table Usuarios
-- -----------------------------------------------------
CREATE TABLE Users(
id_Users bigint primary key auto_increment,
username varchar(50) not null unique,
password varchar(50) not null,
estatus bigint not null,
nombres VARCHAR(45) not NULL,
apellidos VARCHAR(45) not NULL
);  
-- estatus --
-- 1- estudiante--
-- 2- Profesor--
-- 3- Administrador--


-- -----------------------------------------------------
-- Table Profesores
-- -----------------------------------------------------
CREATE TABLE  Profesores (
  idProfesores bigint NOT NULL auto_increment,
  Fk_User bigint not null,
  PRIMARY KEY (idProfesores, Fk_User),
  CONSTRAINT fk_Profesores_Users
    FOREIGN KEY (Fk_User)
    REFERENCES Users (id_Users))
;

-- -----------------------------------------------------
-- Table Admin
-- -----------------------------------------------------
CREATE TABLE  Administrador (
  idAdmin bigint NOT NULL auto_increment,
  Fk_User bigint NOT NULL,
  PRIMARY KEY (idAdmin, Fk_User),
  CONSTRAINT fk_Administrador_Users
    FOREIGN KEY (Fk_User)
    REFERENCES Users (id_Users))
;

-- -----------------------------------------------------
-- Table Estudiante
-- -----------------------------------------------------
CREATE TABLE  Estudiante (
  id_Matricula bigint NOT NULL,
  telefono VARCHAR(15) NULL,
  genero bigint NULL,
  Fk_Usuario bigint NOT NULL,
  Fk_Carrera bigint NOT NULL,
  Fk_Cuatri bigint NOT NULL,
  PRIMARY KEY (id_Matricula, Fk_Usuario),
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
-- Table Asesorias
-- -----------------------------------------------------
CREATE TABLE  Asesorias (
  idAsesorias bigint not null auto_increment,
  tema VARCHAR(80) not NULL,
  duda VARCHAR(180)  not NULL,
  tiempo bigint null,
  visibilidadP bigint default 1,
  visibilidadE bigint default 1,
  FkProfesores bigint,
  FkEstados bigint,
  FkMatricula bigint,
  PRIMARY KEY (idAsesorias, FkProfesores, FkEstados, FkMatricula),
  CONSTRAINT fk_Asesorias_Profesores
    FOREIGN KEY (FkProfesores)
    REFERENCES Profesores (idProfesores),
  CONSTRAINT fk_Asesorias_Estados
    FOREIGN KEY (FkEstados)
    REFERENCES Estados (id_Estados)
);

-- visivilidad --
-- 1- SI--
-- 2- no--



-- -----------------------------------------------------
-- Table materias_imparte
-- -----------------------------------------------------
CREATE TABLE  materias_imparte (
  Fk_Profesores bigint NOT NULL,
  Fk_Materias bigint NOT NULL,
  PRIMARY KEY (Fk_Profesores, Fk_Materias),
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
CREATE TABLE  carreras_cuatrimestres (
  Fk_Cuatri bigint NOT NULL,
  Fk_Carrera bigint NOT NULL,
  PRIMARY KEY (Fk_Cuatri, Fk_Carrera),
  CONSTRAINT fk_carreras_cuatrimestres_Cuatrimestre
    FOREIGN KEY (Fk_Cuatri)
    REFERENCES Cuatrimestre (idCuatri),
  CONSTRAINT fk_carreras_cuatrimestres_Carreras
    FOREIGN KEY (Fk_Carrera)
    REFERENCES Carreras (idCarrera)
);

CREATE TABLE  Control_estadistico (
  idControl numeric NOT NULL,
  Fk_asesorias bigint,
  fecha sysdate,
  PRIMARY KEY (idControl))
    CONSTRAINT fk_control_estadistico_asesorias
    FOREIGN KEY (Fk_asesorias)
    REFERENCES Asesorias (idAsesorias)
;


-- -----------------------------------------------------
-- Inserts de datos
-- -----------------------------------------------------
insert into carreras values(1,'DSM');
insert into carreras values(2,'DM');
insert into carreras values(3,'IRD');
insert into carreras values(4,'DD');

insert into cuatrimestre values(1,'Primero');
insert into cuatrimestre values(2,'Segundo');
insert into cuatrimestre values(3,'Tercero');
insert into cuatrimestre values(4,'Cuarto');
insert into cuatrimestre values(5,'Quinto');

insert into materias values(1,'Calculo');
insert into materias values(2,'Base de Datos para Aplicaciones');
insert into materias values(3,'Aplicaciones Web');
insert into materias values(4,'Sistemas Operativos');
insert into materias values(5,'Ingles');

insert into Estados values(1,1);
insert into Estados values(2,2);
insert into Estados values(3,3);
insert into Estados values(4,4);

insert into carreras_cuatrimestres values(1,1);
insert into carreras_cuatrimestres values(1,2);
insert into carreras_cuatrimestres values(1,3);
insert into carreras_cuatrimestres values(1,4);
insert into carreras_cuatrimestres values(2,1);
insert into carreras_cuatrimestres values(2,2);
insert into carreras_cuatrimestres values(2,3);
insert into carreras_cuatrimestres values(2,4);
insert into carreras_cuatrimestres values(3,1);
insert into carreras_cuatrimestres values(3,2);
insert into carreras_cuatrimestres values(3,3);
insert into carreras_cuatrimestres values(3,4);
insert into carreras_cuatrimestres values(4,1);
insert into carreras_cuatrimestres values(4,2);
insert into carreras_cuatrimestres values(4,3);
insert into carreras_cuatrimestres values(4,4);
insert into carreras_cuatrimestres values(5,1);
insert into carreras_cuatrimestres values(5,2);
insert into carreras_cuatrimestres values(5,3);
insert into carreras_cuatrimestres values(5,4);

insert into Users (username, password, estatus, nombres, apellidos) 
values('20193tn142@utez.edu.mx','123',1,'Luis Darien', 'Fragoso Valencia');
insert into Users (username, password, estatus, nombres, apellidos) 
values('20213tn070@utez.edu.mx','234',1,'Carlos', 'Lopez Piña');
insert into Users (username, password, estatus, nombres, apellidos) 
values('20213tn071@utez.edu.mx','345',2,'Diego Antonio', 'Luna Ortiz');
insert into Users (username, password, estatus, nombres, apellidos) 
values('20213tn068@utez.edu.mx','456',2,'Mauro Aldebaran', 'Jimenez Garcia');
insert into Users (username, password, estatus, nombres, apellidos) 
values('20213tn134@utez.edu.mx','567',3,'Yocelin', 'Reyes López');

insert into Estudiante (id_Matricula, telefono, genero, Fk_Usuario, Fk_Carrera, Fk_Cuatri) 
values(20193142,'7772135593',1,1,3,1);
insert into Estudiante (id_Matricula, telefono, genero, Fk_Usuario, Fk_Carrera, Fk_Cuatri) 
values(20213070,'7771029575',1,2,2,3);

insert into Profesores (Fk_User) 
values(3);
insert into Profesores (Fk_User) 
values(4);

insert into Administrador (Fk_User) 
values(5);

insert into materias_imparte values(1,1);
insert into materias_imparte values(2,2);
insert into materias_imparte values(1,3);
insert into materias_imparte values(2,4);
insert into materias_imparte values(1,5);

insert into asesorias (tema, duda, FkProfesores, FkEstados, FkMatricula) 
value ('Cruds1','no se hacer cruds :(',1,1,20213071);
insert into asesorias (tema, duda, FkProfesores, FkEstados, FkMatricula) 
value ('Cruds2','no se hacer cruds :(',1,1,20213071);
insert into asesorias (tema, duda, FkProfesores, FkEstados, FkMatricula) 
value ('Cruds3','no se hacer cruds :(',1,1,20213071);
insert into asesorias (tema, duda, FkProfesores, FkEstados, FkMatricula) 
value ('Cruds4','no se hacer cruds :(',1,1,20213071);
insert into asesorias (tema, duda, FkProfesores, FkEstados, FkMatricula) 
value ('Cruds5','no se hacer cruds :(',1,1,20213071);


select * from users;
select * from Asesorias;
select * from Profesores;
select * from Estudiante;
select * from As_Estados;

create or replace trigger Asesorias
FOR EACH ROW
BEGIN
INSERT INTO CONTROL VALUES(USER, SYSDATE);
END;
