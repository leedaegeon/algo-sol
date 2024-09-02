import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited;
    static int[] subtreeSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int n, r, q;
        n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        q = Integer.parseInt(input[2]);
        visited = new boolean[n + 1];

        List<List<Integer>> adjMat = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            adjMat.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++){
            input = br.readLine().split("\\s+");
            int parent = Integer.parseInt(input[0]);
            int child = Integer.parseInt(input[1]);
            adjMat.get(parent).add(child);
            adjMat.get(child).add(parent);
        }
        List<Integer> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int queryRoot = Integer.parseInt(br.readLine());
            queries.add(queryRoot);
        }


        subtreeSize = new int[n+1];
        getSubtreeSize(adjMat, r);
        StringBuilder sb = new StringBuilder();
        for(int query: queries){
            sb.append(subtreeSize[query]).append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static int getSubtreeSize(List<List<Integer>> adjMat, int root) {
        visited[root] = true;
        subtreeSize[root] += 1;
        for (int child : adjMat.get(root)) {
            if(!visited[child]) {
                subtreeSize[root] += getSubtreeSize(adjMat, child);
            }
        }
        return subtreeSize[root];
    }

}