select * from city;

create table member (
	id	 			int auto_increment,
	email 			varchar(255),
	name	 		varchar(255),
	password	 	varchar(255),
	register_date	date,
	constraint pk_id primary key(id)
);
select * from member;

drop table member;

delete from member
	where id = 3;

insert into member
(email, name, password)
values
('xxxx@yyy','가람','1234');

update member
	set name = '뀨이아',
		password = '222'
	where id = 2;

--	
--City
--

select 	 id,
		 name,
		 countrycode,
		 district,
		 population
	from city;


select 	 id,
		 name,
		 countrycode,
		 district,
		 population
	from city
	where countrycode = 'KOR';

