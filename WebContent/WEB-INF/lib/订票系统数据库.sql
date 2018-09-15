
--1.������

--�û���Ϣ��(users)

create table users(
  usersId int primary key,    --�û����,����
  uname varchar2(20)  unique,     --��Ա�� uname
  truename varchar2(20), --��ʵ����
  pwd varchar2(20),       --����
  sex varchar2(2),        --�Ա�
  cernum  varchar2(28),   --֤������
  mail  varchar2(50)  unique,     --ע������
  phone varchar2(20),     --��ϵ�绰
  datetime  date          --ע��ʱ��
)
insert into users(uname,truename,pwd,sex,cernum,mail,phone,datetime) values('ljn','������','123456','��','21425466564532','122531','12353311124',sysdate)
commit
--���չ�˾��Ϣ��(flightCompany)
create table flightCompany(
  flightCompanyId int primary key,     --��˾���,priamy key
  cname varchar2(50),      --��˾��
  caddress  varchar2(50),  --��˾��ַ
  phone varchar2(20),      --��ϵ�绰
  cmail varchar2(50),       --��˾����
  fcstate int               --���չ�˾״̬   0.�Ʋ�   1.����
)
insert into flightCompany(cname,Caddress,Phone,Cmail,Fcstate) values('��','����','124342','12342413','1')
--������Ϣ��(flight)
create table flight(
  flightId  varchar2(20) primary key,       --�����,����
  companyId int,                --��˾���,���
  fstart  varchar2(50),          --���
  fend  varchar2(50),            --�յ�
  jpiao int,                    --���ò�Ʊ��
  hpiao int,                     --������Ʊ��
  starttime date ,               --���ʱ��
  endtime date,                  --����ʱ��
  jprice  number,                 --���ò�Ʊ��
  hprice  number                --������Ʊ��
)
select *from flight
commit
insert into flight values('165','1','����','�Ϻ�','1000','500',to_date('2018-07-27 19:23:00','yyyy-mm-dd hh24:mi:ss'),to_date('2018-07-28 04:23:00','yyyy-mm-dd hh24:mi:ss'),'1000','500')
--��Ʊ��Ϣ��(bookTicket)
create table bookTicket(
    bookTicketId  int primary key ,        --���primary key
    hyid  int constraint FK_hyid references users(usersId),                    --��Ա��� foreign key
    uname varchar2(20),         --�û��� foreign key
    cernum  varchar2(28),        --֤����
    fid varchar2(20) constraint FK_fid references flight(flightId),               --����� foreign key
    phone varchar2(20),          --��ϵ��ʽ
    zwNumber  varchar2(20),        --��λ��
    jptype  int,                   --��Ʊ����
    booktime  date             --��Ʊʱ��
)

insert into bookticket (hyid,uname,cernum,fid,phone,zwnumber,jptype,booktime)values('42','ljn','214254665754532','125','1245233','20','1',sysdate)
commit
--����Ա��Ϣ��(admin)
create table admin(
      adminId int primary key,       -- ���  
      uname varchar2(20),        --�û���
      pwd varchar2(20)          --����
)
insert into admin(uname,pwd)values ('ljn','123456')
commit
--��Ʊ��Ϣ��     
create table ticketInfo(
     flightTimeId int  primary key,
     fid  varchar2(20) constraint FK_fid2 references flight(flightId),               --����� foreign key
     jpiao  int,                    --���ò�Ʊ��
     hpiao  int,                    --������Ʊ��
       rjpiao varchar(1000),   --���ò���Ʊ��Ϣ
       rhpiao varchar(1000)    --��������Ʊ��Ϣ
);

--2. ��ÿһ����������зֱ𴴽�һ�����У������������к�
create sequence users_seq start with 1 increment by 1;
create sequence flightCompany_seq start with 1 increment by 1;
create sequence flight_seq start with 1 increment by 1;
create sequence bookTicket_seq  start with 1increment by 1;
create sequence admin_seq start with 1000 increment by 1;

--3 �������´������������ڸ�ÿ�����������ʱ���Զ����ɱ��.

--��������Ҫ��
--usersId_tg  ����users����������
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



--flightCompanyId_tg ����flightCompany����������
create trigger flightCompanyId_tg
       before insert on flightCompany
       for each row
    begin
           select flightCompany_seq.Nextval into :new.flightCompanyId from dual;
    end;
    
      
       
--adminId_tg ����admin�����������
create trigger adminId_tg
       before insert on  admin
       for each row
     begin
           select admin_seq.nextval into :new.adminId from dual;
     end;
     


--����ʱ����Ϣ���в�������ʱ���Զ������źͶ�Ӧ��Ʊ�����뵽ticketInfo����
create or replace trigger ticketInfo_tri
       before insert on flight
       referencing NEW as n
       for each row
       declare
begin
    insert into ticketInfo values(:n.flightId,(select jpiao from flight where flight.flightId=:n.fid),(select hpiao from flight where flight.flightId=:n.fid),'','');
end;
