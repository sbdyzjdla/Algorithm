import java.io.*;
import java.util.*;

public class Main {

    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        /*
            DP문제(메모이제이션)
            시간초과가 뜨기때문에 Sout 반복대신 StringBuilder와 BufferedReader 사용
         */
        dp[0][0] = 1;   //0일때 0은 1번출력
        dp[0][1] = 0;   //0일때 1은 0번출력
        dp[1][0] = 0;
        dp[1][1] = 1;

        //Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; ++i) {
            int T = Integer.parseInt(br.readLine());
            fibonaci(T);
            sb.append(dp[T][0] + " " + dp[T][1] + "\n");
        }
        System.out.println(sb);
    }

    public static Integer[] fibonaci(int n) {
        if(dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] =  fibonaci(n-1)[0] + fibonaci(n-2)[0];
            dp[n][1] =  fibonaci(n-1)[1] + fibonaci(n-2)[1];
        }
        return dp[n];
    }
}
