# Programming
## Java
---
### Day - 1
---
#### java setting
1. VSCODE 설치
2. JDK 설치(11버전으로 설치)
3. JAVA 환경 변수 설정하기
- JAVA_HOME : C:\Program Files\Java\jdk-11.0.12
- JDK_HOME : C:\Program Files\Java\jdk-11.0.12
- CLASSPATH : C:\Program Files\Java\jdk-11.0.12\;.;
- PATH 편집 %JAVA_HOME%\bin
4. VSCODE에 JAVA환경 세팅 - 확장 프로그램 설치
- Java Extension Pack 설치
5. File메뉴 - Preferences - Setting - Extension - Java - Home - Edit in settings.json 클릭 해서 내용 입력
- "java.home" : "C:\\Program Files\\Java\\jdk-11.0.12"
- BUT!!!! 나의 경우 java.home으로 setting 할 경우 계속 "java.jdt.ls.java.home"으로 대신하라는 경고문이 발생
- "java.jdt.ls.java.home": "C:\\Program Files\\Java\\jdk-11.0.12"으로 Setting 하여 진행 했다
6. 관련 링크 : https://github.com/redhat-developer/vscode-java 
