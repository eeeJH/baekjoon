package baekjoon;

import java.io.*;

public class _2742 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for (int i = N; i >= 1; i--) {
			bw.write(i + "\n");
		}
        bw.flush();
        bw.close();
	}
}
