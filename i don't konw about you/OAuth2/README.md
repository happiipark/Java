# OAuth2 (Openb Authorization 2.0)

### Third-Party : 프로그램에서 리소스 소유자를 대신하여 리소스 서버에 제공하는 자원에 대한 접근 권한을 위임하는 방식을 제공

예 : 간편한 로그인(네어버, 카카오, 구글, 페이스북 로그인)

-  Authentication : 인증, 접근 자격이 있는지 검증하는 단계
-  Authorization : 인가, 자원에 접근할 권한을 부여하는 것. 인가가 완료되면 리소스 접근 권한이 담긴 AccessToken이 클라이언트에게 부여된다
-  AccessToekn : 리로스 서버에게 리소스 소유자의 보호된 자원을 획득할 때 사용되는 만료기간이 있는 Token.
-  RefreshToken : AccessToken 만료시 이를 갱신하기 위한 용도로 사용하는 Token. RefreshToken의 만료기간이 AccessToken보다 길다.
