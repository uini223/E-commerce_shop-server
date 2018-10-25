create table example_users(
  id bigserial primary key,
  name varchar(30) not null
);
insert into example_users(name)
    values ('emil');
insert into example_users(name)
    values ('ramon');
