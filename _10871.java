package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10871 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int X = Integer.parseInt(s[1]);
		String[] numbers = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			if(Integer.parseInt(numbers[i]) < X) {
				bw.write(numbers[i] + " ");
			}
		}
		bw.flush();
		bw.close();
	}
}
