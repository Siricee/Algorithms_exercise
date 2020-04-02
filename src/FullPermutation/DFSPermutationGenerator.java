package FullPermutation;
/**
 * DFS构造全排列 - 知乎
 * https://zhuanlan.zhihu.com/p/27112937
 */

public class DFSPermutationGenerator {
	public int N;
    private boolean[] used;
    private int[] result;

	public DFSPermutationGenerator(int n) {
        N = n;
        used = new boolean[n + 1];
        result = new int[n];
    }

    public static void main(String[] args) {
    	DFSPermutationGenerator generator = new DFSPermutationGenerator(4);
       
        generator.make(0);
    }

    public void make(int level) {
        for (int i = 1; i <= N ; i++) {
            if (!used[i]) {
                used[i] = true;
                result[level] = i;
                make(level + 1); // result 在这里递归初始化，每次都把每个元素+1
                used[i] = false;
            }
        }

        if (level == N - 1) {
            for (int i = 0; i < N; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }

}
