drop table usr;
drop table adm;
drop table coach ;
drop table student;

CREATE TABLE usr
(
    id serial   not null,
    login   varchar(255) not null,
    password     varchar(255) not null,
    role   varchar(255),
    primary key (id)
);


CREATE TABLE student
(
    id serial not null,
    name   varchar(255) not null,
    age     int,
    name_group  varchar(255),
    topic1 varchar(255),
    topic2 varchar(255),
    topic3 varchar(255),
    topic4 varchar(255),
    id_usr int not null,
    primary key (id)
);

CREATE TABLE coach
(
    id     serial not null,
    name   varchar(255) not null,
    age     int,
    salary  int,
    id_usr int not null,
    primary key (id)
);
CREATE TABLE adm
(
    id     serial not null,
    name   varchar(255) not null,
    age     int,
    id_usr int not null,
    primary key (id)
);
alter table student
    add constraint student_user_fk
        foreign key (id_usr) references usr(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table coach
    add constraint coach_user_fk
        foreign key (id_usr) references usr(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table adm
    add constraint adm_user_fk
        foreign key (id_usr) references usr(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table user_role
    add constraint user_role_user_fk
        foreign key (id_usr) references usr(id);

INSERT INTO usr (login , "password", role )
values ('admin','123','ADMIN'),
       ('coach1','123','COACH'),
       ('coach2','123','COACH'),
       ('coach3','123','COACH'),
       ('coach4','123','COACH'),
       ('coach5','123','COACH'),
       ('student1','123','STUDENT'),
       ('student2','123','STUDENT'),
       ('student3','123','STUDENT'),
       ('student4','123','STUDENT');

INSERT INTO coach ( "name" , age , salary, id_usr )
values ('Ivan Petrov',30,1000,2),
       ('Alex Sidorov',25,599,3),
       ('Nikolay Slepzov',27,1200,4),
       ('Marya Ivanova',30,554,5),
       ('Olga Yarovaya',40,1100,6);


INSERT INTO student ("name" , age , name_group, topic1, topic2, topic3, topic4, id_usr)
values ('Ivan Zuzkin',20,'GR-1','5','-','9','10',7),
       ('Natalia Efimova',22,'GR-1','-','-','9','7',8),
       ('Vadim Lukyanov',20,'GR-2','5','-','5','7',9),
       ('Sergey Lukyanov',21,'GR-2','5','-','5','7',10);

INSERT INTO adm ("name" , age , id_usr )
values ('Slava Belov',35,1);


