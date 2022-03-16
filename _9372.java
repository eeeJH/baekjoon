import java.io.*;
import java.util.*;

public class _9372 {

    int T, N, M, ret;
    int[][] map;
    boolean[] visited;

    public _9372() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N + 1][N + 1];
            visited = new boolean[N + 1];
            ret = 0;

            int a, b;
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                map[a][b] = 1;
                map[b][a] = 1;
            }
            bfs();
            System.out.println(ret - 1);
        }
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            ret++;
            int cur = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (map[cur][i] <= 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
