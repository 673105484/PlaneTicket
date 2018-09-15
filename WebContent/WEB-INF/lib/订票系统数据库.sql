
--1.创建表

--用户信息表(users)

create table users(
  usersId int primary key,    --用户编号,主键
  uname varchar2(20)  unique,     --会员名 uname
  truename varchar2(20), --真实姓名
  pwd varchar2(20),       --密码
  sex varchar2(2),        --性别
  cernum  varchar2(28),   --证件号码
  mail  varchar2(50)  unique,     --注册邮箱
  phone varchar2(20),     --联系电话
  datetime  date          --注册时间
)
insert into users(uname,truename,pwd,sex,cernum,mail,phone,datetime) values('ljn','龙俊男','123456','男','21425466564532','122531','12353311124',sysdate)
commit
--航空公司信息表(flightCompany)
create table flightCompany(
  flightCompanyId int primary key,     --公司编号,priamy key
  cname varchar2(50),      --公司名
  caddress  varchar2(50),  --公司地址
  phone varchar2(20),      --联系电话
  cmail varchar2(50),       --公司邮箱
  fcstate int               --航空公司状态   0.破产   1.正常
)
insert into flightCompany(cname,Caddress,Phone,Cmail,Fcstate) values('民航','重庆','124342','12342413','1')
--航班信息表(flight)
create table flight(
  flightId  varchar2(20) primary key,       --航班号,主键
  companyId int,                --公司编号,外键
  fstart  varchar2(50),          --起点
  fend  varchar2(50),            --终点
  jpiao int,                    --经济舱票数
  hpiao int,                     --豪华舱票数
  starttime date ,               --起飞时间
  endtime date,                  --到点时间
  jprice  number,                 --经济舱票价
  hprice  number                --豪华舱票价
)
select *from flight
commit
insert into flight values('165','1','重庆','上海','1000','500',to_date('2018-07-27 19:23:00','yyyy-mm-dd hh24:mi:ss'),to_date('2018-07-28 04:23:00','yyyy-mm-dd hh24:mi:ss'),'1000','500')
--订票信息表(bookTicket)
create table bookTicket(
    bookTicketId  int primary key ,        --编号primary key
    hyid  int constraint FK_hyid references users(usersId),                    --会员编号 foreign key
    uname varchar2(20),         --用户名 foreign key
    cernum  varchar2(28),        --证件号
    fid varchar2(20) constraint FK_fid references flight(flightId),               --航班号 foreign key
    phone varchar2(20),          --联系方式
    zwNumber  varchar2(20),        --座位号
    jptype  int,                   --机票类型
    booktime  date             --订票时间
)

insert into bookticket (hyid,uname,cernum,fid,phone,zwnumber,jptype,booktime)values('42','ljn','214254665754532','125','1245233','20','1',sysdate)
commit
--管理员信息表(admin)
create table admin(
      adminId int primary key,       -- 编号  
      uname varchar2(20),        --用户名
      pwd varchar2(20)          --密码
)
insert into admin(uname,pwd)values ('ljn','123456')
commit
--余票信息表     
create table ticketInfo(
     flightTimeId int  primary key,
     fid  varchar2(20) constraint FK_fid2 references flight(flightId),               --航班号 foreign key
     jpiao  int,                    --经济舱票数
     hpiao  int,                    --豪华舱票数
       rjpiao varchar(1000),   --经济舱退票信息
       rhpiao varchar(1000)    --豪华舱退票信息
);

--2. 给每一个表的主键列分别创建一个序列，用于生成序列号
create sequence users_seq start with 1 increment by 1;
create sequence flightCompany_seq start with 1 increment by 1;
create sequence flight_seq start with 1 increment by 1;
create sequence bookTicket_seq  start with 1increment by 1;
create sequence admin_seq start with 1000 increment by 1;

--3 创建如下触发器，用于在给每个表插入数据时，自动生成编号.

--触发器名要求
--usersId_tg  用于users表主键生成
  create trigger usersId_tg
   before insert on users
      for each row
    begin
          Select users_seq.nextval into :new.usersId from dual;
  end;
   create trigger bookticket_tg
   before insert on bookticket
      for each row
    begin
          Select bookTicket_seq.nextval into :new.bookTicketId from dual;
  end;



--flightCompanyId_tg 用于flightCompany表主键生成
create trigger flightCompanyId_tg
       before insert on flightCompany
       for each row
    begin
           select flightCompany_seq.Nextval into :new.flightCompanyId from dual;
    end;
    
      
       
--adminId_tg 用在admin表的主键生成
create trigger adminId_tg
       before insert on  admin
       for each row
     begin
           select admin_seq.nextval into :new.adminId from dual;
     end;
     


--当像时刻信息表中插入数据时，自动将其编号和对应的票数插入到ticketInfo表中
create or replace trigger ticketInfo_tri
       before insert on flight
       referencing NEW as n
       for each row
       declare
begin
    insert into ticketInfo values(:n.flightId,(select jpiao from flight where flight.flightId=:n.fid),(select hpiao from flight where flight.flightId=:n.fid),'','');
end;
