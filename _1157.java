package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1157 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpa = new int[26];
		String s = br.readLine().trim();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) > 96) {
				alpa[s.charAt(i) - 97]++;
			} else {
				alpa[s.charAt(i) - 65]++;
			}
		}
		
		int max = Integer.MIN_VALUE;
		int c = 0;
		
		for (int i = 0; i < alpa.length; i++) {
			if (max < alpa[i]) {
				max = alpa[i];
				c = i;
			} else if (max == alpa[i]) {
				c = -2;
			}
		}

		System.out.println((char) (c + 65));
	}
}
