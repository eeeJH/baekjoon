package code;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

/* @date: 2021/04/20
 * @author: eeeJH
 * @SWEA__View (D3) */

// ���� ����� �������� �޸� ���������...
// �׷��� ����� fail
// Runtime Error
// Error Message: Memory error occured, (e.g. segmentation error, memory limit Exceed, stack overflow,... etc)
// ��� �ذ��ؾ��ұ�



class _view {

	static int n, count;
	static int[] building;
	static int[] arr = new int[4];

	public static void main(String args[]) throws Exception {
		
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			n = sc.nextInt();
			count = 0;
			building = new int[n];

			for (int i = 0; i < n; i++) {
				building[i] = sc.nextInt();
			}

			// ó�� �ΰ��� ���� �� ���� ����
			for (int i = 2; i < n - 2; i++) {
				if (building[i] > building[i - 2] && building[i] > building[i + 2] && building[i] > building[i - 1]
						&& building[i] > building[i + 1]) {

					arr[0] = building[i - 2];
					arr[1] = building[i - 1];
					arr[2] = building[i + 1];
					arr[3] = building[i + 2];

					Arrays.sort(arr);

					count += building[i] - arr[3];
				}
			}

			System.out.println("#" + test_case + " " + count);
		}
		
		sc.close();
	}
}