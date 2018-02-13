package binarySearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testBinarySearch {

	public static void main(String[] args) {
		//输入一组有序数组，空格分隔。
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = null;
		String st2 = null;
		try {
        st = (String) br.readLine();
        st2 = (String) br.readLine();
        br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
        int key = Integer.parseInt(st2);   //另起一行输入要查找的值
		
        String[] result = st.split(" ");
        int[] num = new int[result.length];
        for (int i=0;i<result.length;i++) {
            num[i] = Integer.parseInt(result[i]);
        }

		//输入字符已经转换为整型数组。
        int index = BinarySearch(key,num)+1;
        System.out.println(index > 0?"索引值  "+index:"不存在");
		}
	/**
	 * @param key 要查找的词
	 * @param a 输入有序数组
	 * @return
	 */
	public static int BinarySearch(int key,int[] a) {
		int left = 0;
		int right = a.length - 1;
		while(left <= right) {
			int mid = left+ (right-left)/2;  //此处不写（R-L）/2是因为防止越界。
			if(key < a[mid]) {
				right = mid -1;
			}
			else if(key > a[mid]) {
				left = mid + 1;
			}
			else return mid;
		}		
		return -1;
	}
	}
