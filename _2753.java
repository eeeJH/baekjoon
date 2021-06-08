package baekjoon;

import java.io.*;

public class _2753 {

	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		int answer = 0;

		if (year % 4 == 0) {
			if (year % 100 != 0 || year % 400 == 0) {
				answer = 1;
			}
		}

		System.out.println(answer);

	}

}
