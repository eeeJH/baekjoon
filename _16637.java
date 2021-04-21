package code;

import java.util.*;

public class _16637 {

	public static class Pipe {
		int hr, hc;

		Pipe(int hr, int hc) {
			this.hr = hr;
			this.hc = hc;
		}

	}

	static int N, result;
	static int[][] arr = new int[16][16];

	// ����, ����, �밢��
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { 1, 1 } };

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				arr[i][j] = sc.nextInt();
			}
		}

		sc.close();

		solve(1, 0, 0);

		System.out.println(result);
	}

	public static void solve(int x, int y, int pipe) {
		if (x == N - 1 && y == N - 1) {
			result++;

			return;
		}

		// ����, ����, �밢�� 3�������� ����
		for (int i = 0; i < 3; i++) {

			if ((i == 0 && pipe == 1) || (i == 1 && pipe == 0)) {
				continue;
			}

			int newc = x + dir[i][0];
			int newr = y + dir[i][1];

			// ������ ����ų� ���� �ִ� ���
			if (newr >= N || newc >= N || arr[newr][newc] == 1) {
				continue;
			}

			if (i == 2 && (arr[y + 1][x] == 1 || (arr[y][x + 1] == 1))) {
				continue;
			}

			solve(newc, newr, i);

		}

	}
}
