package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2869 {
	
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int A = Integer.parseInt(str[0]);
		int B = Integer.parseInt(str[1]);
		int V = Integer.parseInt(str[2]);
		int day = (V - A) / (A - B) + 1;
		day = (V - A) % (A - B) == 0 ? day : day + 1;
		
		System.out.println(day);
	}
}
