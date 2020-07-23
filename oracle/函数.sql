--lower
select lower('HelloWorld') from t_users;
--upper
select upper(user_name), user_name from t_users;
select 20*3.14 from dual;

--initcap 
select initcap('jack') from dual;

--concat
select concat('hello','world') from dual;
select 2 || 4||6||7||7||9 from dual;

--substr
select substr('I like Python.', 4,1)from dual;

--instr
select instr('ilikepython', 'i', -1, 1)from dual;

--lpad  rpad
select lpad('hello', 10, '*')  from dual;

-- trim
select trim('a' from 'a hi a') from dual;

--ltrim rtrim
select rtrim('   h   ') from dual;

--replace
select replace('  9   ','9','10') from dual;

--length
select length('abcd') from dual;
select length(1111) from dual;

--round
select round(-153.14159265,-2) from dual;

--trunc
select trunc(3.9999, 3)from dual;

--mod
select mod(4,2) from dual;

--abs
select abs(-2) from dual;

select dbms_random.value(0,10)from dual;

-- sysdate
select sysdate from dual;

--months_between
select months_between(sysdate, sysdate+31) from dual;

--add_months
select add_months(sysdate,3) from dual;

--next-day
select  next_day(sysdate,1) from dual;

--last_day
select last_day(sysdate) from dual;

--round trunc
select to_char(trunc(sysdate, 'dd'),'yyyy-mm-dd HH24:mi:ss') from dual;

--extract
select extract(month from sysdate) from dual;

--to_char
select to_char(sysdate, 'syyyy-mm-dd HH24:mi:ss') from dual;
select to_char(6600, 'L999,999.999') from dual;

--to_date
select to_date('-221','syyyy')from dual;

--to_number
select to_number('$90,999', '$999,999')+1 from dual;

--nvl   null value
select nvl(null, 0) from dual;

--nvl2
select nvl2('', 2, 3) from dual;

--nullif
select nullif(2,22) from dual;

--coalesce
select coalesce(null,null,1,2,34) from dual;

select 'is' from dual where '' is null;
