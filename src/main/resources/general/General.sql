CREATE TABLE personasfam
(
    id_personasfam numeric(6,0) NOT NULL PRIMARY KEY,

    familia character varying(100)  NOT NULL,
    celular character(11) NOT NULL UNIQUE,
    zona character varying(100)  NOT NULL,
    nombrezona character varying(100) NOT NULL,
    tipovia character varying(100) NOT NULL,
    nomtipovia character varying(100) NOT NULL,
    referencia character varying(100) NOT NULL
  
);
	INSERT INTO personasFam(id_personasFam,familia,celular,zona,nombrezona,tipovia,nomtipovia,referencia)
VALUES(NEXTVAL('seq_personasfam'),'JARAMILLO RUIZ','944982935','AH','CALLERIA','MIRAFLORES','san isidro','por huacho')



create TABLE miembrosFam
(
    ID_miembrosFam numeric(6) NOT NULL primary key,
    Miembronombres character varying(100) NOT NULL,
    MiembroApellido character varying(100) NOT NULL,
    MiemFechaNacimiento date not null,
      MiembroDni CHAR(11),
	 estado CHAR(1) DEFAULT '1' NOT NULL 
);

create sequence SEQ_miembrosFam;

INSERT INTO miembrosfam(id_miembrosfam,Miembronombres,MiembroApellido,MiemFechaNacimiento,MiembroDni)
VALUES(NEXTVAL('SEQ_miembrosFam'),'Irwin Clever','Jaramillo Ruiz','2008/12/31','71994345')

CREATE TABLE Maestro_EstablecimientoS
(
	
    ID_EstablecimientoS numeric(6) NOT NULL PRIMARY KEY,
	
	codigoEstablecimiento character(100)  NOT NULL,
	nombreEstablecimiento character varying(100) NOT NULL,
	Red character varying(100) NOT NULL,
	Microred character varying(100) NOT NULL,
      estado CHAR(1) DEFAULT '1' NOT NULL 
);

	INSERT INTO Maestro_EstablecimientoS(id_EstablecimientoS,codigoEstablecimiento,nombreEstablecimiento,Red,Microred)
VALUES(NEXTVAL('SEQ_EstablecimientoS'),'00125','C.S NUEVO PARAISO','FEDERICO BASADRE','NUEVO PARAISO')



CREATE TABLE RED
(
	
    ID_Red numeric(6) NOT NULL PRIMARY KEY,
	
	
    nombre character varying(100) NOT NULL,
    descripcion character(100)  NOT NULL,
    abreviatura character varying(100)  NOT NULL,
      estado CHAR(1) DEFAULT '1' NOT NULL 
);


CREATE TABLE MICRORED
(
	
    ID_Microred numeric(6) NOT NULL PRIMARY KEY,
	
	
    nombre character varying(100) NOT NULL,
    descripcion character(100)  NOT NULL,
    abreviatura character varying(100)  NOT NULL,
      estado CHAR(1) DEFAULT '1' NOT NULL 
);



CREATE TABLE Empleados
(
	ID_Empleados numeric(6) NOT NULL PRIMARY KEY,
	id_personasfam numeric(6) references personasfam(id_personasfam),
	ID_EstablecimientoS numeric(6) references Maestro_EstablecimientoS(ID_EstablecimientoS),
	dniEmpleado char (12) NOT NULL UNIQUE,
    nombreEmpleado character varying(100) NOT NULL,
    ApellidoEmpleado character(100)  NOT NULL,
    Telefono character varying(20)  NOT NULL,
      estado CHAR(1) DEFAULT '1' NOT NULL 
);

create sequence SEQ_Empleados;








CREATE TABLE USUARIO 
   (    
	   ID_USUARIO numeric (4,0) NOT NULL PRIMARY KEY, 
	USUARIO VARCHAR(20) NOT NULL UNIQUE, 
	CLAVE VARCHAR(80) NOT NULL , 
	NOMBRE VARCHAR(120)NOT NULL,
	ESTADO CHAR(1) DEFAULT 1 NOT NULL
    );
CREATE SEQUENCE SEQ_USUARIO;
  
INSERT INTO USUARIO(ID_USUARIO ,USUARIO,CLAVE,NOMBRE)
VALUES(NEXTVAL('SEQ_USUARIO'),'ADMIN','$2a$10$avI31psAqUEfKe3HPa2rHu3x0mxt206tlBsxuZEskGh3Qc0jtMCRC','ADMINISTRADOR');
 INSERT INTO USUARIO(ID_USUARIO ,USUARIO,CLAVE,NOMBRE)
VALUES(SEQ_USUARIO.NEXTVAL,'DEMO','$2a$10$i0Vvxq8fK0x5rxrtHvq6duO1.9AX6J/O23cM9D09aqKUzzpP1kOO2','DEMO');
COMMIT;

INSERT INTO Empleados(ID_Empleados,id_personasfam,ID_EstablecimientoS,dniEmpleado,nombreEmpleado,ApellidoEmpleado,Telefono)
VALUES(NEXTVAL('SEQ_Empleados'),'15','11','71994345','IRWIN CLEVER','JARAMILLO RUIZ','944982935')



CREATE TABLE AUTHORITY
(
AUTHORITY_ID numeric (4,0) NOT NULL PRIMARY KEY,
nombre VARCHAR(120)NOT NULL
) ; 
INSERT INTO AUTHORITY(AUTHORITY_ID,nombre)
VALUES ('2','USER')

CREATE TABLE USUARIO_AUTHORITY
(
USUARIO_AUTHORITY_ID numeric (4,0) NOT NULL PRIMARY KEY,
USUARIO_ID numeric (4,0) NOT NULL,
	AUTHORITY_ID numeric (4,0) NOT NULL
) ;

INSERT INTO USUARIO_AUTHORITY(USUARIO_AUTHORITY_ID,USUARIO_ID,AUTHORITY_ID)
VALUES ('2','3','1')
INSERT INTO USUARIO_AUTHORITY(USUARIO_AUTHORITY_ID,USUARIO_ID,AUTHORITY_ID)
VALUES ('3','3','2')