# ✅ URI (Uniform Resource Identifier)

## URI : 자원 식별자
* URL과 URN의 상위 개념
* 논리적 물리적 리소스를 식별하는 고유한 문자열 시퀀스
* 자연적인 모델링
* 유지보수 우수성

# ✅ URL (Uniform Resource Locator)

## URL : 자원 위치
* 흔히 웹주소라고 불림
* 컴퓨터 네트워크 상에서 리소스의 위치를 알려주기 위한 규약

# ✅ URN (Uniform Resource Name)

## URN : 자원 이름
* 리소스의 위치 정보가 아닌 실제 리소스의 이름으로 사용
* 리소스의 이름 부여가 목적
* ex) urn:something:names:something

# ✅ URI vs URL
## 차이점
```
ex1) https://www.naver.com/index.html
ex2) https://www.naver.com/index
```
* 두 주소 모두 index.html을 가르키고 있다.
* 첫번째 주소는 웹서버의 실제 파일 위치를 나타내는 주소로 URI, URL 둘다 해당된다.
* 두번째 주소는 index라는 파일이 웹서버에 존재하지 않기 때문에 URL이 아니다. 하지만 서버 내부에서 이를 처리하여 index.html을 가르키기 때문에 URI에는 해당된다.

# ✅ URI의 구조
```
scheme:[//[user[:password]@]host[:port]][/path][?query][#fragment]
```
* scheme : 사용할 프로토콜을 뜻하며 웹에서는 http 또는 https를 사용
* user와 password : (서버에 있는) 데이터에 접근하기 위한 사용자의 이름과 비밀번호
* host와 port : 접근할 대상(서버)의 호스트명과 포트번호
* path : 접근할 대상(서버)의 경로에 대한 상세 정보
* query : 접근할 대상에 전달하는 추가적인 정보 (파라미터)
* fragment : 메인 리소스 내에 존재하는 서브 리소스에 접근할 때 이를 식별하기 위한 정보