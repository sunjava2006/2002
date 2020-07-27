-- 1、查询出员工表中所有员工所在的部门。（如有重复的，只列出一个）。
select department_name from departments where department_id in(
select distinct department_id from employees);

-- 2、查询出不属于任何部门的员工。
select * from employees where department_id is null;

-- 3、查询出员工中First_name以Pe开头的所有员工。
select * from employees where first_name like 'Pe%';

-- 4、列出员工表的表结构（表字段的定义）
desc employees;

-- 5、查询出工作日期在2005-2--7之间（包含）的员工，列出员工的名字。
select first_name,hire_date from employees  where  hire_date  BETWEEN  to_date('2005-2-1','yyyy-mm-dd')  and  to_date('2005-7-31','yyyy-mm-dd');
select first_name,hire_date from employees where extract(year from hire_date)=2005 and EXTRACT(month from hire_date) between 2 and 7;

-- 6、按员工的岗位分组，计算出各岗位的平均工资。
select job_title, avg_sal from jobs d right join
(select job_id,round(avg(nvl(salary,0))) avg_sal from employees group by job_id)x
on d.job_id=x.job_id;

-- 7、查询列出员工的详细信息：列出员工名字、岗位、所在部门的名字、工资、工作地点。
desc locations;
select first_name||' '||last_name name,job_title,department_name,salary,street_address
from employees e
left join jobs j on e.job_id=j.job_id
left join departments d on e.department_id=d.department_id
left join locations l on d.location_id=l.location_id;


-- 8、按部门统计出各部门的工资总合，列出部门的名
select d.department_name,sum(e.salary)
from employees e
left join departments d on e.department_id = d.department_id
group by d.department_name;

-- 9、查询出在Europe(区域)工作的所有员工。
select e.employee_id,first_name,l.* from employees e join departments d on e.department_id=d.department_id
join locations l on d.location_id=l.location_id
join countries c on l.country_id=c.country_id
join regions r on c.region_id=r.region_id
where r.region_name='Europe';

-- 10、查询出IT部门所有员工，列出他们的工资、名字。
select * from departments;
select d.department_name,first_name,salary from employees e join departments d 
on e.department_id=d.department_id where d.department_name='IT';

-- 11、查询出工作地在UK的员工，列出他们的名字、工作所在地。
select first_name, street_address, city, state_province, country_name
from employees e
join departments d on e.department_id=d.department_id
join locations l on l.location_id=d.location_id
join countries c on l.country_id = c.country_id
where c.country_id='UK';

-- 12、列出曾经在"Programmer"岗位工作过的员工，列出名字、当前岗位。
SELECT * FROM
(select * from employees where employee_id in
(select employee_id from job_history where job_id= 
(select job_id from jobs where job_title='Programmer')))a
join jobs j on a.job_id=j.job_id;



-- 13、列出各部门经理和他们管理的员工的名字。按经理名字排序。
select m.first_name m_name, m.employee_id m_id,e.manager_id , e.first_name, e.employee_id from
(select * from employees where employee_id in(select manager_id from departments))m
join employees e on e.manager_id=m.employee_id
order by m_name;


-- 14、分页查询，按员工的工作日期排序。查询出员工的名字、部门名、岗位名、工资。每页5条记录。查询第1页、第2页。
select first_name, job_title, department_name, salary, hire_date from(
select a.*, rownum ro from 
(select * from employees e
join jobs j on e.job_id=j.job_id
join departments d on d.department_id=e.department_id
order by e.hire_date)a where rownum<=10)where ro>5;

-- 15、查询出各部门最高工资的人。
select e.first_name,e.department_id, e.salary from employees e
join
(select department_id,max(salary)m from employees group by department_id)a
on e.department_id=a.department_id and e.salary=a.m;

-- 16、查询出各岗位最高工资的人。
select e.first_name,e.job_id FROM employees e join (select job_id,max(salary)m from employees group by job_id)s
on e.job_id=s.job_id and e.salary=s.m;

select * from(
select first_name, job_id,salary ,rank() over(partition by job_id order by salary desc) ro from employees)
where ro=1;

-- 17、查询出各岗位规定的最高（最上限）工资的人。
select first_name, salary, j.* from  employees e 
join jobs j on e.job_id=j.job_id and e.salary=j.max_salary;


--select emp.first_name, my.maxsalary,my.job_id
--from employees emp join (
--    select emp.job_id ,max(jb.max_salary) maxsalary
--    from employees emp join jobs jb on emp.job_id=jb.job_id
--    group by emp.job_id
--) my on emp.job_id = my.job_id;

-- 18、查询出各部门中，员工工资，正好为本部门平均工资的人。
select first_name, salary , a.department_id from employees e join(
select department_id, round(avg(nvl(salary, 0))) avg_sal from employees
group by department_id)a on e.department_id=a.department_id and e.salary=a.avg_sal;

-- 19、查询出员工中最高工资的员工所在的部门。
select department_id,salary from employees where salary=(select max(salary) from employees);

-- 20、查询出员工中最高工资的员工所在的岗位、工资、该员工工资与该岗位最高工资之间的差额。
select j.max_salary-a.salary 工资差,j.job_id, job_title,salary, j.max_salary  from
(select job_id, salary from employees where salary=(select max(salary)from employees))a
join jobs j on j.job_id=a.job_id;

-- 21、查询出各岗位的员工，按岗位、员工工作日期倒序排列。
select * from employees order by job_id desc ,hire_date desc;

-- 22、查询出在London上班的员工.列出名字。
select first_name from employees e 
join departments d on e.department_id=d.department_id
join locations l on l.location_id=d.location_id
where l.city = 'London';

-- 23、是否只有销售岗位的员工才有提成。查询返回是或没有结果。
select '是' from dual where not exists (select * from employees where joB_id not like 'SA%' and commission_pct is not null );

-- 24、公司要为员工涨薪水50%。但不能超过各岗位的最高工资，如涨50%后超过限额的不涨。列出可以涨薪的员工、当前工资、加薪之后的工资、岗位工资上限。
select first_name, salary, salary*1.5 new_sal, max_salary 
from employees e join jobs j on e.job_id=j.job_id
where salary*1.5<=j.max_salary;

-- 25、查询出在两个以上岗位工作过的员工。列出曾工作过的岗位。
select j.job_id ,j.job_title, a.employee_id, e.first_name from
(select * from job_history where employee_id in
(select employee_id from job_history group by employee_id having count(*)>=2))a
join jobs j on a.job_id=j.job_id
join employees e on e.employee_id = a.employee_id;


-- 26、查询出各部门工资最高的2个人。
select * from(
select e.*, row_number() over(partition by department_id order by salary desc) ro from employees e)
where ro <=2;

-- 27、分页查询出员工，按薪水从高到低排列。每页最多10条记录。
select * from(
select a.*, rownum ro from
(select * from employees order by salary desc)a where rownum<=20)
where ro >10;

-- 28、分页查询出员工（薪水大于全员平均工资的员工），按薪水从高到低排列。每页最多10条记录。
select * from(
select a.*, rownum ro from
(select * from employees where salary >(select avg(nvl(salary,0)) from employees)order by salary desc)a where rownum<=20)
where ro >10;
