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
