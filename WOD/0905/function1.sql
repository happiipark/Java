-- ----------------------------------------------------
--   문자열 함수
-- ----------------------------------------------------


-- concat : 문자열 붙이기
SELECT CONCAT(ename,'(',job,')') AS 'ename_job' 

-- SMITH's sal is $800
SELECT CONCAT(ename, '''s sal
IS $' , sal) as info
FROM emp
WHERE 1=1
AND ENAME = 'smith';

-- format
SELECT FORMAT(250500.1254, 2);
SELECT empno, ename, sal FROM emp;
SELECT empno, ename, FORMAT(sal,0) FROM emp;

-- insert : 문자열 내의 지정된 위치에 특정 문자 수만큼 준자열 삽입
SELECT INSERT('http://naver.com',8,5,'kosta');

-- student 테이블에서 주민번호 뒤 7자리를 *로 대체하여 학생정보 조회
-- (학번, 이름, 주민번호, 학년)

SELECT studno 학번
     , NAME 이름
	  , INSERT(jumin,7,7,'*******') 주민번호
	  , grade 학년 
FROM student;

-- gogak 테이블의 고객번호와 이름 조회( 단, 이름은 가운대 글자를 *로 대체)
SELECT gno 고객번호
     , INSERT(gname,2,1,'*') 이름
FROM gogak;

-- instr : 문자열 내에서 특정 문자의 위치를 구한다
SELECT INSTR('http://naver.com','n');


SELECT INSTR(tel,')')
FROM student 

-- substr : 문자열 내에서 부분 문자열 추출
SELECT SUBSTRING('http://naver.com',8,5);
SELECT SUBSTRING('http://naver.com',8);

SELECT SUBSTR(tel,1,4)
FROM student;


SELECT SUBSTR(tel,1,instr(tel,')') -1)
FROM student;

-- stutent 테이블에서 주민번호 생년월일이 9월인 학생 조회

SELECT *
FROM student
WHERE 1=1
-- AND jumin LIKE '__09%'
AND SUBSTR(jumin,3,2) = '09';

-- student 테이블에서 전화번호의 지역번호 구하기
SELECT SUBSTRING(tel,1,INSTR(tel,')')-1) AS 지역번호
FROM student;


-- student 테이블에서 국번 구하기
SELECT SUBSTRING(tel,INSTR(tel,')')+1,INSTR(tel,'-')-INSTR(tel,')')-1) AS 국번
FROM student

-- length : 문자열의 길이 구하기
SELECT LENGTH(tel) 
FROM student;

SELECT LENGTH(email)
FROM professor;


SELECT email
     , INSTR(email,'@') 
FROM professor;

SELECT email
     , SUBSTRING(email, INSTR(email,'@')+1)
	  , LENGTH(SUBSTRING(email,INSTR(email,'@')+1)) as length
FROM professor;


SELECT email
     , INSERT(email,INSTR(email,'@')+1, LENGTH(SUBSTRING(email,INSTR(email,'@')+1)), 'kosta.com') AS changeDomain
     , SUBSTRING(email, INSTR(email,'@')+1)
	  , LENGTH(SUBSTRING(email,INSTR(email,'@')+1)) as length
FROM professor;


-- length : 문자열의 바이트 수 구하기 (영문 한 글자 : 1byte, 한글 한 글자 : 3 byte)

SELECT ename
     , LENGTH(ename) 
FROM emp;

SELECT NAME
     , LENGTH(NAME)  -- 
FROM student;


-- char_Length : 문자열의 글자 수 구하기

SELECT ename
     , CHAR_LENGTH(ename) 
FROM emp;

SELECT NAME
     , CHAR_LENGTH(NAME)  
FROM student;

-- substring := substr
SELECT SUBSTR('http://naver.com',8,5);
SELECT SUBSTRING('http://naver.com',8,5);



-- 소문자로 변경 : LOWER, LCASE
SELECT ename
     ,LOWER(ename)
FROM emp;

SELECT ename
     ,LCASE(ename)
FROM emp;


-- 대문자로 변경 : UPPER, UCASE
SELECT id
     , UPPER(id)
FROM professor;

SELECT id
     , UCASE(id)
FROM professor;


-- trim : 앞 뒤 공백 제거

SELECT LENGTH('  trim  ') --8
     , length(TRIM('  trim  ')) -- 4


-- Ltrim : 왼쪽 공백 제거 Rtrim : 오른쪽 공백 제거
SELECT LENGTH('  trim  ') --8
     , LENGTH(LTRIM('  trim  ')) -- 4
     
-- Rtrim : 오른쪽 공백 제거
SELECT LENGTH('  trim  ') --8
     , LENGTH(RTRIM('  trim  ')) -- 4



SELECT ename
     , sal
FROM emp;


-- lapd :  왼쪽을 특정 문자로 채워넣기
SELECT sal
     , lpad(ename,20,'$') AS 이름
FROM emp;

SELECT LPAD(email,20,'123456789') 
FROM professor



-- Rapd :  오른쪽을 특정 문자로 채워넣기
SELECT sal
     , rpad(ename,20,'$') AS 이름
FROM emp;




-- ----------------------------------------------------
--   날짜  함수
-- ----------------------------------------------------
-- curdate, CURRENT_DATE
SELECT CURDATE();  -- 시스템 날짜
SELECT CURRENT_DATE();

-- ADDDATE, DATE_ADD : 연, 월, 주, 일을 더하거나 빼기 함수
SELECT ADDDATE(CURDATE(), INTERVAL 1 DAY);  -- 하루 추가
SELECT ADDDATE(CURDATE(), INTERVAL 1 WEEK);  -- 일주   추가
SELECT ADDDATE(CURDATE(), INTERVAL 1 MONTH);  -- 한 달  추가
SELECT ADDDATE(CURDATE(), INTERVAL 1 YEAR);  -- 1 년  추가

SELECT DATE_ADD(CURDATE(), INTERVAL -1 YEAR);  -- 1 년  추가

-- emp 테이블에서 각 직원의 입사일과 10년 기념일을 조회
SELECT e.HIREDATE
     , ADDDATE(e.HIREDATE, INTERVAL 10 YEAR) AS 10주년
FROM emp e;

SELECT e.HIREDATE
     , ADDDATE(e.HIREDATE, 2) -- default 가 day임
FROM emp e;

--  curtime, currnet_time
SELECT CURTIME()
     ,  CURRENT_TIME();
     
SELECT CURTIME()
     , ADDTIME(CURTIME(),'1:10:5');  -- add 1 hour 10 minite 5 second

-- now() : 현재 날짜 & 시간
SELECT NOW();  

SELECT NOW()
     , ADDTIME(NOW(), '2 1:10:5'); -- add 2 day 1 hour 10 minte 5 second
     
     
-- DATEDIFF
SELECT hiredate
     , DATEDIFF(CURDATE(), hiredate) 
FROM emp;


SELECT DATEDIFF(CURDATE(), '1996-05-02') AS 일수;

-- DATA_FORMAT
SELECT DATE_FORMAT('2017-06-15',"%M-%d-%Y");
SELECT NOW(), DATE_FORMAT(NOW(), "%M %d %Y %H:%i:%s");
SELECT NOW(), DATE_FORMAT(NOW(), "%b %d %Y %H:%i:%s %a");
-- 월 : %M(September), %m(09), %b(Sep), %d(9)
-- 연 : %Y(2023), %y(23)
-- 일 : %d(05), %e(5)
-- 요일 : %W(Tuesday), %a(Tue)
-- 시간 : %H(24시간), %L(12시간)
-- %r : hh:mm:ss AM,PM
-- 분 : %i
-- 초 : %S


-- DATE_SUB : 날짜 빼기
SELECT CURDATE()
     , DATE_SUB(CURDATE(), INTERVAL 10 DAY);
SELECT CURDATE()
     , ADDDATE(CURDATE(), INTERVAL -10 DAY); 
     
-- DAY, DAYOFMONTH : 날짜에서 일 추출
SELECT hiredate
     , DAY(hiredate)
FROM emp

SELECT hiredate
     , DAYOFMONTH(hiredate)
FROM emp

SELECT hiredate
     , YEAR(hiredate)
FROM emp

-- DAYNAME :날짜에서 요일 추출
SELECT hiredate
     , DAYNAME(hiredate)
FROM emp

SELECT hiredate
     , DAYOFWEEK(hiredate) -- 일요일부터 1로 시작하여 2(월), 3(화), 4(수),... 6(토)
FROM emp


-- EXTRACT 
SELECT CURDATE()
     , EXTRACT(MONTH FROM CURDATE()) AS MONTH;
     
SELECT CURDATE()
     , EXTRACT(YEAR FROM CURDATE()) AS YEAR;
     
SELECT CURDATE()
     , EXTRACT(DAY FROM CURDATE()) AS DAY;
     
SELECT CURDATE()
     , EXTRACT(WEEk FROM CURDATE()) AS WEEK;
     
SELECT CURDATE()
     , EXTRACT(QUARTER FROM CURDATE()) AS QUARTER;
     
SELECT CURDATE()
     , EXTRACT(YEAR_MONTH FROM CURDATE()) AS "YEAR_MONTH";
     
SELECT CURDATE()
     , EXTRACT(WEEK FROM CURDATE()) AS HOUR;
     
SELECT NOW()
     , EXTRACT(minute FROM NOW()) AS minute
     
SELECT NOW()
     , EXTRACT(second FROM NOW()) AS second
     
     
-- TIME_TO_SEC 시간을 초로 변환
SELECT CURTIME()
     , TIME_TO_SEC(CURTIME());
     
-- TIMEDIFF
SELECT TIMEDIFF(CURTIME(), '08:49:27');
SELECT CURTIME(), TIME_TO_SEC(TIMEDIFF(CURTIME(), '08:49:27');


-- ----------------------------------------------------
--   숫자 함수
-- ----------------------------------------------------

-- count : 조건에 만족하는 레코드 (행) 수

select COUNT(*)  
FROM  emp;

select COUNT(comm) -- 컬럼명이 매개변수로 사용시 null인 레코드는 제외
FROM  emp;

SELECT COUNT(*) 
FROM emp
WHERE 1=1
AND deptno=10;

-- sum 
SELECT SUM(sal)
FROM emp;

SELECT sum(sal) 
FROM emp
WHERE 1=1
AND deptno=10;


-- avg
SELECT SUM(sal)
     , AVG(sal)
FROM emp;

SELECT SUM(sal)
     , COUNT(*)
     , SUM(sal)/COUNT(*)
     , AVG(sal)
FROM emp;

SELECT SUM(comm)
     , COUNT(comm)
     , COUNT(*)
     , SUM(comm)/COUNT(*)
     , SUM(comm)/COUNT(comm)
     , AVG(comm)
FROM emp;

SELECT SUM(comm)
     , SUM(comm)/COUNT(*)
     , AVG(IFNULL(comm,0))
FROM emp;


-- max
SELECT ename
     , MAX(sal)
FROM emp


-- min
SELECT ename
     , MIN(sal)
FROM emp;

-- professor 테이블에서 각 교수들의 연봉을 조회
-- 교수번호, 이름, 월급여, 보너스, 연봉

SELECT profno AS 교수번호
     , NAME AS 이름
     , pay AS 월급여
     , bonus AS 보너스
     , pay*12*IFNULL(bonus,50) AS 연봉
FROM professor


-- group by
SELECT deptno
     , job
     , COUNT(*)
     , SUM(sal)
FROM emp
GROUP BY deptno, job;

-- student 테이블에서 메인 학과별 학생수 조회
SELECT deptno1
     , COUNT(*)
FROM student
GROUP BY deptno1;

-- student 테이블에서 학년별 평균 키 조회
SELECT grade
     , FORMAT(AVG(height),1)
FROM student
GROUP BY grade;

SELECT MAX(sal)
     , deptno
FROM emp
GROUP BY deptno;

SELECT deptno
     , ename
     , MAX(sal)
FROM emp
GROUP BY deptno;

SELECT deptno
     , AVG(sal)
FROM emp
GROUP BY deptno;


-- group by에 대한 조건은 HAVING
-- emp 테이블에서 평균 급여가 2000 이상인 부서의 부서번호와 평균급여 조회
SELECT deptno
     , AVG(sal)
FROM emp
GROUP BY deptno
HAVING AVG(sal) >= 2000;  


-- student 테이블에서 각학과와 학년별 평균 몸무게, 최대/최소 몸무게 조회

SELECT s.deptno1
     , s.grade
     , COUNT(*)
     , FORMAT(AVG(s.weight),1)
     , MAX(s.weight)
     , MIN(s.weight)
FROM student s
group BY s.deptno1, s.grade
HAVING AVG(s.weight)>50
ORDER BY s.deptno1, s.grade;