package baekjoon;

import java.io.*;

public class _14681 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int answer = 0;

		if (x > 0 && y > 0) {
			answer = 1;
		} else if (x < 0 && y > 0) {
			answer = 2;
		} else if (x < 0 && y < 0) {
			answer = 3;
		} else if (x > 0 && y < 0) {
			answer = 4;
		}

		System.out.println(answer);
	}
}
