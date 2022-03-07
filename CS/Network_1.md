# CS
## Network
### * Road Map
![ex_screenshot](../img/map_first.png)

 Internet = Intranet + \<Inter> + Intranet

 **\* 인터넷 작동 원리**

- 도메인 주소 입력
- DNS Server로 이동
- 해당 도메인 주소를 IP 주소로 반환 (도메인 IP 요청도 레벨에 따라 구분된다.(Local DNS -> another DNS))

**\* url의 구조**
![ex_screenshot](../img/url_str.png)

- Protocol<br>
http : 평문(Plain Text)으로 요청(url에 기입된 내용 그대로)<br>
https : http + secure, 복호화 되서 정보 전달
- Domain : 요구하는 웹서버 지칭
- Path : / 뒤에 오는 부분, 웹서버에 있는 자원에 대한 경로
- Parameter(QueryString) : ? 뒤에 나오는 부분, key=value로 전달 되는 값으로 웹서버에 제공하는 추가 파라미터
- Fragment : 특정 요소를 지시하는 값 (ex. 해당 페이지의 스크롤 위치를 정하는 값)

**\* url 요청 시**
- naver.com 접속 시 <br>
여러번의 Requet와 Response가 연속적으로 발생
![ex_screenshot](../img/request_response.PNG)
- 많은 요소들을 한번에 요청하는것 보다 세분화하여 장애 대응이나 관리가 편하다.(실무에서도)<br>

**\* Content-Type**
- application/json<br>
RestFul API<br>
{key : value}
- application/x-www-form-urlencoded<br>
key=value&key=value

**\* 참고 사항**<br>
Postman 사용 시 querystring과 body 헷갈리지 말 것<br>
- Post 사용 시 body에 쓰여지는 Key=Value값과 Get 사용 시 쓰여지는 Key=value값 혼동 주의

**\* 참고 사항**<br>
http request를 tomcat이 자바 객체로 변환<br>
<<<<<<< HEAD
tomcat과 spring 둘 다 http를 객체로 사용하기 위함(springboot는 사용자의 편의를 위해 tomcat을 내장한다.)<br>
##### 이미지 참조 : https://media.vlpt.us/images/seul06/post/eafb79a9-28b1-4742-acb3-fcea6b7a03d2/%E1%84%85%E1%85%A9%E1%84%83%E1%85%B3%E1%84%86%E1%85%A2%E1%86%B803.png

##### https://www.beusable.net/blog/wp-content/uploads/2021/02/image-6.png
=======
tomcat과 spring 둘 다 http를 객체로 사용하기 위함(springboot는 사용자의 편의를 위해 tomcat을 내장한다.)
>>>>>>> 7b6a374c05a0fd5b845dda02113150a29f455542
