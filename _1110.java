package baekjoon;

import java.io.*;

public class _1110 {

	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int k = n;
		int ret = 0;

		 do {

			ret++;

            n = (n % 10) * 10 + (n / 10 + n % 10) % 10;
             
		} while (k != n);
		 
		 System.out.println(ret);

	}
}
