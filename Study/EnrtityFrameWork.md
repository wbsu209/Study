# ✅ EntityFrameWork
### EntityFrameWork ?
* 개발환경 속에서 데이터베이스를 쉽게 사용할 수 있게 만들어주는 도구
* Object Oriented Programming언어에서 데이터베이스의 한 테이블을 Class로 가져와서 사용 - ORM
* ORM이란 데이터베이스 테이블과 객체를 연결해주는 기술입니다. 
* 쿼리를 직접 사용해서 데이터베이스를 사용할 수는 있다.
* 나중에 코드 수정이 다소 번거로운 단점을 갖는다.
* 성능 이슈

### Microsoft가 직접 구현한 ORM (Object-Relational Mapping)
* Entity Framework (EF)
* LINQ TO SQL
* 이외에 NHibernate, Dapper 같은 .NET용 ORM 오픈소스들이 있다.

### EntityFrameWork Model
1. Code First 
    * 먼저 C# 클래스로 테이블의 구조를 정의하는데, 클래스의 속성을 테이블의 컬럼에 매핑
    * DB를 미리 설계하지 않고 C# 클래스들로 Domain Object들을 정의하고 프로그램 실행시 DB가 없으면 자동으로 DB를 생성하는 방식
2. Model First
    * Visual Model Designer (EDMX)를 통해 객체/테이블 매핑을 디자인하는 방식
    * 기존 DB가 없을 때 직접 Visual Model Designer에 Entity 들을 하나씩 추가해 가면서 데이타 모델을 구성
3. Database First
    * Visual Model Designer (EDMX)를 통해 객체/테이블 매핑을 디자인하는 방식
    * 기존 DB로부터 테이블 구조들을 읽어 Visual Model을 구성
