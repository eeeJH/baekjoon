package code;

import java.util.*;

public class _16236 {

	static int N;
	static int[][] arr = new int[20][20];
	static int size, eat;
	static babyShark bs = new babyShark();
	
	// 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class babyShark {
		int x;
		int y;
		int time;
	}

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();

				// 아기 상어 위치
				if (arr[i][j] == 9) {
					bs.x = i;
					bs.y = j;
					bs.time = 0;
					size = 2;
					eat = 0;
					arr[i][j] = 0;
				}
			}
		}

		boolean is_update = true;
		while (is_update) {
			is_update = false;

			boolean[][] visited = new boolean[20][20];
						
			Queue<babyShark> q = new LinkedList<>();
			visited[bs.x][bs.y] = true;
			q.offer(bs);

			// 아기상어가 먹을 수 있는 물고기가 여러마리가 나올수 있다.
			// 그 중에서 한마리를 먹기 때문에 그 정보를 저장하기 위해서 아래와 같이 선언
			babyShark candi = new babyShark();
			// x 값이 가장 큰값을 정해줘야 그것보다 작은 값을 먹을 것이다.
			candi.x = 20;
			candi.time = -1;

			while (!q.isEmpty()) {
				babyShark cur = q.poll();

				// candi.tiem 이 -1이 라는 말은 갱신이 안되었다.
				// 가장 가까운 물고기는 이미 먹었다는 조건문
				// 그래서 탈출
				if (candi.time != -1 && candi.time < cur.time) {
					break;
				}

				// arr[cur.x][cur.y] < size      물고기보다 사이즈가 크고 
				// arr[cur.x][cur.y] != 0              물고기가 있으면
				// 갱신하자.
				if (arr[cur.x][cur.y] < size && arr[cur.x][cur.y] != 0) {
					is_update = true;

					// 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
					if (candi.x > cur.x || (candi.x == cur.x && candi.y > cur.y)) {
						candi = cur;
					}
				}

				for (int dir = 0; dir < 4; dir++) {

					babyShark next = new babyShark();
					next.x = cur.x + dx[dir];
					next.y = cur.y + dy[dir];
					next.time = cur.time + 1;

					if (next.x < 0 || next.x >= N || next.y < 0 || next.y >= N) {
						continue;
					}
					
					if(!visited[next.x][next.y] && size >= arr[next.x][next.y]) {
						visited[next.x][next.y] = true;
						q.add(next);
					}
				}

			}
			
			if(is_update) {
				bs = candi;
				eat++;
				if(eat == size) {
					size++;
					eat = 0;
				}
				arr[bs.x][bs.y] = 0;
			}

		}
		
		

		// 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력
		System.out.println(bs.time);

		sc.close();
	}

}
