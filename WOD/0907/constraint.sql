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

CREATE TABLE USER(
  id VARCHAR(20) PRIMARY KEY,
  NAME VARCHAR(20) NOT NULL
);

DROP TABLE article;
CREATE TABLE article(testdb
  num INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(50),
  cintent VARCHAR(1000),
  writer VARCHAR(20) REFERENCES USER(id)
  
);


INSERT INTO article (title, content) VALUES ('제목', '내용');
INSERT INTO article (title, content,writer) VALUES ('제목', '내용', 'hong'); -- error

INSERT INTO user values('hong','홍길동');
INSERT INTO article (title, content,writer) VALUES ('제목', '내용', 'hong');  -- success

DELETE FROM user WHERE 1=1 and id = 'hong'; -- error : article 테이블에서 참조하고 있어서 삭제할 수 없다.
UPDATE user set id = 'kong' WHERE 1=1 AND id = 'hong';  -- error : article 테이블에서 id를 참조하고 id 변경 불가
UPDATE user set name = '공길동' WHERE 1=1 AND id = 'hong'; -- success : 참조되는 컬럼이 아닌 컬럼은 변경 가능

INSERT INTO user VALUES('song','송길동');
DELETE FROM user WHERE 1=1 AND id = 'song'; -- success : 참조하고 있지 않은 데이터는 삭제 가능

ALTER TABLE article ADD CONSTRAINT ARTICLE_USER_FK FOREIGN KEY(writer) REFERENCES user(id);
INSERT into article (title,content, writer) VALUES('송제묵', '송내용', 'song');
ALTER TABLE article DROP CONSTRAINT article_USER_FK;

DELETE FROM article WHERE 1=1 AND writer = 'song';
ALTER TABLE article ADD CONSTRAINT ARTICLE_USER_FK FOREIGN KEY(writer) REFERENCE KEY user(ID) ON DELETE CASCADE;
DELETE FROM user WHERE id = 'hong';