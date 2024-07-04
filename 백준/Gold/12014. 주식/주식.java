import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int m=1;
        while(t>0){
            t--;
            int n;
            int k;
            boolean flag = false;
            String[] nk = br.readLine().split("\\s+");
            n = Integer.parseInt(nk[0]);
            k = Integer.parseInt(nk[1]);
            String[] stockStr = br.readLine().split("\\s+");
            int[] stockArr = new int[n];
            int iter=0;
            for(String s: stockStr){
                stockArr[iter++] = Integer.parseInt(s);
            }
//            System.out.println(Arrays.toString(stockArr));
            System.out.println("Case #" + m );
            m++;
            int[] dp = new int[n];
            dp[0] = 1;
            int maxLen = 0;
            for(int i=1; i<n; i++){
                for(int j=0; j<i; j++){
                    if(stockArr[i] > stockArr[j]){
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                dp[i] += 1;
                maxLen = Math.max(maxLen, dp[i]);
                
            }
            for(int i: dp) {
                if (i == k) {
                    System.out.println(1);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println(0);
            }
//            System.out.println(Arrays.toString(dp));

        }
    }
}