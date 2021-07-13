package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _17142 {
	static class Point {
		int r, c, d;

		Point(int row, int col, int dist) {
			r = row;
			c = col;
			d = dist;
		}
	}

	// �ǹ̻� ���Ѵ� ���� ���� infinity
	static final int INF = 34290834;
	static int N, M;
	static int[][] Arr = new int[50][50];
	static Point[] Virus = new Point[10];
	static int VirusCnt;
	
	// row
	static int[] dr = { -1, 1, 0, 0 };
	// column
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		// �ʱ�ȭ �۾�
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Arr[i][j] = sc.nextInt();
				if (Arr[i][j] == 2) {
					// �������� ���� ���̷����� �ε���
					Virus[VirusCnt++] = new Point(i, j, 0);
				}

			}
			
			System.out.print(i);
		}
		
		
		
		sc.close();

		System.out.println(solve());
	}

	// ��Ʈ�� �κ�����
	// 0 0 { } ����.
	// 1 1 { 0 } 0 ����
	// 2 10 { 1 } 1 ����.
	// 3 11 { 0, 1 } 0, 1 ����.
	// 4 100 { 2 } 2 ����.
	// 5 101 { 0, 2 } 0, 2 ����.
	// 6 110 { 1, 2 } 1, 2 ����.
	// 7 111 { 0, 1, 2 } 0, 1, 2 ����.

	public static int countBits(int n) {
		int cnt = 0;

		while (n > 0) {
			// �� �����ʿ� �ִ� ��Ʈ�� Ȯ���ϱ� ���ؼ� & �����Ѵ�.
			if ((n & 1) == 1)
				++cnt;

			// ������ shift ���Ѽ� 1�� ��Ʈ�� ���� �ְ��Ѵ�.
			n = n >> 1;
		}
		
		return cnt;
	}

	public static int solve() {
		int ret = INF;

		// 1�� �������� shift ��Ű�鼭 ��� �κ������� ��Ÿ��
		for (int subset = 0; subset < 1 << VirusCnt; ++subset) {
			if (countBits(subset) == M) {

				boolean[][] visited = new boolean[50][50];
				int dist = 0;
				Queue<Point> myque = new LinkedList<Point>();

				for (int i = 0; i < VirusCnt; ++i) {
					if ((subset & 1 << i) != 0) {
						visited[Virus[i].r][Virus[i].c] = true;
						myque.add(Virus[i]);
					}
				}

				while (myque.size() != 0) {
					Point cur = myque.poll();

					// ���̷����� �ƴ� ��쿡�� ������Ʈ
					if (Arr[cur.r][cur.c] != 2) {
						// Ž���Ҷ����� �Ÿ� ����
						dist = Math.max(dist, cur.d);
					}

					// ��, ��, ��, �� 4�������� ����
					// ��, ��, ��, �� ��ǥ�� ������.
					for (int i = 0; i < 4; ++i) {
						int nr = cur.r + dr[i];
						int nc = cur.c + dc[i];

						// ������ ���� �ѱ��
						if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) {
							continue;
						}

						// ���̸�
						if (visited[nr][nc] || Arr[nr][nc] == 1) {
							continue;
						}

						visited[nr][nc] = true;
						myque.add(new Point(nr, nc, cur.d + 1));
					}
				}

				boolean flag = true;

				for (int i = 0; i < N; i++) {
					for(int j =0; j<N; j++) {
						if(Arr[i][j] == 0 && visited[i][j] == false) {
							flag = false;
						}
					}
				}
				
				if(flag) {
					ret = Math.min(ret, dist);
				}

			}
		}
		
		if(ret == INF) {
			return -1;
		}
		
		return ret;
	}
}
