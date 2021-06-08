package baekjoon;

import java.io.*;

public class _9498 {
	public static void main(String[] arg) throws Exception {
		String answer = "";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (90 <= N && N <= 100) {
			answer = "A";
		} else if (80 <= N && N <= 89) {
			answer = "B";
		} else if (70 <= N && N <= 79) {
			answer = "C";
		} else if (60 <= N && N <= 69) {
			answer = "D";
		} else {
			answer = "F";
		}

		System.out.println(answer);
	}
}
