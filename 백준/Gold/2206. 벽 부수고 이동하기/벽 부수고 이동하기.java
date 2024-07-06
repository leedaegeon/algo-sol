import java.util.*;
import java.io.*;
public class Main {
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] field = new int[n][m];
        for(int i=0; i<n; i++){
            String[] row = br.readLine().split("");
            for(int j=0; j<m; j++){
                field[i][j] = Integer.parseInt(row[j]);
            }
        }
        Queue<Node> pq = new ArrayDeque<>();
        pq.offer(new Node(0, 0, 1, 1));

        int answer = Integer.MAX_VALUE;
        boolean[][][] visited = new boolean[n][m][2];


        while(!pq.isEmpty()){
            Node now = pq.poll();
//            System.out.println("현재: " + now);
            if(now.y == n-1 && now.x == m-1){
//                System.out.println(now.len);
                answer = Math.min(answer, now.len);
                continue;
            }

            for(int i=0; i<4; i++){
                int nexty = now.y + di[i];
                int nextx = now.x + dj[i];
                if(nexty<0 || nexty >= n || nextx < 0 || nextx >= m ){
                    continue;
                }
                if(field[nexty][nextx]==1 && now.cnt != 0){
                    pq.offer(new Node(nexty, nextx, now.cnt-1, now.len+1));
                    visited[nexty][nextx][1] = true;
                }else if(field[nexty][nextx] == 0){

                    if(now.cnt == 1 && !visited[nexty][nextx][0]){
                        visited[nexty][nextx][0] = true;
                        pq.offer(new Node(nexty, nextx, now.cnt, now.len+1));

                    }else if(now.cnt == 0 && !visited[nexty][nextx][1]){
                        visited[nexty][nextx][1] = true;
                        pq.offer(new Node(nexty, nextx, now.cnt, now.len+1));

                    }
                }

            }
        }
        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }
    static class Node {
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

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", cnt=" + cnt +
                    ", len=" + len +
                    '}';
        }
    }
}