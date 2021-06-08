package code;

import java.util.*;

public class _20057 {

	static int n, q, l, r, c;
	static int[][] map;
	static int cal_l;
	static int[] magic;

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		q = sc.nextInt();

		r = (int) Math.pow(2, n);
		c = r;

		map = new int[r][c];

		for (int y = 0; y < r; y++) {
			for (int x = 0; x < c; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		magic = new int[q];

		for (int i = 0; i < q; i++) {
			magic[i] = sc.nextInt();
		}

		solve();

		sc.close();
	}

	public static void solve() {
		for (int i = 0; i < q; i++) {
			remake_MAP(1 << magic[i]);
			
			
		}
		
		
	}

	public static void remake_MAP(int Len) {
		for (int i = 0; i < r; i += Len) {

			for (int j = 0; j < c; j += Len) {
				System.out.println("i : " + + i + "  j : " + j + "  Len : " + Len);
				
				rotation(i, j, Len);
				
				print();
			}
		}
	}

	// 돌리기
	public static void rotation(int a, int b, int Len) {
		// 돌려야 하는 사각형의 갯수
		int SquareCount = Len / 2;
		
		
		for (int Number = 0; Number < SquareCount; Number++) {
			int Start_x = a + Number;
			int Start_y = b + Number;
			int End_x = a + Len - Number - 1;
			int End_y = b + Len - Number - 1;

			int x_Idx = End_x;
			int y_Idx = Start_y;
			int Idx = 0;

			LinkedList<Integer> temp = new LinkedList<Integer>();
			//Vector<Integer> temp = new Vector<Integer>();

			for (int i = Start_x; i < End_x; i++) {
				temp.add(map[i][Start_y]);
			}
			for (int i = Start_x; i < End_x; i++) {
				map[i][Start_y] = map[End_x][y_Idx++];
			}
			for (int i = Start_y; i < End_y; i++) {
				map[End_x][i] = map[x_Idx--][End_y];
			}
			for (int i = End_x; i > Start_x; i--) {
				map[i][End_y] = map[Start_x][y_Idx--];
			}
			for (int i = End_y; i > Start_y; i--) {
				map[Start_x][i] = temp.get(Idx++);
			}
		}
	}

	public static void print() {
		System.out.println();
		System.out.println();
		for (int y = 0; y < r; y++) {
			for (int x = 0; x < c; x++) {
				System.out.print(map[y][x]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

}
