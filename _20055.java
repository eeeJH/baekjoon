package baekjoon;

import java.util.*;

public class _20055 {

	// �������� 0�� ĭ�� ������ k�� �̻��̶�� ������ �����Ѵ�.
	// ��� : �� ��° �ܰ谡 ���� ���϶� ����Ǿ����� ����Ѵ�.

	static int n, k, count, result, poll_int;
	static int[] map;
	static boolean[] robot;
	static boolean poll_boolean;

	public static void main(String arg[]) {

		count = 0;
		result = 0;

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		map = new int[2 * n];
		robot = new boolean[2 * n];

		for (int i = 0; i < map.length; i++) {
			map[i] = sc.nextInt();
		}

		while (count < k) {
			count = 0;
			result++;

			// �����̾� ��Ʈ �� ĭ ȸ��
			int temp_int = 0;
			boolean temp_boolean = false;
			for (int i = 0; i < 2 * n; i++) {

				if (i == 2 * n - 1) {
					map[0] = poll_int;
					robot[0] = poll_boolean;
				} else {
					if (i == 0) {
						temp_int = map[i];
						temp_boolean = robot[i];
					} else {
						temp_int = poll_int;
						temp_boolean = poll_boolean;
					}

					poll_int = map[i + 1];
					map[i + 1] = temp_int;

					poll_boolean = robot[i + 1];
					robot[i + 1] = temp_boolean;
				}
			}

			if (robot[n - 1]) {
				robot[n - 1] = false;
			}

			// ���� ���� ��Ʈ�� �ö� �κ�����, ��Ʈ�� ȸ���ϴ� �������� �� ĭ �̵��� �� �ִٸ� �̵��Ѵ�.
			// ���� �̵��� �� ���ٸ� ������ �ִ´�.
			for (int i = n - 2; i > 0; i--) {

				if (robot[i] && !robot[i + 1] && map[i + 1] > 0) {
					robot[i + 1] = true;
					robot[i] = false;
					map[i + 1]--;
				}

			}

			if ((!robot[0] && map[0] != 0) || (robot[0] && map[0] != 0)) {
				robot[0] = true;
				map[0]--;
			}
			

			if (robot[n - 1]) {
				robot[n - 1] = false;
			}

			print();
			print1();

			for (int i = 0; i < map.length; i++) {
				if (map[i] == 0) {
					count++;
				}
			}
		}

		sc.close();

		System.out.println(result);
	}

	public static void print() {
		for (int i = 0; i < map.length; i++) {
			System.out.print(map[i] + " ");
		}
		System.out.println();
		System.out.println();
	}

	public static void print1() {
		for (int i = 0; i < robot.length; i++) {
			System.out.print(robot[i] + " ");
		}
		System.out.println();
		System.out.println();
	}

}
