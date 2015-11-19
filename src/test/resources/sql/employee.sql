select * from dept;
select * from EMP;
drop table city;

select * from city;

create table city (
  id				 numeric(11),
  name				 char(50),
  countrycode		char(3),
  district 			char(30),
  population		 numeric(11),
 constraint city_pk_id primary key (id)
)

select count(*) from city;

insert into city
(	id, 
	name,
	countrycode, 
	district,
	population
)
values
(	
	11,
	'seoul',
	'KOR',
	'Asia',
	99998
)
