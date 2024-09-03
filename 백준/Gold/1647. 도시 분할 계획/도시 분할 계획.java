import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
//        String[] input = br.readLine().split("\\s+");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<m; i++){
//            input = br.readLine().split("\\s+");
            st = new StringTokenizer(br.readLine());
            Edge edge = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pq.offer(edge);
        }
        int[] parents = new int[n + 1];
        parents = makeParent(parents);

        int answer = 0;
        int maxCost = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            int parentA = findParent(now.left, parents);
            int parentB = findParent(now.right, parents);
            if (parentA == parentB) {
                continue;
            }
            parents = union(parentA, parentB, parents);
            maxCost = Math.max(maxCost, now.cost);
            answer += now.cost;
        }

        answer -= maxCost;
        System.out.println(answer);
    }
    public static int findParent(int child, int[] parents){
        if(child == parents[child]){
            return child;
        }
        return parents[child] = findParent(parents[child], parents);
    }

    public static int[] union(int parentA, int parentB, int[] parents) {
        
        if (parentA <= parentB) {
            parents[parentB] = parentA;
        }else{
            parents[parentA] = parentB;
        }
        return parents;
    }
    public static int[] makeParent(int[] parent){
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        return parent;
    }

    static class Edge implements Comparable<Edge>{
        int left;
        int right;
        int cost;
        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }

        public Edge(int left, int right, int cost) {
            this.left = left;
            this.right = right;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "left=" + left +
                    ", right=" + right +
                    ", cost=" + cost +
                    '}';
        }
    }
}