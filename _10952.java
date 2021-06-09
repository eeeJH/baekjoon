package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10952 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		while ((s = br.readLine()) != null) {
			String[] numbers = s.split(" ");
			bw.write((Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1])) + "\n");
		}
		bw.flush();
		bw.close();
	}
}