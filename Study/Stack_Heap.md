#### ✅  코드(code) 영역
메모리의 코드(code) 영역은 실행할 프로그램의 코드가 저장되는 영역으로 텍스트(code) 영역이라고도 부릅니다. CPU는 코드 영역에 저장된 명령어를 하나씩 가져가서 처리하게 됩니다.

#### ✅  데이터(data) 영역
메모리의 데이터(data) 영역은 프로그램의 전역 변수와 정적(static) 변수가 저장되는 영역입니다. 데이터 영역은 프로그램의 시작과 함께 할당되며, 프로그램이 종료되면 소멸합니다.

#### ✅  스택(stack) 영역
메모리의 스택(stack) 영역은 함수의 호출과 관계되는 지역 변수와 매개변수가 저장되는 영역입니다. 스택 영역은 함수의 호출과 함께 할당되며, 함수의 호출이 완료되면 소멸합니다. 스택 영역은 푸시(push) 동작으로 데이터를 저장하고, 팝(pop) 동작으로 데이터를 인출합니다. 이러한 스택은 후입선출(LIFO, Last-In First-Out) 방식에 따라 동작하므로, 가장 늦게 저장된 데이터가 가장 먼저 인출됩니다. 스택 영역은 메모리의 높은 주소에서 낮은 주소의 방향으로 할당됩니다.

#### ✅  힙(heap) 영역
메모리의 힙(heap) 영역은 사용자가 직접 관리할 수 있는 '그리고 해야만 하는' 메모리 영역입니다.힙 영역은 사용자에 의해 메모리 공간이 동적으로 할당되고 해제됩니다.힙 영역은 메모리의 낮은 주소에서 높은 주소의 방향으로 할당됩니다.

![ex_screenshot](../img/stackheap.png)

### ✅ Stack(정적 메모리 할당)
* 스택은 같은 타입의 자료를 순차적으로 저장하는 직선형 자료 구조이다. 
* 우리가 스택에서 자료를 추출하고 삽입할 때 자료 순서의 끝에만 접근이 가능하다. 
* LIFO(Last In First Out) 구조 
* JVM(Java Virtual Machine)자바 가상 머신 : 
자바 프로그램이 실행될 때 사용되는 JVM 에서도 스택은 사용된다. 각각의 스레드는 1개의 스택을 가지고 모든 메소드들을 트랙킹한다. 새로운 메소드들이 호출 될 때 마다, 새로운 프레임이 스택에 삽입되고, 메소드가 끝날 때 마다 스택에서 제거된다
    * 기본 타입- 정수타입 : byte / char / short / int
    * 실수 타입 : float / double
    * 논리 타입 : boolean
    * 스택 영역은 변수값을 저장하게 되는데 기본타입인 정수형 변수와 실수형 변수와 논리형 변수를 실제값으로 저장한다.
* 크기가 정해져 있는 타입이다.
* 메모리 할당시 컴파일할때 이미 계산이 이루어진다.
* 메소드 작업이 종료되면 할당되었던 메모리 공간은 반환되어 비워진다.
* 장점 : 해제하지 않음으로 인한 메모리 누수와 같은 문제를 신경쓰지 않아도 된다. 정적 할당된 메모리는 실행 도중에 해제되지 않고, 프로그램이 종료할 때 알아서 운영 체제가 회수한다.
* 단점 : 메모리의 크기가 하드 코딩되어 있어서 나중에 조절 할 수 없다. 스택에 할당된 메모리이므로 동적 할당에 비해 할당 받을 수 있는 최대 메모리에 제약을 받는다.

### ✅ Heap(동적 메모리 할당)
* 동적 메모리 할당 또는 메모리 동적 할당은 컴퓨터 프로그래밍에서 실행 시간 동안 사용할 메모리 공간을 할당하는 것을 말한다. 
* 사용이 끝나면 운영체제가 쓸 수 있도록 반납하고 다음에 요구가 오면 재 할당을 받을 수 있다. 
* 프로그램이 실행하는 순간 프로그램이 사용할 메모리 크기를 고려하여 메모리의 할당이 이루어지는 정적 메모리 할당과 대조적이다.
* 동적으로 할당된 메모리 공간은 프로그래머가 명시적으로 해제하거나 쓰레기 수집이 일어나기 전 까지 그대로 유지된다. 
* 동적 할당은 프로세스의 힙영역에서 할당하므로 프로세스가 종료되면 운영 체제에 메모리 리소스가 반납되므로 해제된다. 
* 프로세스가 계속 실행될 때에는 동적할당 된 영역은 유지되므로 프로그램이 정해진 힙 영역의 크기를 넘는 메모리 할당을 요구하면 할당되지 않는다. 
* 사용이 완료된 영역은 반납하는 것이 유리
* 프로그래머가 함수를 사용해서 해제해야 한다. 
* 자바는 더 이상 사용되지 않으면 JVM에서 GC가 메모리를 수거해간다.
* 참조 타입
    * 배열 타입
    * 열거 타입
    *  클래스(Class)
    *  인터페이스
