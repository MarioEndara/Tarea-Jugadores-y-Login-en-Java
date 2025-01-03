create database futbol;
use futbol;
create table Usuarios (
    id int auto_increment primary key,
    usuario varchar(50) not null,
    contrasena varchar(255) not null
);
create table Jugadores (
    id int auto_increment primary key,
    nombre varchar(100) not null,
    posicion varchar(50) not null,
    equipo varchar(100) not null,
    edad int not null
);
-- Tabla Usuarios
insert into Usuarios (usuario, contrasena) 
values    			 ('mendara', 'Leito_2015'),
					 ('sguzman', 'Sofi_2022'),
					 ('lendara', 'Leo_2015');
-- Tabla Jugadores
insert into Jugadores (nombre, posicion, equipo, edad) 
VALUES               ('Messi', 'Central', 'Barcelona', 30),
				     ('Ronaldo', 'Delantero', 'Real Madrid', 32),
					 ('Ramos', 'Defensa', 'Real Madrid', 30),
                     ('Neymar', 'Delantero', 'Barcelona', 26),
					 ('Mbappé', 'Delantero', 'PSG', 20);
select * from Usuarios;
select * from Jugadores;

