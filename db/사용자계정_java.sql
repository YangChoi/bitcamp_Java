
create table ����(
x int,  -- char : ������ -- varchar2 : ������
y number, 
z number(10, 2));

select * from ����;
-- cmd ���� �����͸� insert�� �� �־��µ� ���⼭ ��Ÿ���� �ʴ´�. 
-- lock �ɷ��� ( insert/ delete/ update �� lock �ɸ� : ���� �� �� ����)
-- �߾� ������ oracle db ������ �� �� ���� cmd������ �� �� �ִ� 
-- �߾� �������� �����ϰ� ������ cmd ���� commit�� �Ѵ�. 

delete ����; -- ���ڵ� ���� ���� 

rollback; -- �ٽ� �ǵ����� 




create table dbtest(
name varchar2(15),  -- char : ������ -- varchar2 : ������
-- �ѱ� �ѱ��� : 2 byte (express�� 3 byte) 
age number, 
-- ���� �Ǽ� �� ����
height number(10, 2),
-- �Ǽ� Ÿ�Ը� 
logtime date);
-- 1900 ��뿡�� ���� 19�� ������� �ʾҴ�. 
-- �׶� 2000���� �Ѿ �� ������ �Ǿ���. 
-- �׷��� 1900 ������ �ٽ� back �߾��� 
-- ������ ���� �⵵�� ���󰡶� ��� �س��� 

-- ���� ������ �ٽ� �޸𸮿� �����ִ� ���� ������ varchar
-- ���� ������ �״�� �Ȱ��� ���� ������ char
-- �׷��� int ���� ���� ������ ���ٴ� number ���� ������ ���� ��찡 �� ���� (��ȣ���� ����)

-- ����Ŭ�� ���ڿ� ���ڿ� ������ �ʴ´� 
-- ������ ���� ���� �����̳� ������ �ƴϳ� 
-- ����Ŭ�� ������ �̱۷� ó���Ѵ� '����' / '���ڿ�'

select * from dbtest;

-- ���ڵ� ����

insert into dbtest(name, age, height, logtime) values('ȫ�浿', 25, 187.567, sysdate);
insert into dbtest(name, age, height, logtime) values('Hong', 30, 175.56, sysdate);
insert into dbtest(name, age) values('����', 3);
insert into dbtest(name, height) values('ȫ�繫', 168.89);
insert into dbtest values('��ȫ��', 5, 123.5, sysdate);
insert into dbtest(name) values('����ȫ');

commit;

-- sysdate : ���� �ý��۳�¥
select * from dbtest;
-- ������ ©���� �ú��ʰ� �ȳ���
-- (null) : ���� ���� 
select * from dbtest where age is null;
-- ���̰� ����ִ� �÷�
select * from dbtest where age is not null;
-- ���̰� ������� ���� �÷� 
select * from dbtest where name='ȫ�浿';
-- �̸��� ȫ�浿�� ���ڵ� ��� 
select * from dbtest where name='Hong';
-- �����͵鿡 ���ؼ��� ��ҹ��ڸ� ������ 
-- ��ɾ���� ��ҹ��� ������ �ʴ´� 
select * from dbtest where upper(name) = 'HONG';
-- ���� �빮�ڷ� �ٷ�� 
select * from dbtest where lower(name) = 'hong';
-- ���� �ҹ��ڷ� �ٷ�� 
-- JAVA : toUpperCase() / toLowerCase()

select * from dbtest where name like 'ȫ%';
-- ù���ڴ� ȫ���� �����ϰ� �ڿ��� ���� �͵� ������� ��� ȫ%
select * from dbtest where name like '%ȫ';
-- ȫ���� ������ ��츸 
select * from dbtest where name like '%ȫ%';
-- ȫ�� ���̴� �ڴ� ������� ȫ�� �� �ܾ ���� �����´� 
select * from dbtest where name like '_ȫ%';
-- _�� �ѱ��ڸ� ����Ѵ�. ù���ڰ� �ѱ����̰� �� ������ ȫ�� ������ �� ���ķ� 
-- �ƹ��ų� ���� �Ǵ� ��� 
select * from dbtest where name like '__ȫ%';
-- �α��ڰ� ���� ��� __ (����� �ϳ��� �ѱ��� )

select * from dbtest order by name asc; 
-- �̸����� �������� 
-- ��� �׻� ���� �۴� 
-- ���������� ����Ʈ ���̹Ƿ� �������� 
select * from dbtest order by name desc;
-- �̸����� �������� 

insert into dbtest(name, age) values('ȫ�浿', 30);
select * from dbtest order by age desc;
-- ���̷� ��������
-- �ΰ��� �����Ͱ� ���ٸ� �ι��� ������ �༭ ����� sort���ش� 
select * from dbtest order by age desc, name asc; 
-- ���̷� �������� �����ߴµ� ���� ���� ���� �����Ͱ� �ִٸ� �̸����� �������� ���ĵ� �϶� 

select * from dbtest where name='ȫ�浿';


-- ���ڵ� ���� 
update dbtest set age = 0 where name = 'ȫ�繫';
select * from dbtest where name = 'ȫ�繫';

update dbtest set age=0, height=0 where name = '����ȫ';
select * from dbtest where name = '����ȫ';

update dbtest set age = age +1;
select * from dbtest;
update dbtest set age = age+1 where name = 'ȫ�浿';
select * from dbtest where name = 'ȫ�浿';


-- delete 
delete dbtest where name = 'ȫ�浿';
select * from dbtest where name = 'ȫ�浿';
select * from dbtest; 

-- ȫ�� �� �̸� ���� ���� 
delete dbtest where name like '%ȫ%';
-- = �� �ƴϰ� like �� 
select * from dbtest;

-- ���̺� ���� 
drop table ����;

select * from tab;
-- ���̺� ���� �� �̸��� �̻��Ѱ� ��� 
-- �ٽ� �ǻ츱 �� �ִ� ������ �� (�����뿡 �� ����) 
flashback table ���� to before drop; 
-- ���� ���̺� �ǵ��� 
select * from tab;

drop table ���� purge;
-- �������� ���� ���� ���� 
select * from tab;
select * from recyclebin;
-- �����뿡 ���̺� ���� �˻� 
drop table dbtest; 
select * from tab;
select * from recyclebin;
-- �����뿡 ���̺� ���� �˻�
-- �α� ��� �� �� 
show recyclebin;
purge recyclebin; 
-- ������ ���� 


-- ������ ��ü // Mysql�� ���� �κ�
create sequence test;

select test.nextval from dual;
-- dual : ������ ���̺� �� (�������� ���̺� ���� �����Ƿ�)
-- 1 ������ ����
-- ������ ���� 1�� �����ȴ�. 

drop SEQUENCE test;
-- ���� ���� ������ �ʰ� ����ϰ� ������

create SEQUENCE num increment by 2 start with 1 maxvalue 9 cycle nocache;
-- nocycle, nocache �� ������ �̸� �����
select num.nextval from dual;
select num.currval from dual;
-- currval ���� num�� �����޶� 
select * from user_sequences;
drop sequence num;


---- student ���̺� ����
create table student(
name varchar2(15) not null, 
value varchar2(15), 
code number 
);

select * from student;
