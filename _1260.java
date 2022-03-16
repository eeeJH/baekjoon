import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1260 {

    int N, M, V;
    int[][] map;
    boolean[] visited;
    String ret = "";

    public _1260() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        int a, b;
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(V);
        System.out.println();
        bfs(V);

    }

    public void dfs(int V) {
        Stack<Integer> s = new Stack<>();
        visited[V] = true;
        s.push(V);
        System.out.print(V + " ");

        while(!s.isEmpty()){
            for(int i = 1; i <= N; i++){
                if(map[V][i] == 1 && !visited[i]){
                    s.push(i);
                    visited[i] = true;
                    dfs(i);
                }
            }
            s.pop();
        }
    }

    public void bfs(int V) {
        visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[V] = true;
        q.offer(V);
        System.out.print(V + " ");

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= N; i++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

}
