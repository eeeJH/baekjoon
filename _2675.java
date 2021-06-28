package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2675 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			String[] str = br.readLine().split(" ");
			int R = Integer.parseInt(str[0]);
			String[] S = str[1].split("");
			for (int i = 0; i < S.length; i++) {
				for (int j = 0; j < R; j++) {
					bw.write(S[i]);
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
