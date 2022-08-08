# ✅ DBCP(DataBase Connection Pool)

## DBCP?
* 커넥션 풀(connection pool)은 소프트웨어 공학에서 데이터베이스로의 추가 요청이 필요할 때 연결을 재사용할 수 있도록 관리되는 데이터베이스 연결의 캐시이다. 
* 연결 풀을 사용하면 데이터베이스의 명령 실행의 성능을 강화할 수 있다. 
* 각 사용자마다 데이터베이스 연결을 열고 유지 보수하는 것은 비용이 많이 들고 자원을 낭비한다. 연결 풀의 경우 연결이 수립된 이후에 풀에 위치해 있으므로 다시 사용하면 새로운 연결을 수립할 필요가 없어진다. 
* 모든 연결이 사용 중이면 새로운 연결을 만들고 풀에 추가된다. 연결 풀은 사용자가 데이터베이스에 연결을 수립하는 데까지 대기해야 하는 시간을 줄이기도 한다.

( DB Connection에 국한된 룰이 아니고 애플리케이션 단에서 자주 사용하고 접근하는 영역에 대해 Thread Pool을 구축하고 사용하도록 하는 것도 똑같은 이치이다. )

## DBCP 장점
* Database 접속 설정 객체를 미리 만들어 연결을 하여 메모리 상에 등록해 놓아 클라이언 트가 빠르게 Database 접속을 할 수 있다.

* Database Connection 수를 제한할 수 있어 과다한 접속으로 인한 서버의 자원 고갈을 막 을 수 있다.

* Database 접속 모듈을 공통화해 Database 서버의 환경이 바뀔 경우 유지 보수를 쉽게 할 수 있다.

* 연결이 끝난 Connection 을 재사용함으로써 새로 객체를 만드는 비용을 줄일 수 있다.

## DBCP 라이브러리 종류

* Apache Commons DBCP
    * 아파치에서 제공해 주는대표적인 Connection Pool 라이브러리. 

* Tomcat DBCP
    * Tomcat에서 내장되어 사용하고 있으며 Apache Commons DBCP 라이브러리를 바탕으로 만들어졌다.

* HikariCP
    * HikariCP는 스프링 부트 2.0부터 설정된 default JDBC Connection Pool