package DivisorNumber;
import java.util.Scanner;

public class DivisorNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			check(arr[i]);
		}
	}

	/**
	  * 求 a 的约数
	 * 
	  * 本题范围(1<=Num<=1000000000)求约数如果O(n),2s必然过不去。
	 * 
	  * 本题条件下必须使用 i<Math.sqrt(a) 比较，O(logn)
	 * 
	  * 求N约数过程：i小于N开方时，每自减1，整除则得到2个约数；i等于N开方时，整除得到一个约数
	 * 
	 * @param a
	 */
	public static void check(int a) {
		int ans = 0;
		int i = 1;
		for (; i < Math.sqrt(a); i++) {
			if (a % i == 0) {
				ans += 2;
			}
		}
		if (i == Math.sqrt(a))
			ans += 1;
		System.out.println(ans);
	}

}
