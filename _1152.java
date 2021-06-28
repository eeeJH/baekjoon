package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1152 {
	public static void main(String[] arg) throws Exception {
		int empty = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().trim().split(" ");
		if (str[0].equals("")) {
			empty = -1;
		}
		System.out.print(str.length + empty);
	}
}
