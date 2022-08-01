# ✅ OOP(Object Oriented Programming)

## OOP 장단점
1. 장점
* 코드 재사용성 증가
* 생산성 향상
* 자연적인 모델링
* 유지보수 우수성
2. 단점
* 설계 단계에서 시간 소모 큼
* 실행 속도가 느림
# ✅ OOP(Object Oriented Programming)

## OOP 특징
### 특징
* 클래스를 이용해 연관 있는 함수와 변수를 하나의 객체로 묶어 생성하고, 사용한다.
### 1) 캡슐화 (Encapsulation)
* 데이터와 코드의 형태를 외부에서 알수 없게 정보은닉
* 데이터의 구조와 역할을 하나의 캡슐 형태로 구성
->변수를 private 로 선언하여 데이터를 보호하고, getter/setter등의 메서드를 통해서만 간접적으로 접근 할 있게 한다.
* 캡슐화 != 정보은닉

class Shop 
{
    private ArrayList items = new ArrayList();
    public ArrayList getItems(){
        return items;
    }
}
### 2) 추상화 (Abstraction)
* 객체의 공통적인 속성과 기능 추출하여 정의
* 데이터 추상화 : 복잡합 데이터 형태를 생성하기 위해 작은 데이터 여려개를 사용하는 방법
public class Person 
{
    private ID id;
    private Name name;
    private Address address;
}
* 제어 추상화 : 클래스의 메소드를 사용하는 사용자에게 해당 메소드의 작동 방식과 같은 로직을 실 사용에 영향을 주지 않는다.

### 3) 상속성 (Inheritance)
* 기존 상위 클래스의 기능을 하위 클래스에 부여하는 방법
* 상위 클래스를 부모 클래스, 하위 클래스를 자식 클래스라고 한다.
* extends 키워드를 사용

### 4) 다형성 (Polymorphism)
* 상속과 비슷한 개념으로 상속을 통해 그대로 쓰는 걸 벗어나, 기능을 확장하거나 변경하여 여러 형태로 사용될 수 있는 것
* 오버라이딩 : 하위 클래스가 상위 클래스에서 만들어진 메서드를 용도에 맞게 재구성 하는 것
* 오버로딩 : 하나의 클래스 안에서 같은 이름의 메서드를 사용하지만 각 메서드마다 다른 용도로 사용되며 그 결과물도 다르게 구현 가능
-> 메서드끼리 이름은 같지만 매개변수의 개수나 타입이 달라야한다.