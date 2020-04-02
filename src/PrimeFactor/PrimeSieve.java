package PrimeFactor;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeSieve {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		
		int[] arr = new int [m+1];
		arr[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}
		// 素数筛
		for (int i = 2; i <= arr.length-1; i++) {
			if(arr[i]==0)continue;
			for(int j = 2;i*j<=m;j++) {
				arr[i*j] = 0;
			}
		}
		// end

		System.out.println(Arrays.toString(arr));
	}
}
