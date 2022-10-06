-- Create table "clients", used as a application data source

CREATE TABLE public.clients (
	id int4 NOT NULL, --same as integer
	firstName VARCHAR(100) NULL,
	lastName VARCHAR(100) NULL,
	"age" int2 NOT NULL, --same as smallint
	CONSTRAINT pk_clients PRIMARY KEY (id),
	CONSTRAINT uk_clients_id UNIQUE (id)
);

-- Drop table code
-- DROP TABLE public.clients;

