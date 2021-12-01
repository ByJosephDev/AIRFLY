create database airfly;

use airfly;

create table cliente(
id int primary key auto_increment,
nombre varchar(70),
apellido varchar(70),
fecha_nacimiento date,
documento varchar(70) unique,
sexo varchar(70)
);

create table viaje (
id int primary key auto_increment,	
lugar_partida varchar(70),
lugar_destino varchar(70),
hora time,
fecha date,
precio decimal(6,2)
);

create table reserva(
id int primary key auto_increment,	
id_cliente varchar(10),
id_viaje varchar(10),
asiento varchar(10),
CONSTRAINT fk_id_cliente FOREIGN KEY (id_cliente)
    REFERENCES cliente(id),
CONSTRAINT fk_id_viaje FOREIGN KEY (id_viaje)
    REFERENCES viaje(id)
);

insert into cliente values (null,"Micaela Alexia","Rojas Avendaño","2002-09-06","74618006","F");
insert into cliente values (null,"Joseph Percy","Cconislla Puma","2001-06-17","74618007","M");

insert into viaje values (null,"Lima","Ica","14:30:00","2021-11-25","500");
insert into viaje values (null,"Lima","Cusco","15:30:00","2021-11-25","700");

insert into reserva values (null,1,2,"B1");
insert into reserva values (null,2,1,"A1");

select * from cliente;
select * from viaje;
select * from reserva;

drop database airfly;

select r.id, c.id as id_cliente, c.nombre, c.apellido, c.documento, v.id as id_viaje, v.lugar_partida, v.lugar_destino, r.asiento from reserva r inner join cliente c inner join viaje v; 