CREATE user kosta IDENTIFIED BY '1234';  -- 계정 생성 ( root 계정에서만 가능 )

ALTER user kosta IDENTIFIED BY '2345'; -- 계정의 비밀번호 변경 ( root 계정에서만 가능 )

DROP user kosta; -- 계정 삭제 ( root 계정에서만 가능 )


-- kosta 계정에 testdb SELECT, INSERT, UPDATE 권한 부여
GRANT SELECT, INSERT, UPDATE ON testdb.* TO 'kosta';

-- kosta 계정에 testdb의 모든 권한 부여 
GRANT ALL PRIVILEGES ON testdb.* TO 'kosta';

-- kosta 계정에 모든DB의  모든 권한 부여 
GRANT ALL PRIVILEGES ON *.* TO 'kosta';

SHOW GRANTS FOR 'kosta';
-- GRANT USAGE ON *.* TO `kosta` : USAGE 권한 지정자는 권한 없음을 나타냄. (권한은 없지만 계정은 있음을 의미)


-- kosta 계정에서 update 권한 삭제   ( root 계정에서 가능 )
REVOKE UPDATE ON testdb.* FROM 'kosta';

-- kosta 계정에서 testdb의 모든 권한 삭제  ( root 계정에서 가능 )
REVOKE ALL PRIVILEGES on testdb.* FROM 'kosta';

-- kosta 계정에서 모든 권한 삭제  ( root 계정에서 가능 )
REVOKE ALL PRIVILEGES ON *.* FROM 'kosta';


-- ##################################################
-- kosta 계정에서 확인
-- ##################################################

SELECT *
FROM account;

DELETE FROM account 
WHERE 1=1
AND id = '10001';  -- error : delete 권한을 root 계정에서 주지 않았기에 delete ALL_PLUGINS불가능 