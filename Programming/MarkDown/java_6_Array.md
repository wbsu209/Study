# Hello World
## 배열
---
### 배열 다루기
- 배열 선언 : String[] names = new String[100];

- 배열 접근 : names[n]
- 배열 길이 : names.length(루프문에서 많이 쓴다.)
- 배열 생성 : int[] primes = {2, 4, 6, 7};

### 배열 리스트 (정말 많이 쓰고 있다. 중요하다고 생각한다.)
- 배열리스트 선언 : ArrayList<Integer> numbers = new ArrayList<>();

- 배열과 반복문
<pre><code>ArrayList<String> people = new ArrayList<>();
...
for (String name : people) {
    ...
}</code></pre>

- 배열과 배열리스트 복사<br>
. 배열 값을 공유<br>
int[] num = primes;<br>
num[5] = primes[5] = 42 <br>

. 배열 값 공유 안함<br>
int[] copied = Array.copyOf(primes, primes.length);<br>

. 배열 리스트 값 공유<br>
ArrayList<String> manNwoman = people;<br>
manNwoman.get(0) = people.get(0) = mary<br>
배열 리스트 값 공유 안함<br>
ArrayList<String> copied = new ArrayList<>(people);<br>

- 정렬 : .sort();, 문자열 : .toString();<br>

- 다차원 배열 : 잘 쓰면 좋지만 애매하게 쓰면, 쓴 사람도 처음보는 사람도 헷갈리기 쉽다.<br>
. 파스칼 삼각형
<pre><code>for(int i=0; i < n; i++){
    tri[i] = new int [i + 1];
    tri[i][0] = 1;
    tri[i][i] = 1;
    for (int j = 0; j < i; j++) {
        tri[i][j] = tri[i-1][j-1] + tri[i-1][j]
    }
}</code></pre>



