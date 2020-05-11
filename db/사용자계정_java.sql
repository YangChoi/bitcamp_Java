
create table 연산(
x int,  -- char : 고정형 -- varchar2 : 가변형
y number, 
z number(10, 2));

select * from 연산;
-- cmd 에서 데이터를 insert로 다 넣었는데 여기서 나타나지 않는다. 
-- lock 걸렸음 ( insert/ delete/ update 가 lock 걸림 : 나만 볼 수 있음)
-- 중앙 서버인 oracle db 에서는 볼 수 없고 cmd에서만 볼 수 있다 
-- 중앙 서버에서 갱신하고 싶으면 cmd 에서 commit을 한다. 

delete 연산; -- 레코드 전부 삭제 

rollback; -- 다시 되돌리기 




create table dbtest(
name varchar2(15),  -- char : 고정형 -- varchar2 : 가변형
-- 한글 한글자 : 2 byte (express는 3 byte) 
age number, 
-- 정수 실수 다 받음
height number(10, 2),
-- 실수 타입만 
logtime date);
-- 1900 년대에는 앞의 19를 기억하지 않았다. 
-- 그때 2000년대로 넘어갈 때 문제가 되었다. 
-- 그래서 1900 년으로 다시 back 했었다 
-- 지금은 현재 년도에 따라가라 라고 해놓음 

-- 남는 공간을 다시 메모리에 돌려주는 것이 가변형 varchar
-- 남는 공간도 그대로 안고가는 것이 고정형 char
-- 그래서 int 형과 같은 고정형 보다는 number 같은 가변을 쓰는 경우가 더 많다 (선호도가 높다)

-- 오라클은 문자와 문자열 가리지 않는다 
-- 가리는 것은 오직 고정이냐 고정이 아니냐 
-- 오라클은 무조건 싱글로 처리한다 '문자' / '문자열'

select * from dbtest;

-- 레코드 삽입

insert into dbtest(name, age, height, logtime) values('홍길동', 25, 187.567, sysdate);
insert into dbtest(name, age, height, logtime) values('Hong', 30, 175.56, sysdate);
insert into dbtest(name, age) values('희동이', 3);
insert into dbtest(name, height) values('홍당무', 168.89);
insert into dbtest values('분홍신', 5, 123.5, sysdate);
insert into dbtest(name) values('진분홍');

commit;

-- sysdate : 현재 시스템날짜
select * from dbtest;
-- 지금은 짤려서 시분초가 안나옴
-- (null) : 값이 없다 
select * from dbtest where age is null;
-- 나이가 비어있는 컬럼
select * from dbtest where age is not null;
-- 나이가 비어있지 않은 컬럼 
select * from dbtest where name='홍길동';
-- 이름이 홍길동인 레코드 출력 
select * from dbtest where name='Hong';
-- 데이터들에 대해서는 대소문자를 가린다 
-- 명령어들은 대소문자 가리지 않는다 
select * from dbtest where upper(name) = 'HONG';
-- 전부 대문자로 다룬다 
select * from dbtest where lower(name) = 'hong';
-- 전부 소문자로 다룬다 
-- JAVA : toUpperCase() / toLowerCase()

select * from dbtest where name like '홍%';
-- 첫글자는 홍으로 시작하고 뒤에는 뭐가 와도 상관없는 경우 홍%
select * from dbtest where name like '%홍';
-- 홍으로 끝나는 경우만 
select * from dbtest where name like '%홍%';
-- 홍이 앞이던 뒤던 상관없이 홍이 들어간 단어를 전부 꺼내온다 
select * from dbtest where name like '_홍%';
-- _는 한글자를 대신한다. 첫글자가 한글자이고 그 다음에 홍이 나오고 그 이후로 
-- 아무거나 들어가도 되는 경우 
select * from dbtest where name like '__홍%';
-- 두글자가 들어가는 경우 __ (언더바 하나에 한글자 )

select * from dbtest order by name asc; 
-- 이름으로 오름차순 
-- 영어가 항상 값이 작다 
-- 오름차순은 디폴트 값이므로 생략가능 
select * from dbtest order by name desc;
-- 이름으로 내림차순 

insert into dbtest(name, age) values('홍길동', 30);
select * from dbtest order by age desc;
-- 나이로 내림차순
-- 두개의 데이터가 같다면 두번쨰 조건을 줘서 제대로 sort해준다 
select * from dbtest order by age desc, name asc; 
-- 나이로 내림차순 정렬했는데 같은 값을 가진 데이터가 있다면 이름으로 오름차순 정렬도 하라 

select * from dbtest where name='홍길동';


-- 레코드 수정 
update dbtest set age = 0 where name = '홍당무';
select * from dbtest where name = '홍당무';

update dbtest set age=0, height=0 where name = '진분홍';
select * from dbtest where name = '진분홍';

update dbtest set age = age +1;
select * from dbtest;
update dbtest set age = age+1 where name = '홍길동';
select * from dbtest where name = '홍길동';


-- delete 
delete dbtest where name = '홍길동';
select * from dbtest where name = '홍길동';
select * from dbtest; 

-- 홍이 들어간 이름 전부 삭제 
delete dbtest where name like '%홍%';
-- = 이 아니고 like 다 
select * from dbtest;

-- 테이블 삭제 
drop table 연산;

select * from tab;
-- 테이블 삭제 후 이름이 이상한게 뜬다 
-- 다시 되살릴 수 있는 상태인 것 (휴지통에 들어간 상태) 
flashback table 연산 to before drop; 
-- 연산 테이블 되돌림 
select * from tab;

drop table 연산 purge;
-- 휴지조각 없이 완전 제거 
select * from tab;
select * from recyclebin;
-- 휴지통에 테이블 정보 검색 
drop table dbtest; 
select * from tab;
select * from recyclebin;
-- 휴지통에 테이블 정보 검색
-- 로그 기록 인 셈 
show recyclebin;
purge recyclebin; 
-- 휴지통 비우기 


-- 시퀀스 객체 // Mysql은 없는 부분
create sequence test;

select test.nextval from dual;
-- dual : 가상의 테이블 명 (시퀀스는 테이블 명이 없으므로)
-- 1 증가된 상태
-- 실행할 수록 1씩 증가된다. 

drop SEQUENCE test;
-- 휴지 정보 남기지 않고 깔끔하게 삭제돔

create SEQUENCE num increment by 2 start with 1 maxvalue 9 cycle nocache;
-- nocycle, nocache 쓸 때마다 미리 만들것
select num.nextval from dual;
select num.currval from dual;
-- currval 현재 num을 보여달라 
select * from user_sequences;
drop sequence num;


---- student 테이블 생성
create table student(
name varchar2(15) not null, 
value varchar2(15), 
code number 
);

select * from student;
