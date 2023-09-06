-- SELECT COLUMN_LIST 
-- FROM TABLE
-- WHERE 조건연산자(SELECT COLUMN_LIST FROM TABLE WHERE 조건);

-- =,<>(!=),>,>=,<,<= : 단일행 서브쿼리 연산자
-- 16 + 16
SELECT ename
     , comm
FROM emp
WHERE 1=1
and comm < (
            SELECT comm 
            FROM emp 
				WHERE ename='WARD'
				);

-- 16 + 16
SELECT e1.ENAME 
     , e1.comm
FROM emp e1
   , emp e2
WHERE 1=1
and e2.ENAME = 'WARD' 
AND e1.comm < e2.comm;

-- student , department 테이블을 이용하여 서진수 학생과 주전공이 동일한 학생들의 이름과 전공 조회

SELECT s.deptno1
FROM student s
WHERE 1=1
AND s.name = '서진수';


SELECT s2.name
     , d.dname
FROM student s2
JOIN department d 
ON s2.deptno1 = d.deptno
WHERE 1=1
AND s2.deptno1 = (
						SELECT s.deptno1
						FROM student s
						WHERE 1=1
						AND s.name = '서진수'
					 );

-- professor departmnet 테이블이용 박원범 교수보다 나중에 입사한 사람의 이름과 입사일 학과명 조회

SELECT p.hiredate
FROM professor p
WHERE 1=1
AND p.name = '박원범';



SELECT p.name
     , p.hiredate
     , d.dname
FROM professor p
JOIN department d
ON p.deptno = d.deptno
WHERE 1=1
AND p.hiredate > (
							SELECT p1.hiredate
							FROM professor p1
							WHERE 1=1
							AND p1.name = '박원범'
					  );


-- student 주전공이 201인학과의 평균 몸무게보다 많은 학생이름,몸무게

SELECT AVG(s.weight)
FROM student s
WHERE 1=1
AND s.deptno1 = '201';


SELECT s.name
     , s.weight
FROM student s
WHERE 1=1
AND s.weight > (
						SELECT AVG(s1.weight)
						FROM student s1
						WHERE 1=1
						AND s1.deptno1 = '201'
				   )
ORDER BY s.weight;


-- stu 테이블 주전공 전자공학과 학과평균몸무게보다 많은 이름,몸무게

SELECT AVG(s.weight)
FROM student s
JOIN department d
ON s.deptno1 = d.deptno
WHERE 1=1
AND d.dname = '전자공학과';


SELECT s1.name
     , s1.weight
FROM student s1
WHERE 1=1
AND s1.weight > (
						SELECT AVG(s.weight)
						FROM student s
						JOIN department d
						ON s.deptno1 = d.deptno
						WHERE 1=1
						AND d.dname = '전자공학과'
					 )
ORDER BY s1.weight DESC
;

-- 여기부터 다시 풀어보기
-- gogak gift 노트북을 받을 수 있는 고객의 이름 포인트 상품명
SELECT gogak.gname ,gogak.point, gift.gname
FROM gogak JOIN gift
WHERE gogak.point >=
		(SELECT g_start 
		FROM gift 
		WHERE gname = '노트북');

-- emp dept 테이블을 이용 'NEW YORK' 에 근무하는 직원 목록 조회
SELECT emp.*
FROM emp
WHERE deptno = 
		(SELECT deptno 
		FROM dept 
		WHERE loc='NEW YORK');

-- 박원범 교수가 지도하는 학생 목록
SELECT student.*
FROM student 
WHERE profno = 
		(SELECT profno 
		FROM professor
		WHERE NAME = '박원범');

-- gogak gift 안광훈 고객이 포인트로 받을 수 있는 상품 목록 조회
SELECT gift.gname
FROM gift
WHERE g_start <=
		(SELECT point
		FROM gogak
		WHERE gname = '안광훈');
		
-- emp ,dept 테이블 이용 sales 부서를 제외한 나머지 부서에 속한 직원의 사번 이름 부서명 조회
SELECT e.EMPNO as 사번,e.ENAME as 이름, d.DNAME as 부서명
FROM emp e JOIN dept d
USING(deptno)
WHERE e.DEPTNO !=
		( SELECT deptno
		FROM dept 
		WHERE dname = 'SALES');
		
-- student, exam_01, hakjum, 테이블을 이용해 학점이 B0 미만인 학생의 학번 이름 점수 조회

SELECT s.studno AS 학번, s.name AS 이름, e.total AS 점수
FROM student s JOIN exam_01 e
ON s.studno = e.studno
WHERE e.total <
		( SELECT min_point 
		FROM hakjum
		WHERE grade = 'B0' )
