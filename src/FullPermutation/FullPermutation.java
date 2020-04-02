package FullPermutation;
/**
  *  全排列的递归回溯法
 */
public class FullPermutation {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };

		Permutation(arr, 0, arr.length - 1);

	}

	public static int[] swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return arr;
	}
	// n个数的全排列个数：A(n,n) = n!
	public static void Permutation(int[] arr, int left, int right) {
		if (left == right) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		// 递归思路：划分重复最小子问题
		// 只有两个数的时候：交换一次、换回来一次（本身）即可
		// 三个数的时候：拿出一个数当头，剩下的两个数重复上一步
		// 四个数的时候：拿出一个数当头，剩下的三个数重复上一步
		// 以此类推
		for (int i = left; i <= right; i++) {
			swap(arr, i, left);// 交换i和left位置
			Permutation(arr, left + 1, right); // 拿出上次的left作为头，将left+1 - right继续排列
			swap(arr, i, left);// 换回来（取消决策，回溯）
		}
	}

}
