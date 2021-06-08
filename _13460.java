package code;

import java.io.*;
import java.util.*;

public class _13460 {

	static int MAX_TRY = 10;
	static int n, m;
	static char[][] map = new char[10][10];

	public static class Info {
		int rx, ry, bx, by, count;
	}

	static Info start = new Info();

	public static void main(String arg[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		String st = "";

		for (int y = 0; y < n; y++) {
			st = sc.next();
			for (int x = 0; x < m; x++) {
				map[y][x] = st.charAt(x);
				if (map[y][x] == 'R') {
					start.ry = y;
					start.rx = x;
				}
				if (map[y][x] == 'B') {
					start.by = y;
					start.bx = x;
				}
			}
		}

		start.count = 0;

		int ret = bfs();
		System.out.println(ret);

		sc.close();
	}

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	public static int bfs() {
		
		int[][][][] visited = new int[10][10][10][10];
		Queue<Info> q = new LinkedList<>();
		q.offer(start);
		visited[start.ry][start.rx][start.by][start.bx] = 1;

		int ret = -1;
		while (!q.isEmpty()) {
			

			Info cur = q.poll();

			if (cur.count > MAX_TRY) {

				break;
			}

			if (map[cur.ry][cur.rx] == 'O' && map[cur.by][cur.bx] != 'O') {
				ret = cur.count;
				break;
			}

			for (int dir = 0; dir < 4; dir++) {
				int next_ry = cur.ry;
				int next_rx = cur.rx;
				int next_by = cur.by;
				int next_bx = cur.bx;

				// 빨간공을 기울일때의 과정
				while (true) {
					if (map[next_ry][next_rx] != '#' && map[next_ry][next_rx] != 'O') {
						next_ry += dy[dir];
						next_rx += dx[dir];
					} else {
						if (map[next_ry][next_rx] == '#') {
							next_ry -= dy[dir];
							next_rx -= dx[dir];
						}
						break;
					}
				}

				// 파란공을 기울일때의 과정
				while (true) {
					if (map[next_by][next_bx] != '#' && map[next_by][next_bx] != 'O') {
						next_by += dy[dir];
						next_bx += dx[dir];
					} else {
						if (map[next_by][next_bx] == '#') {
							next_by -= dy[dir];
							next_bx -= dx[dir];
						}
						break;
					}
				}

				// 한칸에 두개의 공이 존재할때
				// 구멍이 아닌 경우만 처리해주면 된다.
				// 구멍이면 두개다 빠져서 처리 ㄴ
				// 구멍이 아니면 두개의 공이 같은 위치에 있으면 안되서 예외처리해준다.
				if (next_rx == next_bx && next_ry == next_by) {

					if (map[next_ry][next_rx] != 'O') {
						int red_dist = Math.abs(next_rx - cur.rx) + Math.abs(next_ry - cur.ry);
						int blue_dist = Math.abs(next_bx - cur.bx) + Math.abs(next_by - cur.by);

						if (red_dist > blue_dist) {
							next_rx -= dx[dir];
							next_ry -= dy[dir];
						} else {
							next_bx -= dx[dir];
							next_by -= dy[dir];
						}
					}
				}

				if (visited[next_ry][next_rx][next_by][next_bx] == 0) {
					visited[next_ry][next_rx][next_by][next_bx] = 1;
					Info next = new Info();

					next.rx = next_rx;
					next.ry = next_ry;
					next.bx = next_bx;
					next.by = next_by;

					next.count = cur.count + 1;
					q.offer(next);
				}

			}

		}

		return ret;
	}
}
