package baekjoon;

import java.io.*;

public class _8958 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String ox = br.readLine();
			int score = 0;
			int sum = 0;
			for (int j = 0; j < ox.length(); j++) {
				if (ox.charAt(j) == 'O') {
					score++;
					sum += score;
				} else {
					score = 0;
				}
			}
			System.out.println(sum);
		}
	}
}
