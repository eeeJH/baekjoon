package baekjoon;

import java.io.*;

public class _2577 {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine())
				* Integer.parseInt(br.readLine());
		String num = String.valueOf(number);
		int[] count = new int[10];
		for (int i = 0; i < num.length(); i++) {
			count[num.charAt(i) - '0'] += 1;
		}

		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}

	}
}
