package quickSort;

import java.util.Arrays;

public class testQuickSort {

	public static void main(String[] args) {
		
//		long startTime = System.currentTimeMillis();

		int[] testData = { 4, 2, 1, 6, 35, 53, 65, 23, 45, 53, 13, 15, 64, 65, 687, 765, 13, 6, 54, 64, 76, 5, 2421, 64, 5475 };

		System.out.println(Arrays.toString(testData));
		System.out.println();
		sort(testData);

//		long endTime = System.currentTimeMillis();
		System.out.println(Arrays.toString(testData));
//		long time = endTime - startTime;
//		System.out.println(time + "ms");

	}

	public static void sort(int[] array) {
		QuickSort(array, 0, array.length - 1);
	}//排序执行入口
	
	public static void QuickSort(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		QuickSort(a, lo, j - 1);
		QuickSort(a, j + 1, hi);

	}//快排阶段，确定j的数值，j左侧递归快排，j右侧递归快排

	private static int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int v = a[lo];
		while (true) {
			while (a[++i] < v) {
				if (i == hi)
					break;
			}
			while (v < a[--j]) {
				if (j == lo)
					break;
			}
			if (i >= j)
				break;
			exchange(a, i, j);
		}//比较大小的partition过程
		exchange(a, lo, j);//将a[j]回归应该在的位置。
		return j;
	}//

	private static void exchange(int[] a, int i, int j) {
		int temp = 0;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
