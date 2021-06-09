package baekjoon;

import java.io.*;

public class _8393 {
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			answer += i;
		}
		System.out.println(answer);
	}
}
