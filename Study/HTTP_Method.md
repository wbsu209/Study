# ✅ HTTP

## HTTP 메소드 종류

### 주요 메소드 5가지

* GET : 리소스 조회
* POST : 요청 데이터 처리, 주로 데이터 등록에 사용
* PUT : 리소스를 대체, 해당 리소스가 없으면 생성
* PATCH : 리소스를 일부만 변경
* DELETE : 리소스 삭제
### 기타 메소드 4가지

* HEAD: GET과 동일하지만 메시지 부분을 제외하고, 상태 줄과 헤더만 반환
* OPTIONS: 대상 리소스에 대한 통신 가능 옵션을 설명(주로 CORS에서 사용)
* CONNECT: 대상 자원으로 식별되는 서버에 대한 터널을 설정
* TRACE: 대상 리소스에 대한 경로를 따라 메시지 루프백 테스트를 수행

```
GET은 보통 리소스를 조회할 때 사용하며, 서버에 전달하고 싶은 데이터는 query를 통해서 전달한다. 메시지 바디를 사용해서 데이터를 전달할 수는 있지만, 지원하지 않는 곳이 많아서 권장하지 않는다.

POST는 데이터 요청을 처리하고, 메시지 바디를 통해 서버로 데이터를 전달한다. 주로 신규 리소스를 등록하거나 프로세스 처리에 사용된다.

PUT은 리소스가 있으면 대체하고 리소스가 없으면 생성한다. 쉽게 말해 데이터를 덮어쓴다.

PATCH는 PUT과 마찬가지로 리소스를 수정할 때 사용하지만, PATCH는 리소스를 일부분만 변경할 수 있다.

DELETE는 리소스를 제거할때 사용한다.
```
### HTTP 메소드의 속성
* HTTP 메소드의 속성에는 안전(Safe Methods), 멱등(Idempotent Methods), 캐시가능(Cacheable Methods)가 있다.
    
    * 안전(Safe Methods) : 계속해서 메소드를 호출해도 리소스를 변경하지 않는다는 뜻이다. 주요 메소드중에는 GET 메소드가 안전하다고 볼 수 있다.

    * 멱등(Idempotent Methods) : 메소드를 계속 호출해도 결과가 똑같다는 뜻이다. Get, PUT, DELETE는 멱등하다고 볼 수 있지만 POST나 PATCH는 멱등하다고 볼 수 없다.

    * 캐시가능(Cacheable Methods) : 캐싱을 해서 데이터를 효율적으로 가져올 수 있다는 뜻이다. GET, HEAD, POST, PATCH가 캐시가 가능하지만 실제로는 GET과 HEAD만 주로 캐싱이 쓰인다고 한다.
    <br>

 ![ex_screenshot](../img/http-method.png)<br>

--- 

### HTTP Request Message = Request Header + 빈 줄 + Request Body
* Header
    * 첫 번째 줄 (start-line)
        * 요청 메서드 + 요청 URI + HTTP 프로토콜 버전
        * GET /background.png HTTP/1.0
        * POST / HTTP 1.1
    * 두 번째 줄 ~ (http headers)
        * Header 정보들 (‘Header Name: Header Value’ 형태)
        * 각 줄은 Line Feed(LF)와 Carriage Return(CR)으로 구분된다.
* 빈 줄 (empty-line)
    * 요청에 대한 모든 메타 정보가 전송되었음을 알린다.
* Body
    * POST, PUT의 경우에만 존재
    * 요청과 관련된 내용 (HTML 폼 콘텐츠 등)<br>
 ![ex_screenshot](../img/http-request.png)<br>

### HTTP Response Message = Response Header + 빈 줄 + Response Body
* Header
    * 첫 번째 줄 (status-line)
        * HTTP 프로토콜 버전 + 응답 코드 + 응답 메시지
        * HTTP/1.1 404 Not Found.
    * 두 번째 줄 ~ (http headers)
        * Header 정보들 (‘Header Name: Header Value’ 형태)
        * 날짜, 웹서버 이름, 웹서버 버전, 콘텐츠 타입, 콘텐츠 길이, 캐시 제어 방식 등
        * 각 줄은 Line Feed(LF)와 Carriage Return(CR)으로 구분된다.
* 빈 줄 (empty-line)
    * 요청에 대한 모든 메타 정보가 전송되었음을 알린다.
* Body
    * 실제 응답 리소스 데이터
    * 201, 204와 같은 상태 코드를 가진 응답에는 보통 body가 존재하지 않는다.<br>
 ![ex_screenshot](../img/http-request.png)<br>
 
