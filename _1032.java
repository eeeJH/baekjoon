import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1032 {

    int N;
    String[] s;
    String ret = "";

    public _1032() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        s = new String[N];

        for (int i = 0; i < N; i++) {
            s[i] = br.readLine().trim();
        }

        for (int j = 0; j < s[0].length(); j++) {
            boolean f = false;
            char c = s[0].charAt(j);
            for (int i = 0; i < N; i++) {
                if (s[i].charAt(j) != c) {
                    ret += "?";
                    f = false;
                    break;
                } else {
                    f = true;
                }
            }
            if (f) {
                ret += c;
            }
        }

        System.out.println(ret);
    }
}
