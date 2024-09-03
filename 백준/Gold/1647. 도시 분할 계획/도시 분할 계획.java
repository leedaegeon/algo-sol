import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);


        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<m; i++){
            input = br.readLine().split("\\s+");
            Edge edge = new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            pq.offer(edge);
        }
        int[] parents = new int[n + 1];
        parents = makeParent(parents);

        List<Integer> costs = new ArrayList<>();
        int answer = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            int parentA = findParent(now.left, parents);
            int parentB = findParent(now.right, parents);
            if (parentA == parentB) {
                continue;
            }
            parents = union(parentA, parentB, parents);

            costs.add(now.cost);
            answer += now.cost;
        }

        costs.sort((o1, o2) -> o2 - o1);
//        System.out.println(costs);
//        System.out.println(minimumSpanningTree);
//        System.out.println(Arrays.toString(parents));
        answer -= costs.get(0);
        System.out.println(answer);
    }
    public static int findParent(int child, int[] parents){
        if(child == parents[child]){
            return child;
        }
        return parents[child] = findParent(parents[child], parents);
    }

    public static int[] union(int parentA, int parentB, int[] parents) {
//        int parentA = findParent(a, parents);
//        int parentB = findParent(b, parents);

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