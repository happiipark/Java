-- constraint : 제약조건
-- not null, unique, primary key, foreign key, check
CREATE TABLE temp(
  id INT PRIMARY KEY, -- 동일한 데이터 허용 X, null값 허용 X  (unique & not null)
  NAME VARCHAR(20) NOT NULL --  null값 허용 X 
);

INSERT INTO temp VALUES(null,'jang');  -- primary key는 null도 허용 X
INSERT INTO temp VALUES(1,'jang'); 
INSERT INTO temp VALUES(1,'gong'); -- primary key error
INSERT INTO temp VALUES(2,NULL); -- name null error

CREATE TABLE temp2(
  email VARCHAR(50) unique
);

INSERT INTO temp2 VALUES(NULL); -- unique는 null은 허용한다
INSERT INTO temp2 VALUES('kosta@kosta.com'); -- null이 아닌 중복값은 허용 X


CREATE TABLE temp3(
  NAME VARCHAR(20) NOT NULL,
  age INT DEFAULT 1 CHECK(age>0) -- 값의 범위 제한
);

INSERT INTO temp3(name) VALUES('hong');  -- 일부 컬럼만 넣을경우 해당 컬럼 명 명시!
INSERT INTO temp3 VALUES ('kang', -1); -- age 범위 오류