# ✅ Spring

## Bean ?
* Bean은 Spring Bean Container에 존재하는 객체를 말한다. Bean Container는 의존성 주입을 통해 Bean 객체를 사용할 수 있도록 해준다. Bean은 보통 싱글턴으로 존재한다.

## Spring Bean 생성
### 1) \@Bean
: 외부 라이브러리에서 정의한 클래스를 Spring Bean으로 등록하고자 하는 경우
 \@Component
: 개발자가 직접 작성한 클래스를 Spring Bean으로 등록할 경우
* \@Controller
: 기본적으로 @Component을 상속받고 presentation layer의 component라는 것 표기
* \@Service
: 기본적으로 @Component을 상속받고 business layer의 component라는 것 표기
* \@Repository
: 기본적으로 @Component을 상속받고 persistence layer의 component라는 것 표기

### 2) 직접 생성
* 자바 코드로 빈을 등록할 수 있다.
* 클래스를 생성하고 \@Configuration
* 메소드를 생성하고 \@Bean
* 메소드에 리턴되는 객체가 Bean에 등록된다.

### 3) XML 
* Java 코드를 이용한 Context 설정이 나오기 전 사용하던 방법이다. applicationContext.xml이라는 파일을 src/main/resources 폴더에 추가시킨 후 bean을 등록한다. 아래 코드처럼 작성할 수 있다.
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<bean id="userBean" class="com.example.diexam01.UserBean"></bean>
	<bean id="e" class="com.example.diexam01.Engine"></bean>
	<bean id="c" class="com.example.diexam01.Car">
		<property name="engine" ref="e"></property>
	</bean>
</beans>
```
# ✅ Spring

## Layer
1. Presentaion Layer는 주로 클라이언트에서 보낸 요청 간의 json 형태로의 변환 등의 작업을 수행

2. Business Layer는 Presentation Layer에서 보내온 데이터를 가지고 비즈니스 로직에 따른 계산, 처리를 수행

3. Persistence Layer는 주로 데이터베이스와의 연결을 유지하고 데이터를 송, 수신