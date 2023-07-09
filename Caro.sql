Create database Caro
go

use Caro
select *from Account

create table Account (
	UserName nvarchar(max),
	TenUser nvarchar(max) ,
	PassWord  nvarchar(max),
	Hinh char(30),
	SoTranThang int ,
	
)
go
insert into Account values('giathuan25',N'Gia Thuận','mapuu17','icons8_morpheus_96px.png',2)
insert into Account values('teo',N'Minh Won','123456','icons8_morpheus_96px.png',2)
select PassWord from Account where UserName=N'giathuan25'
drop 
select UserName from Account where UserName=N'giathuan25'
select Hinh from Account where TenUser =N'Gia Thuận'
select Hinh from Account where UserName ='giathuan25'

update  Account set TenUser=N'Tèo' , PassWord='5645646' where UserName= 'teo'