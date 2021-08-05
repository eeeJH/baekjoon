package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2775
 * <pre>
 * <b>baekjoon</b>
 * 
 * @author 이주현
 * @version 1.0
 * @date 2021.08.05
 * 
 */

public class _2775 {

	static int[][] map = new int[15][15];

	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < 15; i++) {
			map[0][i] = i;
			map[i][1] = 1;
		}

		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}

		for (int TestCase = 0; TestCase < T; TestCase++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(map[k][n]);
		}
	}
}
