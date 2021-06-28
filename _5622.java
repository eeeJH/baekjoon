package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _5622 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (65 <= s.charAt(i) && s.charAt(i) <= 67) {
				sum += 3;
			} else if (68 <= s.charAt(i) && s.charAt(i) <= 70) {
				sum += 4;
			} else if (71 <= s.charAt(i) && s.charAt(i) <= 73) {
				sum += 5;
			} else if (74 <= s.charAt(i) && s.charAt(i) <= 76) {
				sum += 6;
			} else if (77 <= s.charAt(i) && s.charAt(i) <= 79) {
				sum += 7;
			} else if (80 <= s.charAt(i) && s.charAt(i) <= 83) {
				sum += 8;
			} else if (84 <= s.charAt(i) && s.charAt(i) <= 86) {
				sum += 9;
			} else {
				sum += 10;
			}
		}
		System.out.println(sum);
	}
}
