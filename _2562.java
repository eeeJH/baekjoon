package baekjoon;

import java.io.*;

public class _2562 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int index = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < 9; i++) {
			int number = Integer.parseInt(br.readLine());
			if (number > max) {
				max = number;
				index = i + 1;
			}
		}
		bw.write(max + "\n" + index);
		bw.flush();
		bw.close();
	}
}
