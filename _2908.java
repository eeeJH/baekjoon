package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2908 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;

		for (String val : br.readLine().split(" ")) {
			int temp = val.charAt(0) - '0' + (val.charAt(1) - '0') * 10 + (val.charAt(2) - '0') * 100;
			max = temp > max ? temp : max;
		}

		System.out.println(max);
	}
}
