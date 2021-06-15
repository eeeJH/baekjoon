package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _3052 {

	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] mod_42 = new int[42];
		String str = "";
		int ret = 0;
		while ((str = br.readLine()) != null) {
			int n = Integer.parseInt(str);
			mod_42[n % 42]++;
		}

		for (int i = 0; i < mod_42.length; i++) {
			if (mod_42[i] != 0) {
				ret++;
			}
		}
		System.out.println(ret);
	}

}
