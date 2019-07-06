DROP TABLE IF EXISTS public.user_roles;
DROP TABLE IF EXISTS public.role;
DROP TABLE IF EXISTS public.users;

CREATE TABLE public.role
(
    id bigint NOT NULL,
    code character varying(255),
    name character varying(255),
    CONSTRAINT role_pkey PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id bigint NOT NULL,
    login character varying(255),
    password character varying(255),
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT uk_ow0gan20590jrb00upg3va2fn UNIQUE (login)
);

CREATE TABLE public.user_roles
(
    user_id bigint NOT NULL,
    role_id bigint NOT NULL,
    CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fkrhfovtciq1l558cw6udg0h0d3 FOREIGN KEY (role_id)
        REFERENCES public.role (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
);

INSERT INTO public.role(id, code, name) VALUES (1, 'admin', 'admin');
INSERT INTO public.role(id, code, name) VALUES (2, 'user', 'user');

INSERT INTO public.users(id, login, password) VALUES (1, 'tomek', '$2a$10$4W6RdVIm/NtN4D2193NQN.y2X3izeyKyZLfo6O5l3nr2TdpFLVEo.');
INSERT INTO public.users(id, login, password) VALUES (2, 'tomek2', '$2a$10$4W6RdVIm/NtN4D2193NQN.y2X3izeyKyZLfo6O5l3nr2TdpFLVEo.');

INSERT INTO public.user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO public.user_roles (user_id, role_id) VALUES (1, 2);

INSERT INTO public.user_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO public.user_roles (user_id, role_id) VALUES (2, 2);
