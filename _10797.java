package baekjoon;

import java.util.Scanner;

public class _10797 {

	static int n, result = 0;

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int y = 0; y < 5; y++) {
			String[] temp = Integer.toString(sc.nextInt()).split("");
			int num = Integer.parseInt(temp[temp.length - 1]);
			
			if (n == num) {
				result++;
			}
		}

		System.out.println(result);

		sc.close();
	}
}
