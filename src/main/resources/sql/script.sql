/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  gustavo
 * Created: 28/11/2020
 */

CREATE TABLE libro
(
    lib_id bigserial not null,
	lib_isbn text not null,
	lib_nombre text not null,
	lib_espalindrome boolean not null,
	lib_esconlimite boolean not null,
    CONSTRAINT lib_pk PRIMARY KEY (lib_id),
	constraint lib_uk unique (lib_isbn)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

create table stock(
	sto_id bigserial not null,
	sto_total bigint not null,
	sto_disponible bigint not null,
	sto_prestados bigint not null,
    CONSTRAINT sto_pk PRIMARY KEY (sto_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


create table stocklibro(
	stl_id bigserial not null,
	stl_total bigint not null,
	stl_disponible bigint not null,
	sol_prestados bigint not null,
	lib_id bigint not null,
	sto_id bigint not null,
    CONSTRAINT stl_pk PRIMARY KEY (stl_id),
    CONSTRAINT stl_lib_fk FOREIGN KEY (lib_id)
        REFERENCES libro (lib_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION,
    CONSTRAINT stl_sto_fk FOREIGN KEY (sto_id)
        REFERENCES stock (sto_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;



CREATE TABLE prestamo
(
    pres_id bigserial not null,
	pres_nombrepersona text not null,
	pres_fechaprestamo timestamp without time zone not null,
	pres_fechaLimite timestamp without time zone,
	lib_id bigint not null,
    CONSTRAINT pres_pk PRIMARY KEY (pres_id),
    CONSTRAINT pres_lib_fk FOREIGN KEY (lib_id)
        REFERENCES libro (lib_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION
	
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


insert into stock
(sto_total, sto_disponible, sto_prestados) values
(0,0,0);


DROP TABLE stocklibro;

ALTER TABLE libro ADD COLUMN total_ejemplares bigint NOT NULL;
ALTER TABLE libro ADD COLUMN total_ejemplares_disponibles bigint NOT NULL;
ALTER TABLE libro ADD COLUMN total_ejemplares_prestado bigint NOT NULL;