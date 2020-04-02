package PrimeFactor;
import java.util.Scanner;

/**
 * 分解质因数
 * 
 * 对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
 * 
 * 1. 如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
 * 
 * 2. 如果n<>k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你n,重复执行第一步。
 * 
 * 3. 如果n不能被k整除，则用k+1作为k的值,重复执行第一步。
 *
 */
public class PrimeFactor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for (int i = 2; i < n; i++) {
			while (n != i) {
				if (n % i == 0) { // 能整除合数的必能整除质因数。所以外层循环避免了i=4的情况，直接break了
					n = n / i; 
					System.out.print(i + " ");
					count += 1;
				} else
					break;
			}
		}
		System.out.print("(i=n时跳出循环最后留下的因子:)"+n);
		System.out.println();
		count += 1;
		System.out.println("factor_num: " + count);
	}

}
