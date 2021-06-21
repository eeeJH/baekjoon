package baekjoon;

public class _4673 {
	static int[] numbers = new int[10000];

	public static void main(String[] arg) {
		for(int n = 1; n <= 10000; n++) {
			if (numbers[n - 1] == 0) {
				sol(n);
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) {
				System.out.println(i + 1);
			}
		}
	}

	public static void sol(int n) {
		if (n > 10000) {
			return;
		}

		String s = String.valueOf(n);
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - '0';
		}

		if (sum + n <= 10000) {
			numbers[sum + n - 1]++;
		}
		sol(sum + n);
	}
}
