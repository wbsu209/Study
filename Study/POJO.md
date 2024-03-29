# ✅ POJO(Plane Old Java Object)

## POJO ?

* POJO란, 객체 지향적인 원리에 충실하면서 환경과 기술에 종속되지 않고 필요에 따라 재활용될 수 있는 방식으로 설계된 오브젝트를 말한다. 그러한 POJO에 애플리케이션의 핵심로직과 기능을 담아 설계하고 개발하는 방법을 POJO 프로그래밍이라고 할 수 있다.

## POJO 사용 이유

* 스프링 프레임워크 이전에는 원하는 엔터프라이즈 기술이 있다면 그 기술을 직접적으로 사용하는 객체를 설계하는 방식이 만연하고 있었다. 특정 기술과 환경에 종속되어 의존하게 된 자바 코드는 가독성이 떨어져 유지보수에 어려움이 생겼다. 또한, 특정 기술의 클래스를 상속받거나, 직접 의존하게 되어 확장성이 매우 떨어지는 단점이 있었다. 즉 객체 지향 언어의 장점을 상실하게 됐다.
그래서 POJO라는 개념이 등장했다. 본래 자바의 장점을 살리는 '오래된' 방식의 '순수한' 자바객체를 위해서.

## POJO 의 조건

1. 특정 규약에 종속되지 않는다.

    * 자바언어와 곡 필요한 API외에는 종속되지 말아야한다. EJB2와 같이 특정 규약을 따라 만들게 하는 경우는 대부분 규약에서 제시하는 특정 클래스를 상속하도록 요구한다. 그럴 경우 자바의 단일 상속 제한 때문에 더이상 해당 클래스에 객체지향적인 설계 기법을 적용하기가 어려워지는 문제가 생긴다.
 
2. 특정 환경에 종속되지 않는다.

    * 특정 기업의 프레임워크나 서버에서만 동작가능한 코드라면 POJO라 할 수 없다. POJO는 환경에 독립적이여야한다. 특히 비지니스 로직을 담고 있는 POJO 클래스는 웹이라는 환경 정보나 웹 기술을 담고 있는 클래스나 인터페이스를 사용해서는 안된다. 설령 나중에는 웹 컨트롤러와 연결되서 사용될 것이 분명하더라도 직접적으로 웹이라는 환경으로 제한해버리는 오브젝트나 API에 의존해서는 안된다. 그렇게 되면 웹 외의 클라이언트가 사용하지 못하기 때문이다.

    * 기술적인 내용을 담은 웹 정보가 비즈니스 로직과 얽혀있으니 이해하기도 어렵다. 때문에 비지니스 로직을 담은 코드에 HTTPServletRequest, HttpSession, 캐시에 관련된 API가 등장한다면 진정한 POJO라고 할 수 없다.
  
3. 객체 지향적 원리에 충실해야한다.

    * POJO는 객체지향적인 자바언어의 기본에 충실하게 만들어져야한다. 자바 언어 문법을 사용했다고해서 자동적으로 객체지향 프로그래밍과 객체지향 설계가 적용됬다고 볼 수는 없다. 책임과 역할이 각기 다른 코드를 한 클래스에 몰아넣어 덩치큰 만능 클래스를 만들고 상속과 다형성의 적용이 아닌 if/switch문으로 가득 설계된 오브젝트라면 POJO라고 부르기 힘들다.

## POJO 기반 프레임워크
*  POJO 기반 프레임워크란 POJO 프로그래밍이 가능하도록 기술적인 기반을 제공하는 프레임워크이다. 스프링 프레임워크와 하이버네이트를 대표적인 POJO 프레임워크로 꼽을 수 있다.

 * 스프링을 이용하면 POJO 프로그래밍의 장점을 그대로 살려서 엔터프라이즈 애플리케이션의 핵심로직을 객체지향적인 POJO를 기반으로 깔끔하게 구현하고, 동시에 엔터프라이즈 환경의 각종 서비스와 기술적인 필요를 POJO방식으로 만들어진 코드에 적용할 수 있다.