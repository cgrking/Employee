select * from city;

create table member (
	id	 			int,
	email 			varchar(255),
	name	 		varchar(255),
	password	 	varchar(255),
	register_date	date,
	constraint pk_id primary key(id)
);

--Member CURD 
select * from member;

drop table member;

delete from member
	where id = 1;
	
	create sequence member_id_seq

insert into member
(id, email, name, password,register_date)
values
(member_id_seq.nextval,'xxxx@yyy','가람','1234','2015/11/11');

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

