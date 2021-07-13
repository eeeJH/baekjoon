package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2292
 * <pre>
 * <b>baekjoon</b>
 * 
 * @author 이주현
 * @version 1.0
 * @date 2021.07.13
 * 
 * */

public class _2292 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int n = 0;
		int number = 1;
		while (true) {
			
			number = number + (6 * n++);
			
			if (number >= N) {
				break;
			}

		}

		System.out.println(n);
	}
}
