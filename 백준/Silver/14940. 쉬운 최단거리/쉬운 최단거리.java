import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n,m;
    static int[][] field;
    static Set<Cord> visited = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Cord start = null;
        field = new int[n + 2][m + 2];
        Arrays.fill(field[0], 0);
        Arrays.fill(field[n+1], 0);
        for(int i=0; i<n+2; i++){
            field[i][0] = 0;
            field[i][m+1] = 0;
        }
        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<m+1; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
                if(field[i][j] == 2){
                    start = new Cord(i, j, 0);
                }
            }
        }
        int[][] dist = new int[n + 2][m + 2];       // dest에서 i,j까지 가는데 필요한 최소비용
        for(int i=0; i<n+2; i++){
            Arrays.fill(dist[i], 987654321);
        }
        Queue<Cord> q = new ArrayDeque<>();
        q.add(start);
        visited.add(start);
        dist[start.y][start.x] = 0;

        while (!q.isEmpty()) {
            Cord now = q.poll();

            for(int i=0; i<4; i++){
                int nexty = now.y + dy[i];
                int nextx = now.x + dx[i];
                Cord next = new Cord(nexty, nextx);
                if (field[nexty][nextx] == 0 || visited.contains(next)) {
                    continue;
                }
//                start~next > start~now 비용 + now~next 비용
                if (dist[next.y][next.x] > now.cost + 1) {
                    dist[next.y][next.x] = now.cost + 1;
                    visited.add(next);
                    q.add(new Cord(nexty, nextx, now.cost+1));
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1 ; j++){
                if(dist[i][j] == 987654321){
                    if(field[i][j] == 0){
                        System.out.print(0 + " ");
                    }else if(field[i][j] == 1){
                        System.out.print(-1 + " ");
                    }
                }else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    static class Cord {
        int y;
        int x;
        int cost;
        Cord(int y, int x, int cost){
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
        Cord(int y, int x){
            this.y = y;
            this.x = x;
        }

        public boolean eqauls(Object o){
            if(this == o) return true;
            if(o==null || this.getClass() != o.getClass()) return false;
            Cord cord = (Cord) o;
            return y == cord.y && x == cord.x;
        }
        public int hashCode(){
            return Objects.hash(y, x);
        }
    }
}