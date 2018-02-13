package mergeSort;

import java.util.Arrays;

public class Test {
public static void main(String[] args) {
	int[] a = {1,2,3};
	System.out.println(Arrays.toString(a));
	caozuo(a);
	System.out.println(Arrays.toString(a));
}
static void caozuo(int[] array) {
	for(int i = 0;i<array.length;i++) {
		array[i] +=1;
	}
}

}
