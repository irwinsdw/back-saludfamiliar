CREATE TABLE IF NOT EXISTS public.maestro_establecimientos
(
    id_establecimientos numeric(6,0) NOT NULL,
    codigoestablecimiento character(100) COLLATE pg_catalog."default" NOT NULL,
    nombreestablecimiento character varying(100) COLLATE pg_catalog."default" NOT NULL,
    red character varying(100) COLLATE pg_catalog."default" NOT NULL,
    microred character varying(100) COLLATE pg_catalog."default" NOT NULL,
    estado character(1) COLLATE pg_catalog."default" NOT NULL DEFAULT '1'::bpchar,
    CONSTRAINT maestro_establecimientos_pkey PRIMARY KEY (id_establecimientos)
)
create sequence SEQ_EstablecimientoS;



	INSERT INTO MAESTRO_EstablecimientoS(id_EstablecimientoS,codigoestablecimiento,nombreestablecimiento,red,microred)
VALUES(NEXTVAL('SEQ_EstablecimientoS'),'002','C.S HUSARES','FEDERICO BASADRE','hp')
