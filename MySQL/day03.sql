select *
from emp
where manager is not null
  and sal between 1000 and 2000;

select sal
from emp
where manager is not null
order by sal desc limit 0,3;

select distinct job
from emp
where dept_id = 1
   or dept_id = 3;

select dept_id, count(*)
from emp
group by dept_id;

select job, count(*)
from emp
where manager is not null
group by job;

select dept_id, min(sal) "最低工资", max(sal) "最高工资", avg(sal) "平均工资"
from emp
group by dept_id;

select dept_id, avg(sal)
from emp
group by dept_id
having avg(sal) > 2000;

select job, count(*) 'c'
from emp
group by job
having 'c' > 1;

select dept_id, sum(sal) as "s"
from emp
where manager is not null
group by dept_id
having 's' > 5400;

select dept_id, avg(sal)
from emp
where sal between 1000 and 3000
group by job
having avg(sal) >= 2000;

SELECT *
FROM emp
where sal > (select avg(sal) from emp where dept_id = 2);

SELECT *
FROM emp
WHERE sal > (SELECT MAX(sal) from emp where job = '程序员');

SELECT *
FROM emp
ORDER BY sal desc LIMIT 0,1;

SELECT *
FROM emp
WHERE job = (select job from emp where name = '孙悟空')
  and name!='孙悟空';

查询拿最低工资员工的同事们的信息
SELECT *
FROM emp
where dept_id = (SELECT dept_id FROM emp where sal = (select min(sal) from emp))
  AND sal!=
select min(sal)
from emp;

查询每个人的姓名,工资和年终奖(五个月的工资)
SELECT name, sal, sal * 5 年终奖
from emp 给每个2号部门的员工涨薪5块
UPDATE emp
SET sal = sal + 5
WHERE dept_id = 2;

查询每个员工的姓名和对应的部门名
select e.name '姓名',d.name '部门'
from emp e,
     dept d
where e.dept_id = d.id;

SELECT e.name '姓名',sal, d.name '部门'
from emp e,
     dept d
where e.dept_id = d.id
  and e.sal > 2000;

SELECT e.name, d.loc "地址"
from emp e,
     dept d
where e.dept_id = d.id
  and e.name = '孙悟空';
查询每个员工的姓名和对应的部门名
SELECT e.name, d.name
FROM emp e
         JOIN dept d ON e.dept_id = d.id;

查询工资高于2000的员工姓名
,工资和部门名称
SELECT e.name, e.sal, d.name
FROM emp e
         JOIN dept d ON e.dept_id = d.id
WHERE e.sal > 2000;

查询孙悟空的部门地址
SELECT e.name, d.loc
FROM emp e
         JOIN dept d ON e.dept_id = d.id
WHERE e.name = '孙悟空';

查询所有员工姓名和对应的部门名
SELECT e.name, d.loc
FROM emp e
         LEFT JOIN dept d ON e.dept_id = d.id;

查询所有部门的工作地点和对应的员工姓名,工作
SELECT e.dept_id, e.name, e.job, d.loc
FROM emp e
         RIGHT JOIN dept d ON e.dept_id = d.id;

查询工资高于程序员平均工资的员工信息
SELECT *
FROM emp
WHERE sal>(SELECT avg(sal) FROM emp WHERE job='程序员');

查询人数为1的工作名称
SELECT job
FROM emp
WHERE  job IS NOT NULL group by job having count(*)=1;

查询1号和2号部门中工资大于2000的员工姓名和部门名
SELECT e.name,d.loc
FROM emp e
JOIN dept d ON e.dept_id = d.id
WHERE e.dept_id IN(1,2) AND e.sal>2000;

查询所有员工的名称,工资和对应的部门信息
SELECT e.name,sal,d.*
FROM emp e
LEFT JOIN dept d ON e.dept_id = d.id;
