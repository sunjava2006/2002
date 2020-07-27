-- 1����ѯ��Ա����������Ա�����ڵĲ��š��������ظ��ģ�ֻ�г�һ������
select department_name from departments where department_id in(
select distinct department_id from employees);

-- 2����ѯ���������κβ��ŵ�Ա����
select * from employees where department_id is null;

-- 3����ѯ��Ա����First_name��Pe��ͷ������Ա����
select * from employees where first_name like 'Pe%';

-- 4���г�Ա����ı�ṹ�����ֶεĶ��壩
desc employees;

-- 5����ѯ������������2005-2--7֮�䣨��������Ա�����г�Ա�������֡�
select first_name,hire_date from employees  where  hire_date  BETWEEN  to_date('2005-2-1','yyyy-mm-dd')  and  to_date('2005-7-31','yyyy-mm-dd');
select first_name,hire_date from employees where extract(year from hire_date)=2005 and EXTRACT(month from hire_date) between 2 and 7;

-- 6����Ա���ĸ�λ���飬���������λ��ƽ�����ʡ�
select job_title, avg_sal from jobs d right join
(select job_id,round(avg(nvl(salary,0))) avg_sal from employees group by job_id)x
on d.job_id=x.job_id;

-- 7����ѯ�г�Ա������ϸ��Ϣ���г�Ա�����֡���λ�����ڲ��ŵ����֡����ʡ������ص㡣
desc locations;
select first_name||' '||last_name name,job_title,department_name,salary,street_address
from employees e
left join jobs j on e.job_id=j.job_id
left join departments d on e.department_id=d.department_id
left join locations l on d.location_id=l.location_id;


-- 8��������ͳ�Ƴ������ŵĹ����ܺϣ��г����ŵ���
select d.department_name,sum(e.salary)
from employees e
left join departments d on e.department_id = d.department_id
group by d.department_name;

-- 9����ѯ����Europe(����)����������Ա����
select e.employee_id,first_name,l.* from employees e join departments d on e.department_id=d.department_id
join locations l on d.location_id=l.location_id
join countries c on l.country_id=c.country_id
join regions r on c.region_id=r.region_id
where r.region_name='Europe';

-- 10����ѯ��IT��������Ա�����г����ǵĹ��ʡ����֡�
select * from departments;
select d.department_name,first_name,salary from employees e join departments d 
on e.department_id=d.department_id where d.department_name='IT';

-- 11����ѯ����������UK��Ա�����г����ǵ����֡��������ڵء�
select first_name, street_address, city, state_province, country_name
from employees e
join departments d on e.department_id=d.department_id
join locations l on l.location_id=d.location_id
join countries c on l.country_id = c.country_id
where c.country_id='UK';

-- 12���г�������"Programmer"��λ��������Ա�����г����֡���ǰ��λ��
SELECT * FROM
(select * from employees where employee_id in
(select employee_id from job_history where job_id= 
(select job_id from jobs where job_title='Programmer')))a
join jobs j on a.job_id=j.job_id;



-- 13���г������ž�������ǹ����Ա�������֡���������������
select m.first_name m_name, m.employee_id m_id,e.manager_id , e.first_name, e.employee_id from
(select * from employees where employee_id in(select manager_id from departments))m
join employees e on e.manager_id=m.employee_id
order by m_name;


-- 14����ҳ��ѯ����Ա���Ĺ����������򡣲�ѯ��Ա�������֡�����������λ�������ʡ�ÿҳ5����¼����ѯ��1ҳ����2ҳ��
select first_name, job_title, department_name, salary, hire_date from(
select a.*, rownum ro from 
(select * from employees e
join jobs j on e.job_id=j.job_id
join departments d on d.department_id=e.department_id
order by e.hire_date)a where rownum<=10)where ro>5;

-- 15����ѯ����������߹��ʵ��ˡ�
select e.first_name,e.department_id, e.salary from employees e
join
(select department_id,max(salary)m from employees group by department_id)a
on e.department_id=a.department_id and e.salary=a.m;

