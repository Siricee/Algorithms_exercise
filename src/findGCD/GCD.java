package findGCD;

import java.util.Scanner;

/**
 * 
 * @author Sirice
 * 求最大公因数
 */
public class GCD {

	@SuppressWarnings("resource")
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		
		int a = s.nextInt();
		int b = s.nextInt();
		
		if(a==b){
			System.out.println(a);
			return;
		}else if(a<b){
			int c = a;
			a =  b;
			b = c;
		}
		
		while(a%b != 0){
			a = a % b;
			if(a<b){
				int c = a;
				a = b;
				b = c;
			}
		}
		
		System.out.println(b);
	}
}