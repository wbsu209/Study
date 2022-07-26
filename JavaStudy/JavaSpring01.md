# ✅ Spring

## 1) DI(Dependency Injection)
1. 생성자 주입
public class Book {
    private final Fiction fiction;
    
    @Autowired
    public Book(Fiction fiction) {
    	this.fiction = fiction;
    }
}
Book 객체를 생성할 때 fiction객체를 매개변수로 전달하여, 의존성 주입
- 단위 테스트 용이
- 주입 받는 객체 final 선언 가능
- Spring Framework에서 권장

2. Setter 주입
public class Book {
    private Fiction fiction;
    
    @Autowired
    publid void setBar(Fiction fiction) {
    	this.fiction = fiction;
    }
}
주입 받은 객체가 변할 수 있을 때 사용, 하지만 변경되는 드물다.
public class Book {
    @Autowired
    pirvate Fiction fiction;
}
코드는 간결해지지만, Spring이 외부에서 fiction을 찾아 Book에 넣어줘야한다.
유닛 테스트가 어렵고, 서로 참조 하다가 순환 참조 발생 가능성이 있다.

# ✅ Spring

## 2)Spring Bean
Spring IoC 컨테이너가 관리하는 자바 객체를 Spring Bean이라 칭한다.

# ✅ Spring

## 3) Spring IoC(Inversion of Control)
Java Programming : Class -> new 객체
Spring Framework : new(x) -> Spring 이 관리하는 객체(Bean)를 사용
Spring Container is called by (IoC/ Bean/ Di)Container

# ✅ Spring

## 4) Spring Bean 생성
\@Bean
: 외부 라이브러리에서 정의한 클래스를 Spring Bean으로 등록하고자 하는 경우
 \@Component
: 개발자가 직접 작성한 클래스를 Spring Bean으로 등록할 경우
* \@Controller
: 기본적으로 @Component을 상속받고 presentation layer의 component라는 것 표기
* \@Service
: 기본적으로 @Component을 상속받고 business layer의 component라는 것 표기
* \@Repository
: 기본적으로 @Component을 상속받고 persistence layer의 component라는 것 표기

# ✅ Spring

## Layer
1. Presentaion Layer는 주로 클라이언트에서 보낸 요청 간의 json 형태로의 변환 등의 작업을 수행

2. Business Layer는 Presentation Layer에서 보내온 데이터를 가지고 비즈니스 로직에 따른 계산, 처리를 수행

3. Persistence Layer는 주로 데이터베이스와의 연결을 유지하고 데이터를 송, 수신