package findGCD;

import java.util.Scanner;

/**
 * 最大公因数
 * 
 * 递归式：gcd(a,b) = gcd(b,a%b)
 * 
 * 结束条件：gcd(a,0) = a
 * 
 * 本题gcd函数为非递归写法。
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(gcd(a, b));
	}

	private static int gcd(int a, int b) {
		if (a == b) {
			return a;
		} else if (a < b) {
			int temp = a;
			a = b;
			b = temp;
			System.out.println("a=" + a + "  b= " + b);
		}
		while (a % b != 0) {
			a = a % b;
			if (a < b) {
				int temp = a;
				a = b;
				b = temp;
			}
		}
		return a;
	}

}
