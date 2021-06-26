package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _10809 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int[] numbers = new int[26];
		for (int i = 0; i < S.length(); i++) {
			if (numbers[S.charAt(i) - 'a'] == 0) {
				numbers[S.charAt(i) - 'a'] = i + 1;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] - 1 + " ");
		}
	}
}
