
alter table customer add column country_id integer REFERENCES country(id);

alter table customer add column state boolean;
