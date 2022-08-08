# ✅ Bean Life Cycle

## Life Cycle ?

* 프로그램 실행 단계에 객체를 등록, 프로그램 종료 단계에 객체를 해제 하기 위해서는 객체의 초기화와 종료 단계가 필요하다.

## Life Cycle Step

스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸 전 콜백 -> 스프링 종료

* 초기화 콜백: 빈이 생성되고, 빈의 의존관계 주입이 완료된 후 호출
* 소멸전 콜백: 빈이 소멸되기 직전에 호출

## LifeCycle Callback

### 1) 인터페이스(InitializingBean, DisposableBean)
```
@Component
public class TestComponent implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
    // 의존관계 주입이 끝나면 호출해주는 콜백
        System.out.println("초기화 콜백 테스트");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("소멸전 콜백 테스트");
    }
}
```

* InitializingBean은 afterPropertiesSet 메소드로 초기화를 지원합니다.(의존관계 주입이 끝난 후에 초기화 진행)
* DisposableBean는 destroy 메소드로 소멸을 지원합니다. (Bean 종료 전에 마무리 작업 )
* InitializingBean, DisposableBean 인터페이스는 스프링 전용 인터페이스 입니다. 해당 코드가 스프링 전용 인터페이스에 의존합니다.
* 초기화, 소멸 메서드의 이름을 변경할 수 없습니다.
* 내가 코드를 고칠 수 없는 외부 라이브러리에 적용할 수 없습니다.

### 2) 설정 정보에 초기화 메소드, 종료 메소드 지정
```
public class ExampleBean {
    public void initialize() throws Exception {
        // 초기화 
    }

    public void close() throws Exception {
        // 메모리 반납, 연결 종료와 같은 과정 
    }
}

@Configuration
static class LifeCycleConfig {
    @Bean(initMethod = "initialize", destroyMethod = "close")
    public ExampleBean exampleBean() {
        // 생략
    }
}
```
* 메서드 이름을 자유롭게 부여 가능
* 스프링 코드에 의존하지 않음
* 설정 정보를 사용하기 때문에 코드를 커스터마이징 할 수 없는 외부 라이브러리에서도 적용 가능
* Bean 지정 시 initMethod와 destroyMethod를 직접 지정해야 하는 번거로움
```
@Bean의 destroyMethod 속성의 특징

* 라이브러리는 대부분 종료 메서드명이 close 혹은 shutdown 
* @Bean의 destroyMethod는 기본값이 inferred (추론)으로 등록 즉, close, shutdown라는 이름의 메서드가 종료 메서드라고 추론하고 자동으로 호출해줘서, 종료 메서드를 따로 부여하지 않더라도 작동
* inferred 기능을 사용하기 싫다면 명시적으로 destoroyMethod="" 와 같이 공백을 지정해줘야 함
```
### 3) @PostConstruct, @PreDestroy 애노테이션 
```
@Component
public class TestComponent {

    @PostConstruct
    public void initTest() {
        System.out.println("초기화");
    }

    @PreDestroy
    public void destoryTest() {
        System.out.println("종료");
    }
}
```
* 최신 스프링에서 가장 권장하는 방법.
* 어노테이션 하나만 붙이면 되므로 편리하다.
* 패키지를 보면 javax.annotation.PostConstruct 입니다. 스프링에 종속적인 기술이 아니라 JSR-250 라는 자바 표준. 따라서 스프링이 아닌 다른 컨테이너에서도 동작한다.
* 유일한 단점은 외부 라이브러리에는 적용하지 못한다. 외부 라이브러리를 초기화, 종료 해야 하면 @Bean의 기능을 사용하면 된다.