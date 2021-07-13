package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/1193
 * <pre>
 * <b>baekjoon</b>
 * 
 * @author 이주현
 * @version 1.0
 * @date 2021.07.13
 * 
 */

public class _1193 {

	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int n = 0;
		int cnt = 0;
		while (true) {
			n++;
			cnt += n;
			if (cnt >= X) {
				if (n % 2 == 0) {
					System.out.println(X - cnt + n + "/" + (cnt - X + 1));
				} else {
					System.out.println((cnt - X + 1) + "/" + (X - cnt + n));
				}
				break;
			}
		}

	}
}
