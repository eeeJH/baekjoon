package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/10250
 * <pre>
 * <b>baekjoon</b>
 * 
 * @author 이주현
 * @version 1.0
 * @date 2021.07.24
 * 
 */

public class _10250 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < TestCase; i++) {
			StringBuilder sb = new StringBuilder();
			String[] str = br.readLine().split(" ");
			int H = Integer.parseInt(str[0]);
			int N = Integer.parseInt(str[2]);

			int front = N % H == 0 ? H * 100 : (N % H) * 100;
			int back = N % H == 0 ? N / H : N / H + 1;
			sb.append(front + back);

			System.out.println(sb);
		}
	}
}