ORDER BY 3 DESC;		
		
-- student, exam_01, hakjum, 테이블을 이용해 학점이 A0 인  학생의 학번 이름 점수 조회
SELECT s.studno AS 학번, s.name AS 이름, e.total AS 점수
FROM student s JOIN exam_01 e
USING(studno)
WHERE e.total 
		BETWEEN 
				( SELECT min_point 
				FROM hakjum
				WHERE grade = 'A0' ) 
				AND 
				( SELECT max_point
				FROM hakjum
				WHERE grade = 'A0')
ORDER BY 3 DESC;



-- 다중행 서브쿼리 연산자
-- in, exists, >any, <any, <all, >all
-- in(a,b) : a,b중에 있으면
-- exists : 서브쿼리 안에 존재하면 true 없으면 false
--  >any : 서브쿼리 결과가 여러개인데 그 결과 어떤 하나보다 크면 (행을 걸러주기 위함)
-- <any : 어떤 하나보다 크면
-- >all : (가장작은) 결과보다 크면
-- <all : (가장 큰) 결과보다 작으면

-- emp2 , dept2 테이블을 이용 '포항본사'에서 근무하는 직원들의 사번, 이름, 직급, 부서명  조회
SELECT e.EMPNO AS 사번,e.NAME AS 이름 ,e.position AS 직급,d.DNAME AS 부서명
FROM emp2 e JOIN dept2 d
ON e.DEPTNO = d.DCODE
WHERE e.deptno in
		(SELECT dcode 
		FROM dept2
		WHERE AREA = '포항본사');


-- emp2 테이블을 이용 '과장'직급의 최소연봉자보다 연봉이 높은 직원의 사번, 이름, 연봉 조회
SELECT empno AS '사번',NAME AS '이름', pay AS '연봉'
FROM emp2
WHERE pay >ANY 
		(SELECT pay 
		FROM emp2 
		WHERE POSITION = '과장');


SELECT empno AS '사번',NAME AS '이름', pay AS '연봉'
FROM emp2
WHERE pay >
		(SELECT MIN( pay ) 
		FROM emp2 
		WHERE POSITION = '과장');

-- 여기까지 풀어보기 ^^^^^

-- 각 학년별 키가 가장 큰 학생의 이름과 학년 조회

SELECT s.grade AS 학년
     , s.name AS 이름
     , MAX(s.height) AS 키
FROM student s
WHERE 1=1 
GROUP BY s.grade;

SELECT NAME
     , grade
     , height
FROM student
WHERE 1=1
AND (grade, height) IN (
									SELECT grade
									     , MAX(height)
									FROM student
									WHERE 1=1
									GROUP BY grade
								)
ORDER BY grade;


-- student 테이블에서 2학년 학생들의 체중에서 가장 적게 나가는 학생보다 적은 학생의 이름, 학년, 몸무게 조회

SELECT MIN(s.weight)
FROM student s
WHERE 1=1
AND grade = 2;


SELECT s.name
     , s.grade
     , s.weight
FROM student s
WHERE 1=1
AND s.weight < (
						SELECT MIN(s.weight)
						FROM student s
						WHERE 1=1
						AND grade = 2
					);
					
					
-- emp2 테이블에서 자기가 속한 부서의 평균 연봉보다 적게 받는 직원의 이름, 연봉, 부서명 조회

SELECT e1.NAME
     , e1.PAY
     , d.DNAME
FROM emp2 e1
JOIN dept2 d
ON e1.DEPTNO = d.DCODE
WHERE 1=1
AND e1.PAY < (
					SELECT AVG(pay)
					FROM emp2 
					WHERE 1=1
					AND deptno = e1.DEPTNO
				 );
				 
				 
-- emp2, dept2 테이블에서 각 부서별 평균 연봉을 구하고 그 중에서 평균 연봉이 가장 적은 부서의 평균
-- 연봉보다 많이 받는 직원들의 직원명, 부서명, 연봉 조회

SELECT d.DNAME
     , AVG(e.PAY)
FROM emp2 e
JOIN dept2 d
ON e.DEPTNO = d.DCODE
WHERE 1=1
GROUP BY e.DEPTNO
ORDER BY AVG(e.PAY);




SELECT e2.NAME
     , d2.DNAME
     , e2.PAY
FROM emp2 e2
JOIN dept2 d2
ON e2.DEPTNO = d2.DCODE
WHERE 1=1
AND  e2.PAY >ANY (
						SELECT AVG(e.PAY)
						FROM emp2 e
						JOIN dept2 d
						ON e.DEPTNO = d.DCODE
						WHERE 1=1
						GROUP BY e.DEPTNO
						);


