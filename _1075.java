package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1075 {

	static int N, F;

	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		F = Integer.parseInt(br.readLine().trim());
		
		N = (N / 100) * 100;

		System.out.println(N);
		System.out.println(F);
		
		for (int i = 0; i < 100; i++) {
			int temp = N + i;
			System.out.println(temp);
			if (temp % F == 0) {
				if (i < 10) {
					if (i == 0) {
						System.out.println("00");
					} else {
						System.out.println("0" + i);
					}
				} else {
					System.out.println(i);
				}
				break;
			}
		}
	}
}
