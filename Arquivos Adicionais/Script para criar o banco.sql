CREATE TABLE portas(
	idporta SERIAL NOT NULL,
    nome CHARACTER VARYING(40) NOT NULL,
	momento DATE NOT NULL,
    status BOOLEAN NOT NULL,
	info CHARACTER VARYING NOT NULL,
    CONSTRAINT porta_pk PRIMARY KEY (idporta)
);



