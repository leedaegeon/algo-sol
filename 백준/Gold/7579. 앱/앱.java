import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] values = new int[n+1];
        int[] cost = new int[n+1];
        int idx = 1;
        while(st.hasMoreTokens()){
            values[idx++] = Integer.parseInt(st.nextToken());
        }
        idx = 1;
        st = new StringTokenizer(br.readLine());
        int max = 0;
        while(st.hasMoreTokens()){
            cost[idx++] = Integer.parseInt(st.nextToken());
            max += cost[idx-1];
        }
        int [][] dp = new int[n+1][max+1];
        for(int i=1; i< n+1; i++){
            for(int j=0; j<max+1; j++){
                dp[i][j] = dp[i-1][j];
                if(cost[i] <= j){
                    dp[i][j] = Math.max(dp[i-1][j-cost[i]] + values[i], dp[i][j]);
                }

            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<n+1; i++){
            for(int j=0; j<max+1; j++){
                if(dp[i][j] >= m){
                    answer = Math.min(answer, j);
                }
            }
        }

        System.out.println(answer);
    }
}