DROP TABLE article;
DROP TABLE user;


CREATE TABLE user(
  id VARCHAR(100),
  NAME VARCHAR(100)
);

CREATE TABLE article(
  num INT AUTO_INCREMENT PRIMARY KEY, 
  title VARCHAR(500),
  content VARCHAR(1000),
  writer VARCHAR(100)
);


-- 외부에서 제약조건 생성
ALTER TABLE user ADD CONSTRAINT USER_PK PRIMARY KEY(id);

ALTER TABLE article ADD CONSTRAINT ARTICLE_USER_FK FOREIGN KEY(writer) REFERENCES user(id);

INSERT article VALUES(NULL,'제목','내용','hong'); -- error : 'hong' 이 user 테이블에 없어서 (외래키 조건 위배)
INSERT article VALUES(NULL,'제목','내용',NULL); -- 단, null 값은 가능

INSERT user VALUES('hong','홍길동');
INSERT article VALUES(NULL,'제목','내용','hong'); -- success

DELETE FROM user WHERE id = 'hong'; -- error : article 테이블에서 writer의 값이 'hong' 인 데이터가 참조하고 있어서 삭제 불가

UPDATE user SET id = 'kong' WHERE 1=1 AND id = 'hong'; -- error : article 테이블에서 writer의 값이 'hong' 인 데이터가 참조하고 있어서 변경 불가
UPDATE user SET NAME = '홍홍' WHERE 1=1 AND id = 'hong';  -- success

-- 제약조건 삭제
ALTER TABLE article DROP CONSTRAINT ARTICLE_USER_FK; -- 외래키 제약조건 삭제
INSERT INTO article VALUES(NULL,'송제목','송내용','song'); -- success : 외래키 제약조건 삭제해서 

ALTER TABLE article ADD CONSTRAINT ARTICLE_USER_FK FOREIGN KEY(writer) REFERENCES user(id) ON DELETE CASCADE; -- error : 외래키 부여 제약조건 위배되는 데이터가 존재하여 외래키 부여 불가 (writer 이 song인 데이터가 제약조건 위배)
UPDATE article SET writer = 'hong' WHERE 1=1 AND writer <> 'hong';

ALTER TABLE article ADD CONSTRAINT ARTICLE_USER_FK FOREIGN KEY(writer) REFERENCES user(id) ON DELETE CASCADE;  -- success
DELETE FROM user WHERE id = 'hong';  -- success : ON DELETE CASCADE에 의해 참조하는 데이터도 같이 삭제

-- #############################################################################
-- 제약조건 약식
-- #############################################################################
CREATE TABLE user(
  id VARCHAR(100) PRIMARY KEY,
  NAME VARCHAR(100) NOT null
);

CREATE TABLE user(
  id VARCHAR(100),
  NAME VARCHAR(100) NOT null,
  PRIMARY KEY(id)
);


CREATE TABLE article(
  num INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(500),
  cotnet VARCHAR(1000),
  writer VARCHAR(100) not null REFERENCES user(id)
);

CREATE TABLE article(
  num INT AUTO_INCREMENT,
  title VARCHAR(500),
  cotnet VARCHAR(1000),
  writer VARCHAR(100),
  PRIMARY KEY(num),
  foreign key(writer) REFERENCES user(id)
);



CREATE TABLE tcons(
  NO INT, -- primary key
  NAME VARCHAR(20), -- not null
  jumin VARCHAR(13),-- not null, unique
  AREA INT, -- check 1,2,3,4
  deptno VARCHAR(6) -- foreign key
);

ALTER TABLE tcons ADD CONSTRAINT tcons_no_pk PRIMARY KEY(NO);
ALTER TABLE tcons MODIFY COLUMN NAME VARCHAR(20) NOT NULL;
ALTER TABLE tcons MODIFY COLUMN jumin VARCHAR(13) NOT NULL;
ALTER TABLE tcons ADD CONSTRAINT tcons_jumin_uk UNIQUE(jumin);
ALTER TABLE tcons ADD CONSTRAINT tcons_area_ck CHECK(AREA IN(1,2,3,4));
ALTER TABLE tcons ADD CONSTRAINT tcons_deptno_fk FOREIGN KEY(deptno) REFERENCES dept2(dcode);
