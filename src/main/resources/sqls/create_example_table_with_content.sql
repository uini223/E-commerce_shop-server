create table test_users(
  id bigserial primary key,
  name varchar(30) not null
);
insert into test_users(name)
    values ('emil');
insert into test_users(name)
    values ('ramon');
