package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _11021 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			String[] numbers = br.readLine().split(" ");
			bw.write("Case #" + i + ": " + (Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1])) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
