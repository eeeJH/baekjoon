package baekjoon;

import java.io.*;

public class _1546 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] numbers = br.readLine().split(" ");
		int sum = 0;
		double max = Double.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			sum += Integer.parseInt(numbers[i]);
			if (max < Integer.parseInt(numbers[i])) {
				max = Integer.parseInt(numbers[i]);
			}
		}

		System.out.println(sum * 100 / max / N);

	}
}