* 힙 영역은 객체와 배열이 생성되는 공간이고 참조타입(배열, 열거, 클래스, 인터페이스)들을 힙영역에 주소형식으로 저장한다. 
* 크기가 정해져 있지 않는 타입이다.
* 메모리 할당시 프로그램을 실행할때 메모리를 빌려 동적으로 할당한다.
* 참조하는 변수가 없다면 자동으로 힙 영역에서 제거 된다.
* 장점 : 상황에 따라 원하는 크기만큼의 메모리가 할당되므로 경제적이며, 이미 할당된 메모리라도 언제든지 크기를 조절할 수 있다.
* 단점 : 더 이상 사용하지 않을 때 명시적으로 메모리를 해제해 주어야 한다. 자바는 GC가 할당하므로서, 이 단점을 보완하였다.
---
```
public class Main {

    public static void main(String[] args) {
	int age = 32;
	String name = "kang";
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("js");
        skills.add("c++");

        test(skills);

    }

    public static void test(List<String> list) {
        String mySkill = list.get(0);
        list.add("python");
    }
}
```
Step 1 <br>
int age = 32;<br>
![ex_screenshot](../img/sh_step1.png)<br>
Step 2<br>
String name = "kang";<br>
name은 Stack, String Object 자체는 Heap<br>
![ex_screenshot](../img/sh_step2.png)<br>
Step 3<br>
skill 리스트가 ArrayList로 아직 값이 채워지지않고 생성<br>
![ex_screenshot](../img/sh_step3.png)<br>
Step 4<br>
리스트 Add<br>
![ex_screenshot](../img/sh_step4.png)<br>
Step 5<br>
메서드 실행 : <br>
list는 Heap의 List 가르킨다.<br>
mySkill은 Heap 영역의 String java를 참조<br>
list 3번 index에 "python" 연결<br>
![ex_screenshot](../img/sh_step5.png)<br>
Step 6<br>
메서드 종료 :<br>
Stack에서 Pop이 일어나서 Stack의 list랑 mySkill은 사라진다.<br>
![ex_screenshot](../img/sh_step6.png)<br>

---

```
public class Main {
    public static void main(String[] args) {
        String name = "kang";
        System.out.println("Before Name : " + name);
        changeName(name);
        System.out.println("After Name 1 : " + name);
        name += " babo";
        System.out.println("After Name 2 : " + name);
    }
    public static void changeName(String s) {
        s += " babo";
    }
}
/// Before Name : kang
/// After Name 1 : kang --> ???
/// After Name 2 : kang babo
```

Step 1 <br>
String name = "kang";<br>
![ex_screenshot](../img/sh__step1.png)<br>
Step 2 <br>
"kang" Object를 오브젝트 파라미터인 s에 복사하며 changeName 메서드 시작<br>

* String이 immutable한 클래스이기 때문, 불변의 객체<br>
* String 이외에도 immutable한 클래스는 Boolean, Integer, Float, Long, Double 등이 있다. <br>
* mutable한 객체는 List, ArrayList, HashMap 등 컬렉션들이 대표적인 mutable한 객체이다.<br>
* 문자열을 mutable하게 쓰려면 StringBuilder를 사용해주면 된다.<br>
* StringBuilder의 append메서드를 사용해서 값을 붙여주면 같은 데이터를 그대로 참조한다.<br>
![ex_screenshot](../img/sh__step2.png)<br>

Step 3 <br>

```
public static void changeName(String s) {
	s += " babo";
}
// s에다 " babo"라는 문자열을 더하는 것처럼 보이지만, 실제로는 새로운 String을 생성
// 프린트 찍은 내용은 name 이기때문에 "kang"이라는 결과가 나온 것
```
![ex_screenshot](../img/sh__step3.png)<br>
Step 4 <br>
```
name += " babo";
```
![ex_screenshot](../img/sh__step4.png)<br>
Step 5 <br>
* 빨간 테투리 데이터들은 쓰레기값<br>
* GC가 처리해준다.<br>
![ex_screenshot](../img/sh__step5.png)<br>