package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _11720 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] numbers = br.readLine().split("");
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Integer.parseInt(numbers[i]);
		}
		System.out.println(sum);
	}
}
