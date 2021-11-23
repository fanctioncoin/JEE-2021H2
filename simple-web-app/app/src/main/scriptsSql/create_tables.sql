drop table if exists marks;
drop table if exists band_disciplines;
drop table if exists discipline;
drop table if exists adm;
drop table if exists student;
drop table if exists band;
drop table if exists coach;
drop table if exists usr;

CREATE TABLE usr
(
    id serial   not null,
    login   varchar(255) not null,
    password     varchar(255) not null,
    role   varchar(255),
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

CREATE TABLE coach
(
    id     serial not null,
    name   varchar(255) not null,
    age     int,
    salary  int,
    id_usr int not null,
    primary key (id)
);

CREATE TABLE band
(
    id serial not null,
    name   varchar(255) not null,
    id_coach  int not null,
    disciplines1  varchar(255),
    disciplines2  varchar(255),
    disciplines3  varchar(255),
    disciplines4  varchar(255),
    disciplines5  varchar(255),
    disciplines7  varchar(255),
    disciplines8  varchar(255),
    disciplines9  varchar(255),
    primary key (id)
);

CREATE TABLE student
(
    id serial not null,
    name   varchar(255) not null,
    age     int,
    id_band int not null,
    marks1 varchar(255),
    marks2 varchar(255),
    marks3 varchar(255),
    marks4 varchar(255),
    marks5 varchar(255),
    marks6 varchar(255),
    marks7 varchar(255),
    marks8 varchar(255),
    marks9 varchar(255),
    marks10 varchar(255),
    id_usr int not null,
    primary key (id)

);

CREATE TABLE discipline
(
    band_id int4 references band(id),
    name   varchar(255) not null
);

CREATE TABLE band_disciplines
(
    id serial not null,
    band_id int4 not null,
    discipline_id int4 not null,
    primary key (id)
);


CREATE TABLE marks
(
    student_id int4 references student(id),
    mark   varchar(255)
);

alter table coach
    add constraint coach_user_fk
        foreign key (id_usr) references usr(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table adm
    add constraint adm_user_fk
        foreign key (id_usr) references usr(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table student
    add constraint student_user_fk
        foreign key (id_usr) references usr(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table student
    add constraint student_band_fk
        foreign key (id_band) references band(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table band
    add constraint band_coach_fk
        foreign key (id_coach) references coach(id) ON DELETE CASCADE ON UPDATE CASCADE;


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

INSERT INTO band (name , id_coach, disciplines1, disciplines2, disciplines3, disciplines4)
values ('GLS_01_02',1,'Logic','Biology','History','Algebra'),
       ('GLK_03_02',2,'Mechanic','Management','Control','Algebra');


INSERT INTO student ("name" , age ,id_band ,marks1, marks2, marks3, marks4, id_usr)
values ('Ivan Zuzkin',20,1,'5','-','9','10',7),
       ('Natalia Efimova',19,1,'-','-','9','7',8),
       ('Vadim Lukyanov',22,2,'5','-','5','7',9),
       ('Sergey Lukyanov',21,2,'5','-','5','7',10);

INSERT INTO adm ("name" , age , id_usr )
values ('Slava Belov',35,1);

INSERT INTO discipline(band_id,name)
values (1,'Logic'),
       (1,'History'),
       (1,'Mechanic'),
       (1,'Art'),
       (2,'History World'),
       (2,'Chemisty'),
       (2,'Mathematics'),
       (2,'English'),
       (2,'Belorussian language');


INSERT INTO marks(student_id,mark)
values
(5,'-'),
(5,'5'),
(5,'8'),
(5,'9'),
(6,'-'),
(6,'10'),
(6,'10'),
(6,'10'),
(7,'5'),
(7,'-'),
(7,'10'),
(7,'10'),
(7,'9'),
(8,'2'),
(8,'-'),
(8,'10'),
(8,'10'),
(8,'9');
