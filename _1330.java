package baekjoon;

import java.io.*;

public class _1330 {

	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numbers = br.readLine().split(" ");
		String answer = "";

		if (Integer.parseInt(numbers[0]) > Integer.parseInt(numbers[1])) {
			answer = ">";
		} else if (Integer.parseInt(numbers[0]) < Integer.parseInt(numbers[1])) {
			answer = "<";
		} else {
			answer = "=";
		}

		System.out.println(answer);

	}
}
