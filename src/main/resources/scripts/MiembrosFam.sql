create TABLE miembrosFam
(
    ID_miembrosFam numeric(6) NOT NULL primary key,
	id_personasfam numeric(6) references personasFam(id_personasfam),
	ID_EstablecimientoS numeric(6) references establecimientos(id_establecimientos),
    Miembronombres character varying(100) NOT NULL,
    MiembroApellido character(100)  NOT NULL,
    MiemFechaNacimiento date not null,
      MiembroDni CHAR(11)
);
create sequence SEQ_miembrosFam;
INSERT INTO miembrosfam(id_miembrosfam,id_personasfam,id_establecimientos,Miembronombres,MiembroApellido
				,MiemFechaNacimiento,MiembroDni)
VALUES(NEXTVAL('SEQ_miembrosFam'),'3','1','Irwin Clever','Jaramillo Ruiz','2008/12/31','71994345')