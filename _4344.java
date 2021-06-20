package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _4344 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int C = Integer.parseInt(br.readLine());
		for (int i = 0; i < C; i++) {
			String[] testCase = br.readLine().split(" ");
			int students = Integer.parseInt(testCase[0]);
			int sum = 0;
			int count = 0;
			double avg = 0;
			for (int j = 1; j <= students; j++) {
				sum += Integer.parseInt(testCase[j]);
			}
			avg = sum / students;
			for (int j = 1; j <= students; j++) {
				if (avg < Integer.parseInt(testCase[j])) {
					count++;
				}
			}
			sb.append(String.format("%.3f",(double)count * 100 / students) + "%").append("\n");
		}
		System.out.print(sb);
	}
}
