package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class _1075 {

    static int N, F;

    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        F = Integer.parseInt(br.readLine().trim());

        if (N % F != 0) {

            N = (N / 100) * 100;

            for(int i = 0; i < 100; i++){
                N += i;
                if(N % F == 0){
                    if(i < 10){
                        if(i == 0){
                            System.out.println("00");
                        } else {
                            System.out.println("0" + i);
                        }
                    } else{
                        System.out.println(N % F);
                    }
                    break;
                }
            }
        } else {
            if(N % F == 0){
                if(N % F < 10){
                    if(N % F == 0){
                        System.out.println("00");
                    } else {
                        System.out.println("0" + N % F);
                    }
                } else{
                    System.out.println(N % F);
                }
            }
        }
    }
}
