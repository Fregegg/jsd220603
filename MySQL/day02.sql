select * from emp where dept_id=2 and sal>1000;
select * from emp where dept_id=3 or sal=5000;
select name,sal from emp where sal between 1000 and 2000;
select * from emp where sal !=3000 and sal !=5000;
select distinct job from emp where dept_id=3;
select name from emp where manager is null and dept_id=1;
select * from emp where job='销售' or job='人事' or job='程序员';
select sal,name from emp where name='刘备' or name='关羽' or name='张飞';
模糊
select name from emp where name like "孙%";
select * from emp where name like "%僧%";
select name from emp where name like '%精';
select * from emp where job like '%销售%' and sal>1500;
select name,job from emp where job like '_售';
select * from emp where dept_id in(1,2) and job like '市%';

select name,sal from emp order by sal limit 5,5;
select * from emp order by sal desc limit 0,1;
select * from emp order by hiredate limit 3,3;
select * from emp order by sal limit 4,2;


select * from emp where dept_id=3 and sal>1500;
select * from emp where dept_id=2 or manager is null;
select name,sal from emp where manager is not null order by sal desc;
select name,hiredate from emp where dept_id in(2,3) order by hiredata desc;
select name from emp where name like '%僧%' or name like '%精%';
select distinct job from emp where sal>2000;
select * from emp order by sal limit 6,2;

select max(sal) from emp where job='程序员';
select count(*) from emp where name like'%精%';
select sum(sal) from emp where job like '%销售%';
select max(sal) '最高工资',min(sal) '最低工资'  from emp where dept_id=2 ;

select avg(sal) from emp;
select dept_id,avg(sal) from emp group by dept_id;
select dept_id,count(*) from emp group by dept_id;
select job,count(*) from emp group by job;
select dept_id,count(*) from emp where sal>2000 group by dept_id;
select dept_id,count(*) from emp group by dept_id;
select dept_id,avg(sal) from emp group by dept_id limit 0,1;

