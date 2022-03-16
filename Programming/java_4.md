# Hello World
 ## 문자열
 ##### 아... 지금 이미지 파일 이름을 unicode로 전송하는데 한글이 깨지는 원인을 찾아야한다. 
 ##### DB에는 잘 저장되고, 가져올 때 문제가 생긴다.
 ##### UTF-8로 하면 한자가 로그에 찍힌다. 윈도우 부터 한글설정 하고 테스트 할 예정이다.
 ---
- 문자열 연결<br>
<pre><code>String location = "Java";
String greeting = "Hello " + location; //Hello Java</code></pre>

. "Next year, you will be " + age + 1; //오류<br>
. "Next year, you will be " + (age + 1); // OK<br>
. 구분자 결합
<pre><code>String names = String.join(",", "Peter", "Paul", "Mary");</code></pre>
. 첫 번째 인자는 분리 문자열, 두 번째 인자부터는 결합하고 싶은 문자열을 지정<br>
. 다른 방법 StringBuilder<br>
<pre><code>StringBuilder builder = new StringBuilder();
while(문자열 있으면) {
    builder.append(다음 문자열);
}
String result = builder.toString();</code></pre>

- 부분 문자열
<pre><code>String greeting = "Hello, World!";
String location = greeting.substring(7, 12);</code></pre>
<pre><code>String names = "Peter, Paul, Mary";
String[] result = name.split(",");</code></pre>

- 문자열 비교 : 많이 쓴다. 배열에서 검색할 때도 DB값 가져와서 찾을 때도.
<pre><code>location.equals("World")</code></pre>
<pre><code>if (middleName == null)</code></pre>
. NullPointerExeption 정말 조심하자. <br>
##### 내가 겪은 Exeption 3대장 : Null, Array Range, ?하나 뭐였지.<br>

- 숫자와 문자열 사이의 변환
. Integer.toString();<br>
. Integer.parseInt();<br>
. Double.toString();<br>
. Double.parseDouble();<br>

- 문자열 API : 잘 일고 이게 있구나 느끼자, 사실 필요할 때 잘 구글링 해보는게 최고다.
- 코드 포인트와 코드 유닛

