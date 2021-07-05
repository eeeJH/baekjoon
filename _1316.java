package baekjoon;

/*
 * https://www.acmicpc.net/problem/1316 
 * <pre>
 * <b>Baekjoon</b>
 * 
 * @author 이주현
 * @version 1.0
 * @date 2021.07.05
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1316 {
	public static void main(String[] arg) throws Exception {
		int ret = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine() + " ";
			int s_len = s.length() - 1;
			boolean flag = false;
			boolean[] alph = new boolean[26];
			for (int idx = 0; idx < s_len; idx++) {
				
				if (alph[s.charAt(idx) - 97]) {
				
					flag = true;
					break;
				} else {
					if (s.charAt(idx) == s.charAt(idx + 1)) {
						continue;
					} else {
						alph[s.charAt(idx) - 97] = true;
					}
				}

			}
			
			if (!flag) {
				ret++;
			}
		}
		System.out.println(ret);
	}
}
