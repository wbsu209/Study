# ✅ Spring

## 1) DI(Dependency Injection)
1. 생성자 주입
```
public class Book {
    private final Fiction fiction;
    
    @Autowired
    public Book(Fiction fiction) {
    	this.fiction = fiction;
    }
}
```
Book 객체를 생성할 때 fiction객체를 매개변수로 전달하여, 의존성 주입
- 단위 테스트 용이
- 주입 받는 객체 final 선언 가능
- Spring Framework에서 권장

2. Setter 주입
```
public class Book {
    private Fiction fiction;
    
    @Autowired
    publid void setBar(Fiction fiction) {
    	this.fiction = fiction;
    }
}
```
주입 받은 객체가 변할 수 있을 때 사용, 하지만 변경되는 드물다.

3. 필드 주입
```
public class Book {
    @Autowired
    pirvate Fiction fiction;
}
//필드 주입은 반드시 DI 프레임워크가 존재해야 하므로 반드시 사용을 지양해야 한다.
//코드는 간결해지지만, Spring이 외부에서 fiction을 찾아 Book에 넣어줘야한다.
//유닛 테스트가 어렵고, 서로 참조 하다가 순환 참조 발생 가능성이 있다.
```
* 필드 주입을 이용하면 코드가 간결해져서 과거에 이용되었던 주입 방법이다. 
* 필드 주입은 외부에서 접근이 불가능하다는 단점이 존재한다.
*  테스트 코드의 중요성이 부각됨에 따라 필드의 객체를 수정할 수 없는 필드 주입은 거의 사용되지 않게 되었다.


## 2)Spring Bean
Spring IoC 컨테이너가 관리하는 자바 객체를 Spring Bean이라 칭한다.


## 3) Spring IoC(Inversion of Control)
Java Programming : Class -> new 객체
Spring Framework : new(x) -> Spring 이 관리하는 객체(Bean)를 사용
Spring Container is called by (IoC/ Bean/ Di)Container

