# ✅ SOLID

## 1) Single Responsiblity Principle (단일 책임 원칙)
* 응집도는 높고 결합도는 낮게 하기 위함
class Book {
    final static Boolean fiction = false;
    final static Boolean non_fiction = true;
    
    Boolean category;
    
    void read() {
        if(this.category == fiction){
            //픽션
        } else {
            //논픽션
        }
    }
}
// ->
abstract class Book {
    abstract void read();
}
class Fiction extends Book{
    void read(){
        //픽션
    }
}
class Non_Fiction extends Book{
    void read(){
        //논픽션
    }
}


## 2) Open-Closed Principle (개방-폐쇄 원칙)
* 기존 코드를 변경하지 않고(Close) 추가(Open)할 수 있도록 설계
class SoundPlayer{
    void play(){
        //wav재생
    }
}
public class Client{
    public static void main(String[] args){
        SoundPlayer sp = new SoundPlayer();
        sp.play();
    }
}
// ->
interface playType{
    public void play();
}

class Wav implements playType{
    public void play() {
        //wav재생
    }
}

class Mp3 implements playType{
    public void play() {
        //mp3재생
    }
}
## 3) Liskov Substitution Principle (리스코프 치환 원칙)
* 자식 클래스는 부모클래스에서 가능한 행위를 수행할 수 있어야 한다.
* 일반화 관계가 성립해야한다.
ex) 도형은 각을 갖고있다 - 사각형은 성립 - 원은 성립하지 않음.

## 4) Interface Segregation Principle (인터페이스 분리 원칙)
* 한 클래스는 자신이 사용하지 않는 인터페이스는 구현하지 말아야한다.
* 하나의 일반적인 인터페이스 보다는, 여러 개의 구체적인 인터페이스로 구성
ex) 스마트폰 기능 (전화 / 웹서핑 / 게임 / 각종 어플리케이션) (x)
-> 스마트폰 - 전화기능 / 웹서핑기능 / 게임기능 ... (o)

## 5) Dependency Inversion Principle (의존 역전 원칙)
* 변화하기 쉬운 것 - 구체적인 것 - 구체화 된 클래스
* 변화하기 어려운 것 - 추상적인 것 - 추상클래스, 인터페이스
* 의존 관계를 맺을 때, 구체적인 클래스 보다 인터페이스나 추상 클래스와 관계를 맺는 것
class SoundPlayer{
    private playType file;
    
    public void setFile(playType file){
        this.file = file;
    }
    
    public void play(){
        file.play();
    }
}

public class Client {
    public static void main(String[] args) {
        SoundPlayer sp =  new SoundPlayer();
        sp.setFile(new Wav());
        sp.setFile(new Mp3());
        sp.play();
    }
}