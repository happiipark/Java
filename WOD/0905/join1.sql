-- Join

DROP TABLE test1;

CREATE TABLE test1(
A VARCHAR(10),
B VARCHAR(20)
);

CREATE TABLE test2(
A VARCHAR(10),
C VARCHAR(20),
D VARCHAR(20)
);

INSERT INTO test1 VALUES('a1','b1');
INSERT INTO test1 VALUES('a2','b2');

INSERT INTO test2 VALUES('a3','c3','d3');
INSERT INTO test2 VALUES('a4','c4','d4');
INSERT INTO test2 VALUES('a4','c5','d5');

SELECT t1.*
     , t2.*
FROM test1 t1
   , test2 t2
WHERE 1=1
AND t1.A='a1';


SELECT e.EMPNO
     , e.ENAME
     , d.dname
FROM emp e
   , dept d
where 1=1
AND e.DEPTNO = d.DEPTNO;


-- ANSI join (표준 join)
SELECT e.EMPNO
     , e.ENAME
     , d.dname
FROM emp e
INNER JOIN dept d  -- JOIN == (INNER) JOIN
ON e.DEPTNO = d.DEPTNO
WHERE 1=1
AND e.DEPTNO = 10;

-- student, department 테이블을 이용하여 학번, 학생명, 제1학과명 조회

-- 안시 조인
SELECT s.studno
     , s.name
     , d.dname
FROM student s
JOIN department d
ON s.deptno1 = d.deptno;

-- 오라클 조인
SELECT s.studno
     , s.name
     , d.dname
FROM student s
   , department d
WHERE 1=1
AND s.deptno1 = d.deptno;


-- student, professor 테이블을 이용하여, 학번, 학생명, 담당교수명을 조회

-- LEFT JOIN : 왼쪽에 테이블 데이터는 다 읽어옴
SELECT s.studno AS 학번
     , s.name AS 학생명
     , p.name AS 담당교교수명
FROM student s
LEFT JOIN professor p
ON s.profno = p.profno;

-- 오라클 조인
SELECT s.studno AS 학번
     , s.name AS 학생명
     , p.name AS 담당교교수명
FROM student s
   , professor p
WHERE 1=1
AND s.profno = p.profno;



-- RIGHT JOIN : 오른쪽에 테이블 데이터는 다 읽어옴
SELECT s.studno AS 학번
     , s.name AS 학생명
     , p.name AS 담당교교수명
FROM student s
RIGHT JOIN professor p
ON s.profno = p.profno;


-- UNION : 합집합
SELECT s.studno AS 학번
     , s.name AS 학생명
     , p.name AS 담당교교수명
FROM student s
LEFT JOIN professor p
ON s.profno = p.profno
UNION ALL
SELECT s.studno AS 학번
     , s.name AS 학생명
     , p.name AS 담당교교수명
FROM student s
RIGHT JOIN professor p
ON s.profno = p.profno;


-- student, department, professor를 이용하여 학번, 이름, 제1전공명, 담당교수명 조회
SELECT s.studno
     , s.name
     , d.dname
     , p.name
FROM student s
   , department d
   , professor p
WHERE 1=1
AND s.deptno1 = d.deptno
AND s.profno = p.profno;


SELECT s.studno
     , s.name
     , d.dname
     , p.name
FROM student s
JOIN department d
ON s.deptno1 = d.deptno
LEFT JOIN professor p
ON s.profno = p.profno;



-- student, exam_01 테이블을 이용하여 학번, 이름, 시험점수 조회

-- 안시조인
SELECT s.studno
     , s.name
     , e.total
FROM student s
JOIN exam_01 e
ON s.studno = e.studno
ORDER BY e.total;

-- 오라클조인
SELECT s.studno
     , s.name
     , e.total
FROM student s
   , exam_01 e
WHERE 1=1
AND s.studno = e.studno
ORDER BY e.total;


-- student, exam_01, hakjum 테이블을 이용하여 학번, 이름, 시험점수 ,학점 조회

SELECT s.studno
     , s.name
     , e.total
     , h.grade
FROM student s
LEFT JOIN exam_01 e
ON s.studno = e.studno 
JOIN hakjum h
ON e.total BETWEEN h.min_point AND h.max_point
ORDER BY e.total desc;


SELECT s.studno
     , s.name
     , e.total
     , h.grade
FROM student s
   , exam_01 e
   , hakjum h
WHERE 1=1
AND s.studno = e.studno
AND e.total BETWEEN h.min_point AND h.max_point
ORDER BY e.total DESC;



-- gojak, gift 테이블을 이용하여 고객의 모든정보와, 고객이 본인의 포인터로 받을 수 있는 가장 좋은 상품

SELECT go.*
     , gi.gname
FROM gogak go
JOIN gift gi
ON go.point BETWEEN gi.g_start AND gi.g_end
ORDER BY go.point;


SELECT go.*
     , gi.gname
FROM gogak go
   , gift gi
WHERE 1=1
AND go.point BETWEEN gi.g_start AND gi.g_end
ORDER BY go.point;


-- emp2, p_grade 테이블을 이용하여 이름, 직위, 급여, 같은 직급의 최소급여, 최대급여 조회

SELECT e.NAME
     , e.position
     , p.s_pay
     , p.e_pay
FROM emp2 e
JOIN p_grade p
ON e.position = p.position
GROUP BY e.name, e.position;


SELECT e.NAME
     , e.position
     , p.s_pay
     , p.e_pay
FROM emp2 e
   , p_grade p
WHERE 1=1
AND e.position = p.position
GROUP BY e.name, e.position;


-- emp2, p_grade 테이블을 이용하여 이름, 직위, 나이, 본인의 나이에 해당하는 예상 직븝 조회 

