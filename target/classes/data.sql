create table IF NOT EXISTS country (id INTEGER primary key , name TEXT not null unique , code TEXT not null unique, regex TEXT not null unique );

insert or IGNORE into country(id, name , code, regex) values(1, 'Cameroon', '+237', '\(237\)\ ?[2368]\d{7,8}$');
insert or ignore into country(id, name , code, regex) values(2, 'Ethiopia', '+251', '\(251\)\ ?[1-59]\d{8}$');
insert or ignore into country(id, name , code, regex) values(3, 'Morocco', '+212', '\(212\)\ ?[5-9]\d{8}$');
insert or ignore into country(id, name , code, regex) values(4, 'Mozambique', '+258', '\(258\)\ ?[28]\d{7,8}$');
insert or ignore  into country(id, name , code, regex) values(5, 'Uganda', '+256', '\(256\)\ ?\d{9}$');

