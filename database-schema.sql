
-- hbm2ddl.auto generated script

drop table if exists song cascade;

create table song (
   id bigint generated by default as identity,
    title varchar(255),
    url varchar(255),
    primary key (id)
);

