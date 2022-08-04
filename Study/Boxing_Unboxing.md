# ✅ Wrapper Class

## Wrapper(싸개) Class ?
* 자바 API 클래스중 하나이다.
* 기본 타입에 해당하는 데이터를 객체로 표현하기 위해 포장해 주는 클래스가 바로 Wrapper class(래퍼 클래스)이다.
## Wrapper Class 사용 이유 
*  기본 자료형의 값을 굳이 Wrapper Class로 포장하는 이유는 제네릭, 자료구조, 매개변수 등 기본 자료형이 아닌 레퍼런스 타입을 필요로 하는 경우가 많다.
*  레퍼런스 타입을 사용하는 메서드를 갖고 있고, 이 메서드를 다양하게 활용하기 위함이다.
*  인스턴스를 생성(heap 메모리에 저장) 하여 상속 및 재사용이 가능하다. 또한 문자열(String)과 기본 자료형 간 형 변환하여 사용이 가능하다.
##  Wrapper Class 종류
* 기본 자료형의 모든 wrapper 클래스를 자바에서 기본적으로 제공하여 주며, java.lang 패키지에 소속되어 있다. 대부분 기본 데이터 타입의 앞 글자를 대문자로 바꿔주면 된다.

---

# ✅ Boxing Unboxing

## Boxing 
* 기본 타입의 데이터를  Wrapper class의 인스턴스로 변환하는 과정
    * Integer num = new Integer(1);
## Unboxing 
* UnBoxing : wrapper class의 인스턴스에 저장된 값을 기본 타입의 데이터로 꺼내는 과정
    * int n = num.intValue();
# ✅ AutoBoxing AutoUnboxing
* JDK 1.5부터 Boxing,Unboxing이 필요한 상황에서 자바 컴파일러가 이를 자동으로 처리해준다.
* AutoBoxing : 자동화된 Boxing
    * Integer num1 = 1;
* AutoUnBoxing : 자동회된 UnBoxing
    * int n1 = num1;
---

## 예시
Integer num = new Integer(17);  // Boxing
int n = num.intValue(); // UnBoxing

Character ch = 'X'; // AutoBoxing : Character ch = new Character('X'); 
char c = ch; // AutoUnBoxing : char c = ch.charValue();  