import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        int[] dp = new int[k+1];
        dp[0] = 1;

        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }
        for(int j=0; j<n; j++){
            for(int i=1; i<k+1; i++){

                if(i < numbers[j]){
                    continue;
                }
                dp[i] += dp[i - numbers[j]];
            }
//            for (int i1 : dp) {
//                System.out.print(i1 + " ");
//            }
//            System.out.println("\n------------------------");
        }

        System.out.println(dp[k]);
    }

}