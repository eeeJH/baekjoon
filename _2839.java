package baekjoon;

import java.io.*;

public class _2839 {

	public static void main(String[] arg) throws Exception {
		int answer = -1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = N / 5; i >= 0; i--) {
		
			int n3 = (N - (5 * i)) / 3;
			int mod3 = (N - (5 * i)) % 3;
			
			if(mod3 == 0) {
				answer = i + n3;
				break;
			}
		}

		System.out.println(answer);
	}
}
