# ✅ Persistence
* 데이터들이 프로그램이 종료되어도 사라지지 않고 어떤 곳에 저장되는 개념을 영속성(Persistence) 이라고 한다.

* 자바에서는 데이터의 영속성을 위한 JDBC를 지원해주는데, 이는 매핑 작업을 개발자가 일일히 수행해야 하는 번거로움이 있다.

* SQL Mapper와 ORM은 개발자가 직접 JDBC Programming을 하지 않도록 기능을 제공해주는 Persistence Framework 종류이다.

* 기존 JDBC 만의 사용으로 쿼리문을 만들어 요청하는 과정은 쿼리문이 조금만 길어져도 관리가 힘들거 번거롭다. 따라서 JPA와 MyBatis 라이브러리를 사용하여 문제를 해결할 수 있다.

* 모든 Persistence Framework는 내부적으로 JDBC API를 이용한다.

# ✅ ORM (Object Relational Mapping)
## ORM ?
* 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑(연결)해주는 것을 말한다.
    * ORM은 데이터베이스 객체를 자바 객체로 매핑함으로써 객체 간의 관계를 바탕으로 SQL을 자동으로 생성해주지만 SQL Mapper는 SQL을 명시해줘야 한다.
    * ORM은 관계형 데이터베이스의 ‘관계’를 Object에 반영하자는 것이 목적이라면, SQL Mapper는 단순히 필드를 매핑시키는 것이 목적이라는 점에서 지향점의 차이가 있다.
    * ex) JPA, Hibernate
## ORM - JPA
* JPA : ORM
    * 자바 ORM의 기술 표준
    * 대표적인 오픈소스로 Hibernate
    * CRUD 메소드 기본 제공
    * 쿼리를 만들지 않아도 됨
    * 1차 캐싱, 쓰기지연, 변경감지, 지연로딩 제공
    * MyBatis는 쿼리가 수정되어 데이터 정보가 바뀌면 그에 사용 되고 있던 DTO와 함께 수정해주어야 하는 반면에, JPA 는 객체만 바꾸면 된다.
    * 객체 중심으로 개발 가능
    * 복잡한 쿼리는 해결이 어려움


# ✅ SQL Mapper

## SQL Mapper ?
* Object와 SQL의 필드를 매핑하여 데이터를 객체화 하는 기술
    * SQL - 매핑 - Object 필드
    * SQL Mapper는 SQL 문장으로 직접 데이터베이스 데이터를 다룬다.
    * SQL Mapper는 SQL을 명시해줘야한다.
    * ex) JdbcTemplate, MyBatis
## MyBatis - SQL Mapper
* MyBatis : Object Mapping 기술
    * 자바에서 SQL Mapper를 지원해주는 프레임워크
    * SQL문을 이용해서 RDB에 접근, 데이터를 객체화 시켜줌
    * SQL을 직접 작성하여 쿼리 수행 결과를 객체와 매핑
    * 쿼리문을 xml로 분리 가능
    * 복잡한 쿼리문 작성 가능
    * 데이터 캐싱 기능으로 성능 향상
    * 객체와 쿼리문 모두 관리해야함, CRUD 메소드를 직접 다 구현해야함.

