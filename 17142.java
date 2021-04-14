package code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Bit를 이용한 부분집합
// 완전 탐색(Exhaustive Search, Brute Force)
// 2차원 배열의 너비우선탐색(BFS)
public class _17142 {
	static class Point {
		int r, c, d;

		Point(int row, int col, int dist) {
			r = row;
			c = col;
			d = dist;
		}
	}

	// 의미상 무한대 숫자 선정 infinity
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

		// 초기화 작업
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Arr[i][j] = sc.nextInt();
				if (Arr[i][j] == 2) {
					// 다음으로 들어가는 바이러스의 인덱스
					Virus[VirusCnt++] = new Point(i, j, 0);
				}

			}
		}

		System.out.println(solve());
	}

	// 비트로 부분집합
	// 0 0 { } 없음.
	// 1 1 { 0 } 0 있음
	// 2 10 { 1 } 1 있음.
	// 3 11 { 0, 1 } 0, 1 있음.
	// 4 100 { 2 } 2 있음.
	// 5 101 { 0, 2 } 0, 2 있음.
	// 6 110 { 1, 2 } 1, 2 있음.
	// 7 111 { 0, 1, 2 } 0, 1, 2 있음.

	public static int countBits(int n) {
		int cnt = 0;

		while (n > 0) {
			// 맨 오른쪽에 있는 비트를 확인하기 위해서 & 연산한다.
			if ((n & 1) == 1)
				++cnt;

			// 오른쪽 shift 시켜서 1인 비트를 셀수 있게한다.
			n = n >> 1;
		}
		
		return cnt;
	}

	public static int solve() {
		int ret = INF;

		// 1을 왼쪽으로 shift 시키면서 모든 부분집합을 나타냄
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

					// 바이러스가 아닌 경우에만 업데이트
					if (Arr[cur.r][cur.c] != 2) {
						// 탐색할때마다 거리 증가
						dist = Math.max(dist, cur.d);
					}

					// 상, 하, 좌, 우 4방향으로 진행
					// 상, 하, 좌, 우 좌표를 만들자.
					for (int i = 0; i < 4; ++i) {
						int nr = cur.r + dr[i];
						int nc = cur.c + dc[i];

						// 지정된 값을 넘기면
						if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) {
							continue;
						}

						// 벽이면
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
