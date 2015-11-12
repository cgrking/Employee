select * from dept;

create table city (
  id				 int(11) not null,
  name				 char(35) not null,
  countrycode		char(3) not null,
  district 			char(20) not null,
  population		 int(11) not null,
  primary key (id)
)