-- professor, department 테이블에서 각 학과별 입사일이 가장 오래된 교수의 교수번호, 이름, 입사일, 하학과명 조회


SELECT MIN(p.hiredate)
FROM professor p
JOIN department d
ON p.deptno = d.deptno
WHERE 1=1
GROUP BY p.deptno
;

SELECT p.profno
     , p.name
     , p.hiredate
     , d.dname
FROM professor p
JOIN department d
ON p.deptno = d.deptno
WHERE 1=1
AND p.hiredate IN (
						SELECT MIN(p.hiredate)
						FROM professor p
						JOIN department d
						ON p.deptno = d.deptno
						WHERE 1=1
						GROUP BY p.deptno
					  )
ORDER BY p.hiredate;  



--  emp2 테이블에서 직급별 최대 연봉을 받는 직원의 이름과 직급, 연봉 조회

SELECT e.POSITION
     , MAX(pay)
FROM emp2 e
GROUP BY e.POSITION;

SELECT e1.NAME
     ,  case (e1.position)
             when '' then '사원'
             when e1.position  then e1.position
         END 직급
     , e1.PAY
FROM emp2 e1
WHERE 1=1
AND  e1.pay  IN (
						SELECT MAX(e.pay)
						FROM emp2 e
						GROUP BY e.POSITION
					)
;


-- student, exam_01, department 테이블에서 같은학과 같은 학년 학생의 평균 점수보다 점수가 높은 학생의
-- 학번, 이름, 학과, 학년, 점수 조회

              
              
SELECT s1.studno
     , s1.name
     , d.dname
     , s1.grade
     , e1.total
FROM student s1 
JOIN exam_01 e1 
USING(studno)
JOIN department d 
ON s1.deptno1 = d.deptno
WHERE 1=1
AND e1.total >= (
						SELECT AVG(total)
						FROM student s2 
						JOIN exam_01 e1 
						USING(studno)
						WHERE 1=1
						AND s2.deptno1 = s1.deptno1
						AND s2.grade = s1.grade
 		   	  	  )
ORDER BY s1.deptno1, s1.grade;
					 
					 
SELECT deptno1, grade, AVG(total)
FROM student s2
JOIN exam_01 e2 USING(studno)
GROUP BY deptno1, grade;

-- emp2 테이블에서 직원들 중 자신의 평균연봉과 같거나 많이 받는 사원들의 이름, 직급, 연봉, 조회
-- 단, 직급이 없으면 조회 X

SELECT AVG(e.PAY)
FROM emp2 e
WHERE 1=1;


SELECT e1.NAME
     , e1.position
     , e1.pay
FROM emp2 e1
WHERE 1=1
AND (e1.position IS NOT NULL AND TRIM(e1.position) <> '')
AND e1.pay >= (
						SELECT AVG(e2.pay)
						FROM emp2 e2 
						WHERE 1=1
						AND e2.position = e1.position -- 직원이 계속해서 달라지기에 
					);
					
					
-- student, professor 테이블에서 담당 학생이 있는 교수들의 교수번호 교수명 조회

SELECT DISTINCT s.profno
			     , p.name
FROM student s
JOIN professor p
-- USING(profno)
ON s.profno = p.profno
WHERE 1=1
AND s.profno IS NOT NULL;


SELECT p.profno
     , p.name
FROM professor p
WHERE 1=1
and EXISTS (
					SELECT *
					FROM student 
					WHERE profno = p.profno
				 );


SELECT profno, p.name				 
FROM (
		SELECT DISTINCT profno
		from student
		) e
JOIN professor p
USING(profno);

				 
				 
-- student, professor 테이블에서 담당 학생이 없는 교수들의 교수번호 교수명 조회

SELECT p.profno
     , p.name
FROM professor p
WHERE 1=1
AND NOT EXISTS (
						SELECT *
						FROM student 
						WHERE 1=1
						AND profno = p.profno
					)
;
					
-- emp, dept 테이블에서 직원이 한 명도 소속되지 않은 부서의 부서번호와 부서명 조회
INSERT INTO dept VALUES(50, 'MARKETING', 'HONGKONG');

SELECT d.DEPTNO
     , d.DNAME
FROM dept d
WHERE 1=1
AND not EXISTS (
						SELECT *
						FROM emp e
						WHERE 1=1
						AND e.DEPTNO = d.DEPTNO
					);
					
-- Limit
SELECT *
FROM emp 
ORDER BY sal DESC
LIMIT 0,5; -- 첫번째(0) 부터 5개

SELECT *
FROM emp 
ORDER BY sal DESC
LIMIT 5,5; -- 다섯 번째(5) 부터 5개