package mergeSort;

import java.util.Arrays;

/**
 * @author Sirice 基础归并算法实现
 * 
 */
public class TestMergeSort {
	private static int[] aux;

	public static void main(String[] args) {

		int[] testData = { 8, 2, 6, 4, 35, 53, 65, 23, 45, 53, 13, 15, 64, 65, 687, 765, 13, 6, 54, 64, 76, 5, 2421, 64,
				5475 };
		aux = new int[testData.length];
		System.out.println(Arrays.toString(testData));

		sort(testData);

		System.out.println(Arrays.toString(testData));

	}

	public static void sort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}

	public static void mergeSort(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		mergeSort(a, lo, mid);
		mergeSort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

	public static void merge(int[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (aux[j] < aux[i])
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

}
