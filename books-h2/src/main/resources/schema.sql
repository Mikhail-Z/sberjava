drop table if exists author;
create table author (
    id serial,
    name varchar
);

drop table if exists genre;
create table genre (
    id serial,
    name varchar
);

drop table if exists book;
create table book (
    id serial,
    name varchar not null,
    author_id int references author(id),
    genre_id int references genre(id)
);