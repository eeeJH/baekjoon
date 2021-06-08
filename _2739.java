package baekjoon;

import java.io.*;

public class _2739 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 10; i++) {
			sb.append(N).append(" * ").append(i).append(" = ").append(N * i).append("\n");
		}
		System.out.println(sb);
	}
}
