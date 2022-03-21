<pre><code>//두수 비교하기
import java.util.Scanner;
public class codeTestDay1  {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		if (a > b)
			System.out.println(">");
		else if (a < b)
			System.out.println("<");
		else
			System.out.println("==");
	}
}</code></pre>
<br>
<pre><code>//시험 성적
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		sc.close();
		if(100 >= a & 90 <= a ){
			System.out.println("A");
		}
		else if(89 >= a & 80 <= a ){
			System.out.println("B");
		}
		else if(79 >= a & 70 <= a ){
			System.out.println("C");
		}
		else if(69 >= a & 60 <= a ){
			System.out.println("D");
		}
		else{
			System.out.println("F");
		}
	}
}</code></pre>
<br>
<pre><code>//윤달
import java.util.Scanner;
public class Main  {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		sc.close();
		int b = a%4;
		int c = a%100;
		int d = a%400;
		if ((b == 0 && c != 0) || d == 0) {
			System.out.println("1");
		}
		else System.out.println("0");
	}
}</code></pre>
<br>
<pre><code>
//주사위 상금 계산
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main  {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		ArrayList <Integer> num = new ArrayList<>();
		num.add(a);
		num.add(b);
		num.add(c);
		if (a == b && b == c) {
			int val = 10000 + (a * 1000);
			System.out.println(val);
		}
		else if(a == b && b != c){
			int val = 1000 + (a * 100);
			System.out.println(val);
		}
		else if(b == c && c != a){
			int val = 1000 + (b * 100);
			System.out.println(val);
		}
		else if(c == a && a != b){
			int val = 1000 + (c * 100);
			System.out.println(val);
		}
		else{
			Collections.sort(num);
			int val = num.get(2) * 100;
			System.out.println(val);
		}
	}
}</code></pre>
<br>
<pre><code>
//오븐시간
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		int total = a * 60 + b + c;
		int th = total / 60;
		int tm = total % 60;
		if(th >= 24){
			th = th - 24;
		}
		System.out.println(th + " " + tm);
	}
}
</code></pre>


