create TABLE region
(
    id serial NOT NULL primary key,
    nombre character varying(100) NOT NULL
);
INSERT INTO region(nombre)
VALUES('ucayali')
create TABLE provincia
(
    id serial NOT NULL primary key,
    nombre character varying(100) NOT NULL,
	id_region int references region(id)
);
INSERT INTO provincia(id_region,nombre)
VALUES('1','coronel portillo')

create TABLE distrito
(
    id serial NOT NULL primary key,
    nombre character varying(100) NOT NULL,
	id_provincia int references provincia(id)
);
INSERT INTO distrito(id_provincia,nombre)
VALUES('1','calleria')


create TABLE red_salud
(
    id serial NOT NULL primary key,
    nombre character varying(100) NOT NULL
	
);
INSERT INTO red_salud(nombre)
VALUES('ATALAYA')

create TABLE microred
(
    id serial NOT NULL primary key,
    nombre character varying(100) NOT NULL,
	id_redsalud int references red_salud(id)
);
INSERT INTO microred(id_redsalud,nombre)
VALUES('1','NUEVO PARAISO')


create TABLE establecimiento
(
    id serial NOT NULL primary key,
	codigo character varying(100) NOT NULL,
    nombre character varying(100) NOT NULL,
	id_microred int references microred(id)
);
INSERT INTO establecimiento(id_microred,codigo,nombre)
VALUES('1','00005539','CENTRO AMERICA')




create TABLE empleado
(
    id serial NOT NULL primary key,
	dni character (12) NOT NULL,
    nombre character varying(100) NOT NULL,
	id_establecimiento int references establecimiento(id),
	id_distrito int references distrito(id)
);
INSERT INTO empleado(dni,nombre,id_establecimiento,id_distrito)
VALUES('71994345','irwin clever jaramillo ruiz','1','1')


create TABLE familia
(
    id serial NOT NULL primary key,
	numero_historia character varying(100) NOT NULL,
	nombre character varying(100) NOT NULL,
	telefono character varying(100) NOT NULL,
	asentamiento_humano character varying(100) NOT NULL,
	direccion character varying(100) NOT NULL,
	lote  character varying(100) NOT NULL,
	manzana character varying(100) NOT NULL,
	referencia character varying(100) NOT NULL,
	sub_sector character varying(100) NOT NULL,
	fecha_creacion date NOT NULL
);
INSERT INTO familia(numero_historia,nombre,telefono,asentamiento_humano,direccion,lote,manzana,referencia,sub_sector,fecha_creacion)
VALUES('125','robalino ruiz','45789632','ah','jr sanchez cerro','3','5b','por urubamba','5bcd','2022/07/25')



create TABLE persona
(
    id serial NOT NULL primary key,
	id_familia int references familia(id),
	nombre_completo character varying(100) NOT NULL,
	dni character (12) NOT NULL,
    seguro character varying(100) NOT NULL,
	fecha_nacimiento date NOT NULL,
	parentesco character varying(100) NOT NULL,
	genero character varying(100) NOT NULL,
	estado_civil character varying(100) NOT NULL,
	estudios character varying(100) NOT NULL,
	clasificacion_riesgo character varying(100) NOT NULL,
	idioma character varying(100) NOT NULL,
	religion character varying(100) NOT NULL,
	pertenencia_etnica character varying(100) NOT NULL,
	ocupacion character varying(100) NOT NULL
);
INSERT INTO persona(id_familia,nombre_completo,dni,seguro,fecha_nacimiento,parentesco
,genero,estado_civil,estudios,clasificacion_riesgo,idioma
,religion,pertenencia_etnica,ocupacion)
VALUES('1','amy robalino ruiz','00080302','essalud','2022/05/17','hija menor','femenino'
	   ,'comprometida','secundaria completa','diabetes','castellano','evangelica','mestiza','ama de casa')

create TABLE encuesta
(
    id serial NOT NULL primary key,
	id_empleado int references empleado(id),
	id_familia int references familia(id),
	
	numero_visita character varying(100) NOT NULL,
	forma_visita character varying(100) NOT NULL,
	fecha_visita date NOT NULL,
    condicion_encuesta character varying(100) NOT NULL,
	observacion character varying(100) NOT NULL

	
);
INSERT INTO encuesta(id_empleado,id_familia,numero_visita,forma_visita,fecha_visita,condicion_encuesta,observacion)
VALUES('1','1','1 era visita','presencial','2022/07/25','casa cerrada','se niegan a dar informacion')
