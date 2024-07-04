import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split("\\s+");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] field = new int[m][n];
        for(int i=0; i<m; i++){
            String[] row = br.readLine().split("");
            for(int j=0; j<n; j++){
                field[i][j] = Integer.parseInt(row[j]);
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<Node> visited = new HashSet<>();

        pq.offer(new Node(0, 0, 0));
        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(now.y == m-1 && now.x == n-1){
                System.out.println(now.cnt);
                break;
            }
            if(!visited.add(now)){
                continue;
            }
            for(int i=0; i<4; i++){
                int nexty = now.y + di[i];
                int nextx = now.x + dj[i];
                if(nexty < 0 || nexty >= m || nextx < 0 || nextx >= n){
                    continue;
                }
                if(field[nexty][nextx] == 1){
                    pq.offer(new Node(nexty, nextx, now.cnt+1));
                }else{
                    pq.offer(new Node(nexty, nextx, now.cnt));
                }
            }
        }
    }
    static class Node implements Comparable<Node>{
        int y;
        int x;
        int cnt;
        Node(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
        public int compareTo(Node n){
            return this.cnt - n.cnt;
        }

        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(o == null || this.getClass() != o.getClass()){
                return false;
            }
            Node n = (Node)o;
            if(this.y == n.y && this.x == n.x ){
                return true;
            }
            return false;
        }
        public int hashCode(){
            return Objects.hash(this.y, this.x);
        }

    }
}