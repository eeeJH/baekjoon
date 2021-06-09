package baekjoon;

import java.io.*;

public class _10950 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] numbers = br.readLine().split(" ");
			int A = Integer.parseInt(numbers[0]);
			int B = Integer.parseInt(numbers[1]);

			System.out.println(A + B);
		}
	}
}
