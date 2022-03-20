import java.util.Scanner;

public class codeTestDay1  {
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
}
