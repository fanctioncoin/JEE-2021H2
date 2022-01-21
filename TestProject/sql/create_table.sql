drop table if exists car;
drop table if exists car_type;

create table car
(
    id       bigserial   not null,
    "name"   varchar(20) not null,
    speed    int4,
    weight   int4,
    car_type int8 null
);

create table car_type
(
    id     bigserial   not null,
    "name" varchar(20) not null
);

insert into car_type(name) values('TRUCK');
insert into car_type(name) values('SUV');
insert into car_type(name) values('PICKUP');

insert into car(name, speed, weight, car_type)
values ('MAN', 120, 5, 1),
       ('BMW X5', 280, 2, 2),
       ('Ford Runner', 240, 3, 3),
       ('Mazda CX5', 250, 2, 2),
       ('Ford F-150', 245,3, 3);