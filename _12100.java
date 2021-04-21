package code;

import java.util.*;

public class _12100 {

	static int n, result;
	static int[][] map = new int[20][20];
	static boolean[][] visited = new boolean[20][20];

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		// ╩С, го, аб, ©Л
		for (int dir = 0; dir < 4; dir++) {

			if (n == 1) {
				result = map[0][0];
				break;
			}

			// ╩С
			if (dir == 0) {

				for (int y = 0; y < n-1; y++) {
					for (int x = 0; x < n; x++) {
						
						map[y][x] = sc.nextInt();

						if(map[y][x] == 0) {
							map[y][x] = map[y+1][x];
						}
						
						if (map[y][x] == map[y + 1][x] && map[y][x] != 0 && !visited[y+1][x]) {
							map[y][x] = 2 * map[y][x];
							visited[y+1][x] = true;
							
						}
						
					}
				}
				

			} else if (dir == 1) {
			} else if (dir == 2) {
			} else if (dir == 3) {
			}

		}

		System.out.println(result);

		sc.close();
	}
}
