package Advanced_QuickPow;

public class QuickPow {

	/**
	 * 这个算法为矩阵快速幂的实现。 参考文章[矩阵快速幂——入门 - 简书 https://www.jianshu.com/p/1c3f88f63dec]
	 * 区别为：举例2的16次幂
	 * 
	 * 快速幂算法: (((2^2)^2)^2)^2 做4次乘法 -----时间复杂度O(logn) 
	 * 普通幂算法: 2*2...*2(乘16个2) ------------时间复杂度O(n)
	 * 
	 * 即指数按2分解，每次用之前的结果做乘方，相当于二分幂计算，时间复杂度同二分查找。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 为了说明普适性用奇数举例做乘方
		System.out.println(1 << 17);
		System.out.println(quickPow(2, 17));
		System.out.println(pow(2, 17));
	}

	static int quickPow(int a, int index) {
		int ans = 1;

		while (index > 0) {
			if ((index & 1) != 0) {
				ans *= a;
			}
			a *= a;
			index /= 2;
			System.out.println("快速幂index=" + index);
			System.out.println("快速幂ans=" + ans);
			System.out.println("快速幂a=" + a);
			System.out.println();
		}

		return ans;
	}

	static int pow(int a, int index) {
		int ans = 1;
		for (int i = 0; i < index; i++) {
			ans *= a;
		}
		return ans;
	}

}
