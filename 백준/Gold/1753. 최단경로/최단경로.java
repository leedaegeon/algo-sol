import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        List<List<Node>> g = new ArrayList<>();
        for(int i=0; i<v; i++){
            g.add(new ArrayList<>());
        }
        int start = Integer.parseInt(br.readLine())-1;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < e; i++) {
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]) - 1;
            int to = Integer.parseInt(input[1]) - 1;
            int w = Integer.parseInt(input[2]);
            g.get(from).add(new Node(to, w));
//            g.get(to).add(new Node(from, w));
        }

        // 시작 노드에서 출발하는 간선이 있는 경우에만 우선순위 큐에 추가


        int[] dist = new int[v];
        Arrays.fill(dist, 987654321);
        pq.offer(new Node(start, 0));

        dist[start] = 0;
        boolean[] visited = new boolean[v];

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.number]) {
                continue;
            }
            visited[now.number] = true;
            if(dist[now.number] < now.weight){
                continue;
            }
            for (Node next : g.get(now.number)) {
                if(dist[next.number] >  dist[now.number] + next.weight){
                    dist[next.number] = dist[now.number] + next.weight;
                    pq.offer(new Node(next.number, dist[next.number]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int d: dist){
            if(d == 987654321){
//                System.out.println("INF");
                sb.append("INF\n");
            }else {
//                System.out.println(d);
                sb.append(d+"\n");
            }
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb.toString());
    }
    static class Node implements Comparable<Node>{
        int number;
        int weight;
        Node(int number, int weight){
            this.number = number;
            this.weight = weight;
        }
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
}