-- 16����ѯ������λ��߹��ʵ��ˡ�
select e.first_name,e.job_id FROM employees e join (select job_id,max(salary)m from employees group by job_id)s
on e.job_id=s.job_id and e.salary=s.m;

select * from(
select first_name, job_id,salary ,rank() over(partition by job_id order by salary desc) ro from employees)
where ro=1;

-- 17����ѯ������λ�涨����ߣ������ޣ����ʵ��ˡ�
select first_name, salary, j.* from  employees e 
join jobs j on e.job_id=j.job_id and e.salary=j.max_salary;


--select emp.first_name, my.maxsalary,my.job_id
--from employees emp join (
--    select emp.job_id ,max(jb.max_salary) maxsalary
--    from employees emp join jobs jb on emp.job_id=jb.job_id
--    group by emp.job_id
--) my on emp.job_id = my.job_id;

-- 18����ѯ���������У�Ա�����ʣ�����Ϊ������ƽ�����ʵ��ˡ�
select first_name, salary , a.department_id from employees e join(
select department_id, round(avg(nvl(salary, 0))) avg_sal from employees
group by department_id)a on e.department_id=a.department_id and e.salary=a.avg_sal;

-- 19����ѯ��Ա������߹��ʵ�Ա�����ڵĲ��š�
select department_id,salary from employees where salary=(select max(salary) from employees);

-- 20����ѯ��Ա������߹��ʵ�Ա�����ڵĸ�λ�����ʡ���Ա��������ø�λ��߹���֮��Ĳ�
select j.max_salary-a.salary ���ʲ�,j.job_id, job_title,salary, j.max_salary  from
(select job_id, salary from employees where salary=(select max(salary)from employees))a
join jobs j on j.job_id=a.job_id;

-- 21����ѯ������λ��Ա��������λ��Ա���������ڵ������С�
select * from employees order by job_id desc ,hire_date desc;

-- 22����ѯ����London�ϰ��Ա��.�г����֡�
select first_name from employees e 
join departments d on e.department_id=d.department_id
join locations l on l.location_id=d.location_id
where l.city = 'London';

-- 23���Ƿ�ֻ�����۸�λ��Ա��������ɡ���ѯ�����ǻ�û�н����
select '��' from dual where not exists (select * from employees where joB_id not like 'SA%' and commission_pct is not null );

-- 24����˾ҪΪԱ����нˮ50%�������ܳ�������λ����߹��ʣ�����50%�󳬹��޶�Ĳ��ǡ��г�������н��Ա������ǰ���ʡ���н֮��Ĺ��ʡ���λ�������ޡ�
select first_name, salary, salary*1.5 new_sal, max_salary 
from employees e join jobs j on e.job_id=j.job_id
where salary*1.5<=j.max_salary;

-- 25����ѯ�����������ϸ�λ��������Ա�����г����������ĸ�λ��
select j.job_id ,j.job_title, a.employee_id, e.first_name from
(select * from job_history where employee_id in
(select employee_id from job_history group by employee_id having count(*)>=2))a
join jobs j on a.job_id=j.job_id
join employees e on e.employee_id = a.employee_id;


-- 26����ѯ�������Ź�����ߵ�2���ˡ�
select * from(
select e.*, row_number() over(partition by department_id order by salary desc) ro from employees e)
where ro <=2;

-- 27����ҳ��ѯ��Ա������нˮ�Ӹߵ������С�ÿҳ���10����¼��
select * from(
select a.*, rownum ro from
(select * from employees order by salary desc)a where rownum<=20)
where ro >10;

-- 28����ҳ��ѯ��Ա����нˮ����ȫԱƽ�����ʵ�Ա��������нˮ�Ӹߵ������С�ÿҳ���10����¼��
select * from(
select a.*, rownum ro from
(select * from employees where salary >(select avg(nvl(salary,0)) from employees)order by salary desc)a where rownum<=20)
where ro >10;
