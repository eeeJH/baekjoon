import java.io.*;
import java.util.*;

public class _2606 {

    int N, M, ret;
    int[][] map;
    boolean[] visited;

    public _2606() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());
        M = Integer.parseInt(br.readLine().trim());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        int a, b;
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }
        bfs();
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                ret++;
            }
        }
        System.out.println(ret - 1);
    }

    public void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.offer(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= N; i++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}
