package baekjoon;

import java.util.*;

public class _20057 {

	static int[][] map;
	static int n;

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };

	static int[] dirY = { -2, -1, -1, -1, 0, 1, 1, 1, 2, 0 };
	static int[] dirX = { 0, -1, 0, 1, -2, -1, 0, 1, 0, -1 };
	static double[] percent = { 0.02, 0.1, 0.07, 0.01, 0.05, 0.1, 0.07, 0.01, 0.02, 1 };

	static int result = 0;

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		solve(n / 2, n / 2);

		System.out.println(result);
		sc.close();
	}

	public static void solve(int curY, int curX) {

		while (curY == 0 && curX == -1) {
			int count = 1;
			// ����̵� 4�����ε�
			// ��, ��, �� , ��
			for (int dir = 0; dir < 4; dir++) {

				for (int cnt = 0; cnt < count; cnt++) {

					curY = curY + dr[dir];
					curX = curX + dc[dir];

					int mod = 0;

					for (int i = 0; i < 10; i++) {

						map[curY + dirY[i]][curX + dirX[i]] += (int) (map[curY][curX] * percent[i]);
						mod += (int) (map[curY][curX] * percent[i]);
						if (i == 9) {
							map[curY + dirY[i]][curX + dirX[i]] += map[curY][curX] - mod;
						}

					}
				}

				if (dir == 1) {
					count++;
				}
				
				

			}

		}

	}

	public static String fmt(double d) {
		if (d == (long) d) {
			return String.format("%d", (long) d);
		} else {
			return String.format("%d", d);
		}
	}
}
