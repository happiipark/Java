SELECT * 
FROM emp;

SELECT empno
     , ename
FROM emp;


SELECT *
FROM dept;

SELECT deptno
     , dname
FROM dept;

SELECT studno
      , name
		, birthday
		, tel 
FROM student;

SELECT  empno
      , ename
      , deptno
FROM  emp
WHERE deptno = 10;

SELECT empno
     , ename
     , job
     , deptno
FROM emp
WHERE 1=1
AND deptno > 10;




SELECT studno
     , name
     , birthday
     , tel
     , grade
FROM student
WHERE 1=1
AND grade = 4;


SELECT * 
FROM student 
WHERE 1=1
-- AND grade = 2 OR grade = 3;
-- AND grade BETWEEN 2 AND 3;
AND grade IN(2,3);


SELECT * 
FROM student 
WHERE 1=1
-- AND grade = 2 OR grade = 3;
-- AND grade BETWEEN 2 AND 3;
AND grade NOT IN(4);



SELECT EMPNO
     , ENAME
     , JOB
FROM emp
WHERE 1=1
AND job IN ('CLERK','SALESMAN');


SELECT EMPNO AS 사번
     , ENAME AS 이름
     , JOB AS 직무
FROM emp
WHERE 1=1
AND job IN ('CLERK','SALESMAN');


SELECT studno AS 학번
     , NAME AS 이름
     , grade AS 학년
FROM student 
WHERE 1=1
-- AND grade = 2 OR grade = 3;
-- AND grade BETWEEN 2 AND 3;
AND grade  IN(4);



SELECT *
FROM professor
WHERE 1=1
AND hpage IS NULL;

SELECT  * 
FROM emp
WHERE 1=1
AND hiredate  >= '19850101';


SELECT  * 
FROM student
WHERE 1=1
-- AND birthday BETWEEN '19760101' AND  '19761231';
AND birthday LIKE '%1976%';



SELECT *
FROM emp
WHERE 1=1
AND deptno = 10
AND sal >= 2000;


SELECT * 
FROM professor
WHERE 1=1
AND deptno = 101
AND POSITION = '정교수';


SELECT *
FROM student
WHERE 1=1
AND deptno1 = 101 OR deptno2 = 101;


SELECT *
FROM student
WHERE 1=1
AND (deptno1 = 101 OR deptno2 = 101)
AND grade IN (1,2);

SELECT NAME
     , position
     , pay
FROM emp2
WHERE 1=1
AND EMP_TYPE = '정규직'
AND pay >= 50000000;

SELECT p.NAME
     , p.position
     , p.deptno
FROM professor p
WHERE 1=1
AND deptno IN(101,102,103)




SELECT s.studno
     , s.name
     , s.grade
     , s.profno
FROM student s
    , professor p
WHERE 1=1
AND s.profno = p.profno
AND p.profno = 1001;


SELECT gno
     , gname
     , point
FROM gogak
WHERE 1=1
AND point >= 600001;


SELECT *
FROM exam_01
WHERE 1=1
AND total BETWEEN 80 AND 89;
-- AND total BETWEEN 80 AND 89;

SELECT *
FROM student
WHERE 1=1
AND birthday BETWEEN '19760101' AND '19761231';



SELECT *
FROM emp
WHERE 1=1
ORDER BY sal;


SELECT *
FROM emp
WHERE 1=1
AND deptno = 10
ORDER BY sal DESC;



SELECT studno
     , NAME 
     , birthday
     , deptno1
FROM student
WHERE 1=1
AND grade = 4
ORDER BY birthday;



SELECT *
FROM emp 
ORDER BY deptno, sal;



SELECT *
FROM student 
WHERE 1=1
ORDER BY grade, height DESC;




SELECT DISTINCT deptno1
FROM student;


SELECT *
FROM student
WHERE 1=1
AND NAME LIKE '서%';



SELECT *
FROM student
WHERE 1=1
AND jumin LIKE '__09%';


SELECT profno
     , name
     , pay
     , bonus
     , pay + ifnull(bonus,0) AS totPay
FROM professor
-- WHERE 1=1
-- AND bonus IS NOT NULL;



SELECT empno
     , ENAME
     , SAL
     , COMM
FROM emp
WHERE 1=1
AND sal > 1000
AND comm < 1000 OR comm IS null;



-- concat : 문자열 붙이기
SELECT CONCAT(ename,'(',job,')') AS 'ename_job' 
FROM emp

-- smith sal is $800


SELECT CONCAT(ename, '''s sal IS $' , sal) as info
FROM emp
WHERE 1=1
AND ENAME = 'smith'