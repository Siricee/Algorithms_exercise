package findGCD;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(gcd(a,b));
	}

	private static int gcd(int a, int b) {
		if(a == b) {
			return a;
		}
		else if (a < b) {
			int temp = a;
			a = b;
			b = temp;
			System.out.println("a="+a+"  b= "+b);
		}
		while (a % b != 0) {
			a= a%b;
			if(a<b) {
				int temp = a;
				a = b;
				b = temp;
			}
		}
		return a;
	}

}
