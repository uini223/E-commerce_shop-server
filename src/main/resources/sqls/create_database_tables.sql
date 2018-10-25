-- Creating tables
drop table if exists shops cascade;
create table shops (
  id bigserial primary key,
  shop_name varchar(20) not null,
  owner_name varchar(50) not null,
  creation_date date not null default current_date
);

drop table if exists currencies cascade;
create table currencies (
  id bigserial primary key,
  name varchar(20) not null,
  code varchar(3) not null,
  exchange_rate float not null
);

drop table if exists locations cascade;
create table locations (
  id bigserial primary key,
  city varchar(30) not null,
  street varchar(30) not null,
  post_code varchar(10) not null,
  phone_number varchar(15)
);

drop table if exists platforms cascade;
create table platforms (
  id bigserial primary key,
  name varchar(30) not null,
  status varchar(30) not null,
  creation_date date not null default current_date,
  shop_id bigserial constraint platform__shop_fk references shops(id),
  location_id bigserial constraint platform__location_fk references locations(id)
);

drop table if exists customers cascade;
create table customers (
  id bigserial primary key,
  first_name varchar(30) not null,
  last_name varchar(30) not null,
  location_id bigserial constraint customer__location_fk references locations(id)
);

drop table if exists users cascade;
create table users (
  id bigserial primary key,
  login varchar(30) not null,
  password varchar(30) not null,
  role varchar(30) not null,
  creation_date date not null default current_date,
  customer_id bigserial constraint user_customer_fk references customers(id)
);

drop table if exists categories cascade;
create table categories (
  id bigserial primary key,
  name varchar(40) not null,
  description varchar(1024)
);

drop table if exists products cascade;
create table products (
  id bigserial primary key,
  name varchar(128) not null,
  unit varchar(50) not null,
  producent varchar(50) null,
  stock bigint not null constraint stock_more_than_zero check (stock>0),
  status varchar(30) not null,
  price float not null constraint price_more_than_zero check (price>0),
  description varchar(1024) null,
  currency_id bigserial constraint product__currency_fk references currencies(id),
  platform_id bigserial constraint product__platform_fk references platforms(id),
  category_id bigserial constraint product__category_fk references categories(id)
);

drop table if exists orders cascade;
create table orders (
  id bigserial primary key,
  payment_type varchar(20) not null,
  transport_type varchar(20) not null,
  status varchar(20) not null,
  creation_date timestamp not null default current_timestamp,
  last_status_change_date timestamp not null default current_timestamp,
  customer_id bigserial constraint order__customer_fk references customers(id)
);

drop table if exists product_reservations cascade;
create table product_reservations (
  quantity bigint not null constraint quantity_more_than_zero check (quantity>0),
  customer_id bigserial constraint product_reservation__customer_fk references customers(id),
  product_id bigserial constraint product_reservation__product_fk references products(id),
  constraint product_reservation_pk primary key (customer_id, product_id)
);

drop table if exists product_orders cascade;
create table product_orders (
  quantity bigint not null constraint quantity_more_than_zero check (quantity>0),
  product_id bigserial constraint product_order__product_fk references products(id),
  order_id bigserial constraint product_order__order_fk references orders(id),
  constraint product_order_pk primary key (product_id, order_id)
);

alter table users alter column customer_id drop not null;
alter table platforms alter column location_id drop not null;
