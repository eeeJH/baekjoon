package baekjoon;

import java.util.*;

public class _14502 {

	public static class Virus {
		int x;
		int y;

		Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, result;
	static int[][] arr;
	static int[][] virusArr;
	static Queue<Virus> q;

	// ����� �ִ� ���� 3�� �� ��������
	// ���̷����� �����¿� ��� ����
	// ��ĭ�� 0, ���� 1, ���̷����� 2
	// ���� ������������ ���̷����� ����
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		result = 0;

		createWall(0);
		
		System.out.println(result);
		
		sc.close();
	}

	// �� ��� 3���� ����� ���� �Լ�
	// dfs
	public static void createWall(int cnt) {
		if (cnt == 3) {
			spreadVirus();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					createWall(cnt + 1);
					arr[i][j] = 0;
				}
			}
		}
	}

	// bfs
	public static void spreadVirus() {

		q = new LinkedList<Virus>();
		virusArr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				virusArr[i][j] = arr[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virusArr[i][j] == 2) {
					q.add(new Virus(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			// poll
			Virus virus = q.poll();

			// 4���� �����¿� ����
			for (int i = 0; i < 4; i++) {
				int newr = virus.x + dr[i];
				int newc = virus.y + dc[i];

				if (newr >= 0 && newc >= 0 && newr < N && newc < M) {
					if (virusArr[newr][newc] == 0) {
						virusArr[newr][newc] = 2;
						q.add(new Virus(newr, newc));
					}
				}
			}
		}
		
		countSafe(virusArr);
	}

	// �������� ������ ��
	public static void countSafe(int[][] map) {
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					count++;
				}
			}
		}

		result = Math.max(result, count);
	}

}
