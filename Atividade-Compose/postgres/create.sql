CREATE TABLE banda (
	id SERIAL,
	nome VARCHAR(100) UNIQUE,
	localDeOrigem VARCHAR(100),
	integrantes TEXT,
	PRIMARY KEY (id)
);

CREATE TABLE album (
	id SERIAL,
	estilo VARCHAR(50),
	banda INT,
	nomeBanda VARCHAR(100),
	anoDeLancamento VARCHAR(10),	
	PRIMARY KEY (id),
	CONSTRAINT Fk FOREIGN KEY (banda) REFERENCES banda (id)
	ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT Fk2 FOREIGN KEY (nomeBanda) REFERENCES banda (nome)
	ON DELETE CASCADE ON UPDATE CASCADE
);



