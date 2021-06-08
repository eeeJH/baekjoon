package baekjoon;

import java.util.*;

public class _16948 {

	static class Point {
		int y, x, dist;

		Point(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}

	static int[] dy = { -2, -2, 0, 0, 2, 2 };
	static int[] dx = { -1, 1, -2, 2, -1, 1 };

	static int n, start_x, start_y, end_x, end_y;
	static int[][] map;
	static Point start;

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];

		start_y = sc.nextInt();
		start_x = sc.nextInt();
		end_y = sc.nextInt();
		end_x = sc.nextInt();

		start = new Point(start_y, start_x, 0);

		System.out.println(bfs(start));

		sc.close();
	}

	public static int bfs(Point point) {
		boolean[][] visited = new boolean[n][n];

		Queue<Point> q = new LinkedList<Point>();
		visited[point.y][point.x] = true;
		q.offer(point);

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (cur.x == end_x && cur.y == end_y) {
				return cur.dist;
			}

			for (int i = 0; i < 6; i++) {
				int newY = cur.y + dy[i];
				int newX = cur.x + dx[i];

				if (newY > n-1 || newX > n-1 || newY < 0 || newX < 0) {
					continue;
				}

				if (visited[newY][newX]) {
					continue;
				}

				visited[newY][newX] = true;

				q.offer(new Point(newY, newX, cur.dist + 1));
			}

		}

		return -1;
	}
}
