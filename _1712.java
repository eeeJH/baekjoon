package baekjoon;

/*
 * https://www.acmicpc.net/problem/1712 
 * <pre>
 * <b>Baekjoon</b>
 * 
 * @author 이주현
 * @version 1.0
 * @date 2021.07.05
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1712 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int A = Integer.parseInt(str[0]);
		int B = Integer.parseInt(str[1]);
		int C = Integer.parseInt(str[2]);
		System.out.println((B < C ? (A / (C - B)) + 1 : -1));
	}
}
