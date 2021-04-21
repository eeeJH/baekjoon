package code;

import java.util.*;

public class _16236 {

	static int N;
	static int[][] arr = new int[20][20];
	static int size, eat;
	static babyShark bs = new babyShark();
	
	// �� �� �� ��
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

				// �Ʊ� ��� ��ġ
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

			// �Ʊ�� ���� �� �ִ� ����Ⱑ ���������� ���ü� �ִ�.
			// �� �߿��� �Ѹ����� �Ա� ������ �� ������ �����ϱ� ���ؼ� �Ʒ��� ���� ����
			babyShark candi = new babyShark();
			// x ���� ���� ū���� ������� �װͺ��� ���� ���� ���� ���̴�.
			candi.x = 20;
			candi.time = -1;

			while (!q.isEmpty()) {
				babyShark cur = q.poll();

				// candi.tiem �� -1�� ��� ���� ������ �ȵǾ���.
				// ���� ����� ������ �̹� �Ծ��ٴ� ���ǹ�
				// �׷��� Ż��
				if (candi.time != -1 && candi.time < cur.time) {
					break;
				}

				// arr[cur.x][cur.y] < size      ����⺸�� ����� ũ�� 
				// arr[cur.x][cur.y] != 0              ����Ⱑ ������
				// ��������.
				if (arr[cur.x][cur.y] < size && arr[cur.x][cur.y] != 0) {
					is_update = true;

					// �Ÿ��� ����� ����Ⱑ ���ٸ�, ���� ���� �ִ� �����, �׷��� ����Ⱑ �����������, ���� ���ʿ� �ִ� ����⸦ �Դ´�.
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
		
		

		// �Ʊ� �� ���� ���� ������ ��û���� �ʰ� ����⸦ ��Ƹ��� �� �ִ� �ð��� ���
		System.out.println(bs.time);

		sc.close();
	}

}