| HTTP 메소드 | 전송 형태 | 설명 | 비고 |
| --- | --- | --- | --- |
| GET | GET [request-uri]?query\_string<br>HTTP/1.1\r\n<br>Host:[Hostname] 혹은 [IP] \r\n | GET 요청 방식은 URI(URL)가 가진 정보를 검색하기 위해 서버 측에 요청하는형태이다 | 비고 |
| POST | POST [request-uri]?query\_string<br>HTTP/1.1\r\n<br>HOST:[Hostname] 혹은 [IP] \r\nContent-Lenght:[Lenght in Bytes] \r\n \r\n<br>[query-string] 혹은 [데이터] | POST 요청 방식은 요청 URI(URL)에 폼 입력을 처리하기 위해 구성한 서버 측 스크립트(ASP, PHP, JSP 등) 혹은 CGI 프로그램으로 구성되고 Form Action과 함께 전송되는데, 이때 헤더 정보에 포함되지 않고 데이터 부분에 요청 정보가 들어가게 된다. | 비고 |
| HEAD | HEAD [request-uri] HTTP/1.1\r\n<br>Host:[Hostname] 혹은 [IP] \r\n | HEAD 요청 방식은 GET과 유사한 방식이나 웹 서버에서 헤더 정보 이외에는 어떤 데이터도 보내지 않는다.웹 서버의 다운 여부 점검(Health Check)이나 웹 서버 정보(버전 등)등을 얻기 위해 사용될 수 있다. | 비고 |
| OPTIONS | OPTIONS [request-ri]<br>HTTP/1.1\r\n<br>Host:[Hostname] 혹은 [IP] \r\n | 해당 메소드를 통해 시스템에서 지원되는 메소드 종류를 확인할 수 있다. | 비고 |
| PUT | PUT [request-uri] HTTP/1.1\r\n<br>Host:[Hostname] 혹은 [IP] \r\n<br>Content-Lenght:[Length in Bytes] \r\n<br>Content-Type:[Content Type] \r\n\r\n[데이터] | POST와 유사한 전송 구조를 가지기 때문에 헤더 이외에 메시지(데이터)가 함께 전송된다.원격지 서버에 지정한 콘텐츠를 저장하기 위해 사용되며 홈페이지 변조에 많이 악용되고 있다. | 비고 |
| DELETE | DELETE [request-uri] HTTP/1.1\r\n<br>Host:[Hostname] 혹은 [IP] \r\n<br>\r\n | 원격지 웹 서버에 파일을 삭제하기 위해 사용되며 PUT과는 반대 개념의 메소드이다. | 비고 |
| TRACE | TRACE [request-uri] HTTP/1.1\r\n<br>Host:[Hostname] 혹은 [IP] \r\n<br>\r\n | 원격지 서버에 Loopback(루프백) 메시지를 호출하기 위해 사용된다. | 비고 |
| CONNECT | CONNECT [request-uri] HTTP/1.1\r\n<br>Host:[Hostname] 혹은 [IP] \r\n<br>\r\n | 웹 서버에 프록시 기능을 요청할 때 사용된다. | 비고 |

## HTTP 상태 코드

| 코드 번호 | 설명 | 비고 |
| --- | --- | --- |
| 100 | Continue (클라이언트로 부터 일부 요청을 받았으며 나머지 정보를 계속 요청함) | 비고 |
| 101 | Switching protocols | 비고 |
| 200 |OK(요청이 성공적으로 수행되었음) | 비고 |
| 201 | Created (PUT 메소드에 의해 원격지 서버에 파일 생성됨) | 비고 |
| 202 | Accepted(웹 서버가 명령 수신함) | 비고 |
| 203 | Non-authoritative information (서버가 클라이언트 요구 중 일부만 전송) | 비고 |
| 204 | No content, (사용자 요구 처리하였으나 전송할 데이터가 없음) | 비고 |
| 301 | Moved permanently (요구한 데이터를 변경된 타 URL에 요청함) | 비고 |
| 302 | Not temporarily | 비고 |
| 304 | Not modified (컴퓨터 로컬의 캐시 정보를 이용함, 대개 gif 등은 웹 서버에 요청하지 않음) | 비고 |
| 400 |Bad request (사용자의 잘못된 요청을 처리할 수 없음) | 비고 |
| 401 | Unauthorized (인증이 필요한 페이지를 요청한 경우) | 비고 |
| 402 |Payment required(예약됨) | 비고 |
| 403 | Forbidden (접근 금지, 디렉터리 리스팅 요청 및 관리자 페이지 접근 등을 차단) | 비고 |
| 404 | Not found, (요청한 페이지 없음) | 비고 |
| 405 | Method not allowed (혀용되지 않는 http method 사용함) | 비고 |
| 407 | Proxy authentication required (프록시 인증 요구됨)| 비고 |
| 408 | Request timeout (요청 시간 초과) | 비고 |
| 410 | Gone (영구적으로 사용 금지) | 비고 |
| 412 | Precondition failed (전체 조건 실패) | 비고 |
| 414 | Request-URI too long (요청 URL 길이가 긴 경우임)| 비고 |
| 500 | Internal server error (내부 서버 오류)| 비고 |
| 501 | Not implemented (웹 서버가 처리할 수 없음) | 비고 |
| 503 | Service unnailable (서비스 제공 불가 | 비고 |
| 504 | Gateway timeout (게이트웨이 시간 초과) | 비고 |
| 505 | HTTP version not supported (해당 http 버전 지원되지 않음)| 비고 |

