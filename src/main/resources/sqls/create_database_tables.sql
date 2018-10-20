-- Creating tables
create table if not exists shops (
  id bigserial primary key,
  shop_name varchar(20) not null,
  owner_name varchar(50) not null
);

create table if not exists currencies (
  id bigserial primary key,
  name varchar(20) not null,
  code varchar(3) not null
);

create table if not exists locations (
  id bigserial primary key,
  city varchar(30) not null,
  street varchar(30) not null,
  post_code varchar(10) not null,
  phone_number varchar(15)
);

create table if not exists platforms (
  id bigserial primary key,
  name varchar(30) not null,
  phone_number varchar(15),
  status varchar(30) not null,
  shop_id bigserial constraint platform__shop_fk references platforms(id),
  currency_id bigserial constraint platform__currency_fk references currencies(id),
  location_id bigserial constraint platform__location_fk references locations(id)
);

create table if not exists customers (
  id bigserial primary key,
  first_name varchar(30) not null,
  last_name varchar(30) not null
);

create table if not exists users (
  id bigserial primary key,
  login varchar(30) not null,
  password varchar(30) not null,
  customer_id bigserial null constraint user_customer_fk references customers(id)
);

create table if not exists categories (
  id bigserial primary key,
  name varchar(40) not null
);

create table if not exists products (
  id bigserial primary key,
  unit varchar(50) not null,
  producent varchar(50) not null,
  stock bigint not null constraint stock_more_than_zero check (stock>0),
  status varchar(30) not null,
  price float not null constraint price_more_than_zero check (price>0),
  currency_id bigserial constraint product__currency_fk references currencies(id),
  platform_id bigserial constraint product__platform_fk references platforms(id),
  category_id bigserial constraint product__category_fk references categories(id)
);

create table if not exists orders (
  id bigserial primary key,
  payment_type varchar(30) not null,
  transport_type varchar(30) not null
);

create table if not exists product_reservations (
  quantity bigint not null constraint quantity_more_than_zero check (quantity>0),
  user_id bigserial constraint product_reservation__user_fk references users(id),
  product_id bigserial constraint product_reservation__product_fk references products(id),
  constraint product_reservation_pk primary key (user_id, product_id)
);

create table if not exists product_orders (
  quantity bigint not null constraint quantity_more_than_zero check (quantity>0),
  user_id bigserial constraint product_order__user_fk references users(id),
  order_id bigserial constraint product_order__order_fk references orders(id),
  constraint product_order_pk primary key (user_id, order_id)
);
