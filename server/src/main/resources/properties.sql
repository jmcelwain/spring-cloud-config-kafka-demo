CREATE TABLE IF NOT EXISTS public.properties
(
  application CHARACTER VARYING(50) COLLATE pg_catalog."default",
  profile     CHARACTER VARYING(50) COLLATE pg_catalog."default",
  label       CHARACTER VARYING(50) COLLATE pg_catalog."default",
  key         CHARACTER VARYING(50) COLLATE pg_catalog."default",
  value       CHARACTER VARYING(500) COLLATE pg_catalog."default"
);

ALTER TABLE public.properties DROP CONSTRAINT IF EXISTS uq_config;
ALTER TABLE public.properties ADD CONSTRAINT uq_config  UNIQUE (application, profile, label, key, value);

INSERT INTO public.properties (application, profile, label, key, value) VALUES ('demo', 'local', 'test', 'events.process', 'true') ON CONFLICT DO NOTHING ;
