-- case
SELECT empno
     , ename
     , deptno
     , case when deptno = 10 then 'ACCOUNTINT'
            when deptno = 20 then 'RESEARCH'
            when deptno = 30 then 'SALES'
            when deptno = 40 then 'OPERATIONS'
       END dname
FROM emp;


-- student 테이블에서 주민번호를 이용해서 성별을 조회
-- 주민번호 7번재 숫자가 1이나3 이면 MAN, 2나 4 면 WOMAN으로 조회
-- 이름, 주민번호, 성별 (MAN,WOMAN)

SELECT s.name
     , s.jumin
     , SUBSTR(s.jumin,7,1)
     , case when SUBSTR(s.jumin,7,1) = 1  then 'MAN'
            when SUBSTR(s.jumin,7,1) = 3  then 'MAN'
            when SUBSTR(s.jumin,7,1) = 2  then 'WOMAN'
            when SUBSTR(s.jumin,7,1) = 4  then 'WOMAN'
       END gender 
FROM student s


SELECT s.name
     , s.jumin
     , SUBSTR(s.jumin,7,1)
     , case SUBSTR(s.jumin,7,1)
             when '1' then 'MAN'
             when '3' then 'MAN'
             when '2' then 'WOMAN'
             when '4' then 'WOMAN'
       END gender 
FROM student s


-- student 테이블에서 1전공이 101번인 학생의 이름, 전화번호, 지역을 조회
-- 단, 지역은 전화번호의 지역번호로
-- 02 : 서울, 031 : 경기, 051 : 부산, 052 : 울산, 055 : 경남

SELECT s.name
     , s.tel
     , SUBSTRING(s.tel, 1, INSTR(tel,')')-1)
          , case SUBSTRING(s.tel, 1, INSTR(tel,')')-1)
            when '02' then '서울'
            when '031' then '경기'
            when '051' then '부산'
            when '052' then '울산'
            when '055' then '경남'
       END 지역
FROM student s
WHERE 1=1
AND s.deptno1 = '101'


-- student 테이블에서 생년월일을 참조하여 태어난 달과 분기를 조회하여
-- 태어난 달이 1~3월이면 1/4분기, 4~6이면 2/4분기, 7~9면 3/4분기, 10~12면 4/4분기
-- 이름, 생년월일, 태어난 달, 분기
SELECT s.name
     , s.jumin
     , MONTH(s.birthday)
     , case 
            when MONTH(s.birthday) BETWEEN 1 AND 3 then '1/4분기'
            when MONTH(s.birthday) BETWEEN 4 AND 6 then '2/4분기'
            when MONTH(s.birthday) BETWEEN 7 AND 9 then '3/4분기'
            when MONTH(s.birthday) BETWEEN 10 AND 12 then '4/4분기'
      END 분기
FROM student s;


-- professor 테이블에서 학과번호, 교수명, 학과명 조회
-- 단, 학과번호가 101인 교수만 학과명을 Computer Engineering으로 하고 나머지는 아무것도 출력하지 않는다. 

SELECT p.profno
     , p.name
     , case (p.deptno)
             when '101' then 'Computer Engineering'
             ELSE ''
       END 학과명
FROM professor p
WHERE 1=1