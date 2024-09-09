-- public.book definition

-- Drop table

-- DROP TABLE public.book;

CREATE TABLE public.book (
	id serial4 NOT NULL,
	title varchar NOT NULL,
	isbn varchar NULL,
	author_id int4 NULL,
	genre_id int4 NULL,
	published_date varchar NULL,
	CONSTRAINT book_pk PRIMARY KEY (id)
);


-- public.book foreign keys

ALTER TABLE public.book ADD CONSTRAINT author_id FOREIGN KEY (author_id) REFERENCES public.author(id);
ALTER TABLE public.book ADD CONSTRAINT genre_id FOREIGN KEY (genre_id) REFERENCES public.genre(id);

-- public.author definition

-- Drop table

-- DROP TABLE public.author;

CREATE TABLE public.author (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	bio varchar NOT NULL,
	CONSTRAINT author_pk PRIMARY KEY (id)
);

-- public.genre definition

-- Drop table

-- DROP TABLE public.genre;

CREATE TABLE public.genre (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	CONSTRAINT genre_pk PRIMARY KEY (id)
);