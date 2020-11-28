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
	lib_total bigint not null,
	lib_disponibles bigint not null,
	lib_espalindrome boolean not null,
	lib_esconlimite boolean not null,
    CONSTRAINT lib_pk PRIMARY KEY (lib_id),
	constraint lib_uk
		unique (lib_isbn)
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
    CONSTRAINT pres_pk PRIMARY KEY (pres_id,
    CONSTRAINT pres_lib_fk FOREIGN KEY (lib_id)
        REFERENCES libro (lib_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION
	
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;