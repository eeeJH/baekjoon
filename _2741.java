package baekjoon;

import java.io.*;

public class _2741 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		br.close();

		for (int i = 1; i <= N; i++) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}
}
