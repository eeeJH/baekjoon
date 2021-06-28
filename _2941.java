package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2941 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] match = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		for (int i = 0; i < match.length; i++) {
			s = s.replace(match[i], "1");
		}
		System.out.println(s.length());
	}
}
