package code;

import java.util.*;

public class _14888 {

	static int n, k = 0;
	static int[] arr = new int[100];

	// index 에 따라서 연산자 결정
	// 0: +, 1: -, 2 : *, 3 : /

	static int[] optCnt = new int[4];
	static boolean[] visited;

	static int[] optArr;
	static int maxVal = Integer.MIN_VALUE;
	static int minVal = Integer.MAX_VALUE;
	// -1,000,000,000 <= x <=1,000,000,000

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			optCnt[i] = sc.nextInt();
			k += optCnt[i];
		}

		optArr = new int[k];
		int index = 0;
		for (int j = 0; j < 4; j++) {
			while (optCnt[j] > 0) {
				optArr[index++] = j;
				optCnt[j]--;

			}
		}

		visited = new boolean[k];

		solve(arr[0], 1);

		// 최댓값
		System.out.println(maxVal);
		// 최솟값
		System.out.println(minVal);

		sc.close();
	}

	public static void solve(int nm, int depth) {

		if (depth == n) {
			// 값 계산
			if (maxVal < nm) {
				maxVal = nm;
			}
			if (minVal > nm) {
				minVal = nm;
			}

			return;
		}

		for (int i = 0; i < n-1; i++) {
			int cur = arr[depth];
			if (!visited[i]) {
				visited[i] = true;
				int sum = 0;
				sum = cal(nm, cur, optArr[i]);
				solve(sum, depth + 1);
				visited[i] = false;
			}
		}

	}

	public static int cal(int a, int b, int oper) {
		switch (oper) {
		// +
		case 0:
			return a + b;
		// -
		case 1:
			return a - b;
		// *
		case 2:
			return a * b;
		// /
		case 3:
			return a / b;
		}

		return -1;
	}

}
