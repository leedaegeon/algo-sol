import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//import java.util.ArrayDeque;
//import java.util.StringTokenizer;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        short[][] adj = new short[n][n];
        short[][] visited = new short[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adj[i][j] = Short.parseShort(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(adj[i][j] == 1){
                    visited = dfs(adj, visited, i, j, i);
                }
            }
        }
        for (short[] shorts : visited) {

            for (short aShort : shorts) {
                System.out.print(aShort + " ");
            }
            System.out.println();
        }

    }

    static short[][] dfs(short[][] adj, short[][] visited, int y, int x, int origin){
        if(visited[origin][x] == 1){
            return visited;
        }

        visited[origin][x] = 1;
        for(int i=0; i<adj[x].length; i++){
            if(adj[x][i] == 1){
                visited = dfs(adj, visited, x, i, origin);
            }
        }

        return visited;
    }

}