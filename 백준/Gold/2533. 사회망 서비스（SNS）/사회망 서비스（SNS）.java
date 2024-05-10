import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static int[][] dp;
    static List<List<Integer>> adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] friend = br.readLine().split(" ");
            int from = Integer.parseInt(friend[0]);
            int to = Integer.parseInt(friend[1]);

            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        dp = new int[n + 1][2];

        getChildDp(1, -1);

//        for (int i = 0; i < 2; i++) {
//            for (int j = 1; j < dp.length; j++) {
//                System.out.print(dp[j][i] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void getChildDp(int cur, int parent) {
//        System.out.println(cur);
        dp[cur][0] = 0;
        dp[cur][1] = 1;
        for (int child : adjList.get(cur)) {
            if(parent != child){
                getChildDp(child, cur);
                dp[cur][0] += dp[child][1];
                dp[cur][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }

    }

}