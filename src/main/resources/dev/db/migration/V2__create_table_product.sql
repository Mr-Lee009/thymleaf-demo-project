create table history
(
    id          bigint not null,
    create_date datetime(6),
    description varchar(255),
    update_date datetime(6),
    primary key (id)
) engine=InnoDB;

create table persons
(
    id         bigint not null auto_increment,
    address    varchar(255),
    city       varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    primary key (id)
) engine=InnoDB;

create table product_variant_values
(
    id         bigint not null auto_increment,
    create_at  date,
    old_price  bigint,
    price      bigint,
    product_id bigint,
    sku        varchar(11),
    stock      bigint,
    update_at  date,
    primary key (id)
) engine=InnoDB;

create table products
(
    id           bigint        not null auto_increment,
    brand_id     bigint,
    category_id  bigint,
    create_at    date,
    decription   varchar(1024),
    image        varchar(1024),
    price        bigint,
    product_name varchar(1024) not null,
    rating       bigint,
    stock        bigint,
    update_at    date,
    primary key (id)
) engine=InnoDB;

create table variant_values
(
    id         bigint not null auto_increment,
    create_at  date,
    update_at  date,
    value      varchar(1024),
    variant_id bigint,
    primary key (id)
) engine=InnoDB;

create table variants
(
    id           bigint not null auto_increment,
    create_at    date,
    product_name varchar(256),
    update_at    date,
    primary key (id)
) engine=InnoDB;
