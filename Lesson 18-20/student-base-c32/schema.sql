create table admins
(
    id       serial not null
        constraint admins_pk
            primary key,
    name     varchar,
    password varchar,
    role     varchar,
    login    varchar
);

alter table admins
    owner to postgres;

create unique index admins_id_uindex
    on admins (id);

create table students
(
    id       serial not null
        constraint students_pk
            primary key,
    login    varchar,
    password varchar,
    name     varchar,
    faculty  varchar,
    "group"  varchar
);

alter table students
    owner to postgres;

create unique index students_id_uindex
    on students (id);


