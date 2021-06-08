package baekjoon;

import java.io.*;
import java.util.*;

public class _2884 {

	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int hour = Integer.parseInt(st.nextToken()) + 24;
        int minute = Integer.parseInt(st.nextToken()) + 15;
		
		if (minute < 60) {
			hour--;
		} else if (minute == 60) {
			minute = 0;
		} else {
			minute -= 60;
		}
		
		hour = hour >= 24 ? hour - 24 : hour;

		System.out.println(hour + " " + minute);

	}

}
