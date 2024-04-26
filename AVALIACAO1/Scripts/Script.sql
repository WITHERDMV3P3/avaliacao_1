-- Drop column unimed

CREATE TEMPORARY TABLE IF NOT EXISTS temp  AS
SELECT
  codigo,
  codigodebarra,
  descricao,
  preco,
  marca,
  quantidade,
  categoria,
  obs
FROM NewTable;

DROP TABLE NewTable;

CREATE TABLE IF NOT EXISTS NewTable(
	codigo INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	codigodebarra INTEGER,
	descricao TEXT,
	preco INTEGER,
	marca TEXT,
	quantidade INTEGER,
	categoria TEXT,
	obs TEXT,
	CONSTRAINT NEWTABLE_PK PRIMARY KEY (codigo)
);

INSERT INTO NewTable
 (codigo,
  codigodebarra,
  descricao,
  preco,
  marca,
  quantidade,
  categoria,
  obs)
SELECT
  codigo,
  codigodebarra,
  descricao,
  preco,
  marca,
  quantidade,
  categoria,
  obs
FROM temp;

DROP TABLE temp;

SELECT * FROM NewTable;