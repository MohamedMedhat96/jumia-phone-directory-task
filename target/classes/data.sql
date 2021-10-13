create table IF NOT EXISTS country_codes (id INTEGER primary key , name TEXT not null unique , code TEXT not null unique );

insert or IGNORE into country_codes(id, name , code) values(1, 'Cameroon', '+237');
insert or ignore into country_codes(id, name , code) values(2, 'Ethiopia', '+251');
insert or ignore into country_codes(id, name , code) values(3, 'Morocco', '+212');
insert or ignore into country_codes(id, name , code) values(4, 'Mozambique', '+258');
insert or ignore  into country_codes(id, name , code) values(5, 'Uganda', '+256');

delete from country_regex;
create table IF NOT EXISTS country_regex(id INTEGER primary key , name TEXT not null unique , regex TEXT not null unique );
insert or IGNORE into country_regex(id, name , regex) values(1, 'Cameroon', '\(237\)\ ?[2368]\d{7,8}$');
insert or ignore into country_regex(id, name , regex) values(2, 'Ethiopia', '\(251\)\ ?[1-59]\d{8}$');
insert or ignore into country_regex(id, name , regex) values(3, 'Morocco', '\(212\)\ ?[5-9]\d{8}$');
insert or ignore into country_regex(id, name , regex) values(4, 'Mozambique', '\(258\)\ ?[28]\d{7,8}$');
insert or ignore  into country_regex(id, name , regex) values(5, 'Uganda', '\(256\)\ ?\d{9}$');

