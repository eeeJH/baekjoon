package baekjoon;

import java.util.*;

public class _10818 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			int number = sc.nextInt();
			
			min = number < min ? number : min;
			max = number > max ? number : max;
		}
		
		System.out.println(min + " " + max);

		sc.close();
	}
}