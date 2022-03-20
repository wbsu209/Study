import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class codeTestDay1  {
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
}