SELECT e.name
     , e.position
     , YEAR(NOW()) - YEAR(e.BIRTHDAY) AS 나이
     , p.position
FROM emp2 e
JOIN p_grade p
ON YEAR(NOW()) - YEAR(e.BIRTHDAY) BETWEEN p.s_age AND p.e_age
WHERE 1=1;


SELECT e.name
     , e.position
     , YEAR(NOW()) - YEAR(e.BIRTHDAY) AS 나이
     , p.position
FROM emp2 e
   , p_grade p
WHERE 1=1
AND YEAR(NOW()) - YEAR(e.BIRTHDAY) BETWEEN p.s_age AND p.e_age;


-- gogak, gift 테이블을 이용하여 노트북을 받을 수 있는 고객의 이름, 포인트, 상품명 조회

SELECT go.gname
     , go.point
     , gi.gname
FROM gogak go
JOIN gift gi
ON go.point >= gi.g_start
WHERE 1=1
AND gi.gname = '노트북';


SELECT go.gname
     , go.point
     , gi.gname
FROM gogak go
   , gift gi
WHERE 1=1
AND gi.gname = '노트북'
and go.point >= gi.g_start;


-- self join 
-- dept2 테이블을 이용하여 부서의 모든 정보와 각 부서의 상위 부서명을 조회
SELECT d1.*
     , d2.DNAME AS 상급부서
FROM dept2 d1
left JOIN dept2 d2
ON d1.PDEPT = d2.DCODE;


SELECT d1.*
     , d2.DNAME AS 상급부서
FROM dept2 d1
   , dept2 d2
WHERE 1=1
and d1.PDEPT = d2.DCODE;



-- emp 테이블을 이용하여 직원의 사번, 이름, 담당 매니저 사번과 이름 조회

SELECT e1.EMPNO
     , e1.ENAME
     , e1.MGR AS '매니저번호>'
     , e2.EMPNO
     , e2.ENAME
FROM emp e1 -- 사원
left JOIN emp e2 -- 매니저
ON e1.MGR = e2.EMPNO;

SELECT e1.EMPNO
     , e1.ENAME
     , e1.MGR AS '매니저번호>'
     , e2.EMPNO
     , e2.ENAME
FROM emp e1 -- 사원
   , emp e2 -- 매니저
WHERE 1=1
and e1.MGR = e2.EMPNO;


-- student, department 테이블을 이용하여, 학번, 이름, 제 1 전공명, 제2 전공명 조회

SELECT s1.studno
     , s1.name
     , d1.dname
     , d2.dname
--     , d1.deptno AS 전공1
--     , d2.deptno AS 전공2
FROM student s1
JOIN department d1
ON s1.deptno1 = d1.deptno
left JOIN department d2
ON s1.deptno2 = d2.deptno;


-- 컴퓨터 공학부에 해당하는 학생의 학번, 이름 ,학번


SELECT s.*
     , d.*
FROM student s
   , department d
WHERE 1=1
AND s.deptno1 = d.deptno
AND d.part = 100;


SELECT s.studno
     , s.name
     , s.deptno1
     , d1.dname
     , d2.dname
FROM student s
JOIN department d1
ON s.deptno1 = d1.deptno
JOIN department d2
ON d1.part = d2.deptno
WHERE 1=1
AND d2.dname = '컴퓨터정보학부';




-- student, department 테이블을 이용하여 '전자제어관' 에서 수업을 듣는 학생 조회

SELECT s.studno AS 학번
     , s.name AS 이름
     , s.deptno1 AS '전공 번호'
     , s.deptno2 AS '부전공 번호'
     , d1.dname  AS '전공명'
     , d2.dname AS '부전공명'
     , d1.build AS '전공 수업 장소'
     , d2.build AS '부전공 수업 장소'
FROM student s
JOIN department d1
ON s.deptno1 = d1.deptno
left JOIN department d2
ON s.deptno2 = d2.deptno
WHERE 1=1
AND d1.build = '전자제어관' OR d2.build = '전자제어관';


-- emp 테이블을 이용하여 사번, 이름, 입사일, 자신보다먼저 입사한 사람 인원수 조회

SELECT e1.EMPNO
     , e1.ENAME
     , e1.HIREDATE
     , COUNT(e2.HIREDATE)
FROM emp e1 
left JOIN emp e2 
ON e1.HIREDATE > e2.HIREDATE
WHERE 1=1
GROUP BY e1.EMPNO, e1.ENAME
ORDER BY COUNT(e2.HIREDATE);

 -- professor 테이블을 이용하여 교수번호, 교수이름, 입사일, 자신보다 먼저 입사한 사람 인원수 조회
 
SELECT p1.profno
     , p1.name
     , p1.hiredate
     , COUNT(p2.hiredate)
FROM professor p1  -- 자신
left JOIN professor p2  -- 선배
ON p1.hiredate > p2.hiredate
WHERE 1=1
GROUP BY p1.name
ORDER BY COUNT(p2.hiredate);


--

SELECT e.*
     , d.dname
FROM emp e
JOIN dept d
ON e.DEPTNO = d.DEPTNO;



-- 조인 하는 컬럼명이 같을 경우  USING(조인할 컬럼명)
SELECT e.*
     , d.DNAME
FROM emp e 
JOIN dept d USING(deptno);


-- 조인 하는 컬럼명이 같을 경우  NATURAL(동일한 컬럼을 찾아서 자동으로)
SELECT e.*
     , d.DNAME
FROM emp e 
NATURAL JOIN dept d;


SELECT s.*
     , p.name
FROM student s 
left JOIN professor p USING(profno)
UNION
SELECT s.*
     , p.name
FROM student s 
right JOIN professor p USING(profno);

