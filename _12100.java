package code;

import java.util.*;

public class _12100 {

	static int n, result = 0;
	static int[][] map = new int[20][20];

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		operation(0);

		System.out.println(result);

		sc.close();
	}

	public static void operation(int tried) {

		
		if (tried == 5) {

			maxValue();

			return;
		}
		
		int[][] copy_map = new int[20][20];

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				copy_map[y][x] = map[y][x];
			}
		}

		// ╩С, го, аб, ©Л
		for (int dir = 0; dir < 4; dir++) {

			// ╩С
			if (dir == 0) {

				for (int i = 0; i < n; i++) {
					
					int index = 0;
					int block = 0;
					for (int j = 0; j < n; j++) {
						
						if (map[j][i] != 0) {
							if (block == map[j][i]) {
								map[index - 1][i] = block * 2;
								block = 0;
								map[j][i] = 0;
							} else {
								block = map[j][i];
								map[j][i] = 0;
								map[index][i] = block;
								index++;
							}
						}
					}
				}

			} else if (dir == 1) {

				for (int i = 0; i < n; i++) {
					
					int index = n - 1;
					int block = 0;
					
					for (int j = n - 1; j >= 0; j--) {
						if (map[j][i] != 0) {
							if (block == map[j][i]) {
								map[index + 1][i] = block * 2;
								block = 0;
								map[j][i] = 0;
							} else {
								block = map[j][i];
								map[j][i] = 0;
								map[index][i] = block;
								index--;
							}
						}
					}
				}

			} else if (dir == 2) {

				for (int i = 0; i < n; i++) {
					int index = 0;
					int block = 0;
					for (int j = 0; j < n; j++) {
						if (map[i][j] != 0) {
							if (block == map[i][j]) {
								map[i][index - 1] = block * 2;
								block = 0;
								map[i][j] = 0;
							} else {
								block = map[i][j];
								map[i][j] = 0;
								map[i][index] = block;
								index++;
							}
						}
					}
				}

			} else if (dir == 3) {

				for (int i = 0; i < n; i++) {
					int index = n - 1;
					int block = 0;
					for (int j = n - 1; j >= 0; j--) {
						if (map[i][j] != 0) {
							if (block == map[i][j]) {
								map[i][index + 1] = block * 2;
								block = 0;
								map[i][j] = 0;
							} else {
								block = map[i][j];
								map[i][j] = 0;
								map[i][index] = block;
								index--;
							}
						}
					}
				}

			}

			operation(tried + 1);

			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					map[y][x] = copy_map[y][x];
				}
			}

		}

	}

	public static void maxValue() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (map[i][j] > result) {
					result = map[i][j];
				}
			}
		}
	}
}
