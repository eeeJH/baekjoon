package baekjoon;

import java.util.*;

// 백트래킹
public class _14889 {

	static int N, result;
	static int arr[][] = new int[20][20];

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		ArrayList<Integer> aTeam = new ArrayList<>();
		ArrayList<Integer> bTeam = new ArrayList<>();

		sc.close();

		System.out.println(solution(0, aTeam, bTeam));
	}

	public static int solution(int index, ArrayList<Integer> firstTeam, ArrayList<Integer> secondTeam) {

		// 맞는 경우
		if (index == N) {
			if (firstTeam.size() != N / 2) {
				return -1;
			}
			if (secondTeam.size() != N / 2) {
				return -1;
			}

			int t1 = 0;
			int t2 = 0;

			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {

					if (i == j) {
						continue;
					}

					t1 += arr[firstTeam.get(i)][firstTeam.get(j)];
					t2 += arr[secondTeam.get(i)][secondTeam.get(j)];
				}
			}

			int gap = Math.abs(t1 - t2);

			return gap;
		}

		int ans = -1;
		firstTeam.add(index);
		int t1 = solution(index + 1, firstTeam, secondTeam);
		if (ans == -1 || (ans > t1 && t1 != -1)) {
			ans = t1;
		}
		firstTeam.remove(firstTeam.size() - 1);

		secondTeam.add(index);
		int t2 = solution(index + 1, firstTeam, secondTeam);
		if (ans == -1 || (ans > t2 && t2 != -1)) {
			ans = t2;
		}
		secondTeam.remove(secondTeam.size() - 1);
		
		return ans;
	}

}
