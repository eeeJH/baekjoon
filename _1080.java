import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _1080 {

    int N, M, count;
    int[][] map, ret;

    public _1080() throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        ret = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                ret[i][j] = s.charAt(j) - '0';
            }
        }

        sol();

        System.out.println(compare() ? count : -1);
    }

    public void sol() {

        if (N < 3 || M < 3) {
            if (compare()) {
                count = 0;
            } else {
                count = -1;
            }
            return;
        }

        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (ret[i][j] != map[i][j]) {
                    count++;
                    cal(i, j);
                }
            }
        }
    }

    public boolean compare() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ret[i][j] != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public void cal( int y, int x) {
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }
    }
}
