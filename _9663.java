package code;

import java.util.*;

public class _9663 {

	static boolean[][] arr = new boolean[15][15];
	static int N;

	static boolean[] check_rigtDig = new boolean[40];
	static boolean[] check_leftDig = new boolean[40];
	static boolean[] check_col = new boolean[15];

	public static boolean check(int row, int col) {

		if (check_col[col]) {
			return false;
		}
		
		if (check_rigtDig[row + col]) {
			return false;
		}

		if (check_leftDig[row - col + N]) {
			return false;
		}

		return true;
	}

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		System.out.println(solve(0));

		sc.close();
	}

	public static int solve(int row) {
		if (row == N) {
			return 1;
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			
			// 놓을수 있으면
			if(check(row, i)) {
				
				check_rigtDig[row + i] = true;
				check_leftDig[row - i + N] = true;
				check_col[i] = true;
				arr[row][i] = true;
				
				count += solve(row + 1);
				
				check_rigtDig[row + i] = false;
				check_leftDig[row - i + N] = false;
				check_col[i] = false;
				arr[row][i] = false;
			}
		}		
		return count;
	}
}
