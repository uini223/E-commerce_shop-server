-- Creating tables
create table if not exists shop (
  id bigserial primary key,
  client_name varchar(20) not null
);

create table if not exists currency (
  id bigserial primary key,
  name varchar(20) not null
);

create table if not exists location (
  id bigserial primary key,
  city varchar(30) not null,
  street varchar(30) not null,
  post_code varchar(10) not null,
  phone_number varchar(15)
);

create table if not exists platform (
  id bigserial primary key,
  name varchar(30) not null,
  phone_number varchar(15),
  status varchar(30) not null,
  shop_id bigserial constraint fk_platform__shop references platform(id),
  currency_id bigserial constraint fk_platform__currency references currency(id),
  location_id bigserial constraint fk_platform__location references location(id)
);

create table if not exists budget (
  id bigserial primary key,
  name varchar(30) not null,
  platform_id bigserial,
  currency_id bigserial constraint fk_budget__currency references currency(id)
);

create table if not exists category (
  id bigserial primary key,
  name varchar(40) not null
);

create table if not exists product (
  id bigserial primary key,
  unit varchar(50) not null,
  producent varchar(50) not null,
  stock bigint not null constraint stock_more_than_zero check (stock>0),
  status varchar(30) not null,
  price float not null constraint price_more_than_zero check (price>0),
  currency_id bigserial constraint fk_product__currency references currency(id),
  platform_id bigserial constraint fk_product__platform references platform(id),
  category_id bigserial constraint fk_product__category references category(id)
);

create table if not exists platform_user (
  id bigserial primary key,
  login varchar(30) not null,
  password varchar(50) not null,
  platform_id bigserial constraint fk_user__platform references platform(id),
  location_id bigserial constraint fk_user__location references location(id)
);

create table if not exists user_order (
  id bigserial primary key,
  payment_type varchar(30) not null,
  transport_type varchar(30) not null
);

create table if not exists product_reservation (
  quantity bigint not null constraint quantity_more_than_zero check (quantity>0),
  user_id bigserial constraint fk_product_reservation__user references platform_user(id),
  product_id bigserial constraint fk_product_reservation__product references product(id),
  constraint pk_product_reservastion primary key (user_id, product_id)
);

create table if not exists product_ordered (
  quantity bigint not null constraint quantity_more_than_zero check (quantity>0),
  user_id bigserial constraint fk_product_reservation__user references platform_user(id),
  order_id bigserial constraint fk_product_reservation__user_order references user_order(id),
  constraint pk_product_ordered primary key (user_id, order_id)
);
