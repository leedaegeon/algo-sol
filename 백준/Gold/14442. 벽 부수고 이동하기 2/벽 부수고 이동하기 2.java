import java.util.*;
import java.io.*;
public class Main {
    //상 우 하 좌
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int[][] field = new int[n][m];
        for(int i=0; i<n; i++){
            String inputStr = br.readLine();
//            input = br.readLine().split("");
//            for(int j=0; j<m; j++){
//                field[i][j] = Integer.parseInt(input[j]);
//            }
            for(int j=0; j<inputStr.length(); j++){
                field[i][j] = inputStr.charAt(j) - '0';
            }
        }
        boolean [][][] visited = new boolean[n][m][k+1];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, k, 1));
        visited[0][0][k] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.y == n-1 && now.x == m-1){
                System.out.println(now.len);
                return;
            }
            for(int i=0; i<4; i++){
                int nexty = now.y + di[i];
                int nextx = now.x + dj[i];
                if(nexty < 0 || nexty >= n || nextx < 0 || nextx >= m){
                    continue;
                }
//                벽 부수고 방문
                if(field[nexty][nextx] == 1 && now.cnt>0 && !visited[nexty][nextx][now.cnt-1]){
                    q.offer(new Node(nexty, nextx, now.cnt-1, now.len+1));
                    visited[nexty][nextx][now.cnt-1] = true;
                }else if(field[nexty][nextx] == 0 && !visited[nexty][nextx][now.cnt]){
                    q.offer(new Node(nexty, nextx, now.cnt, now.len+1));
                    visited[nexty][nextx][now.cnt] = true;
                }
            }
        }
        System.out.println(-1);
    }
    static class Node{
        int y;
        int x;
        int cnt;
        int len;
        Node(int y, int x, int cnt, int len){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.len = len;
        }

    }
}