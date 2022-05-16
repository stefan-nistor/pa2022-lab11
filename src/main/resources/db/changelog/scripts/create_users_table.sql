CREATE TABLE IF NOT EXISTS public.users (
    id serial not null,
    username varchar(255) unique,
    password varchar(255) unique,
    PRIMARY KEY (id)
)