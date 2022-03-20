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