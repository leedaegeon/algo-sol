import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> adjLs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        adjLs = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjLs.add(new ArrayList<>());
        }
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjLs.get(start).add(new Node(start, end, weight));
            adjLs.get(end).add(new Node(end, start, weight));
        }
        String[] nodeStr = br.readLine().split("\\s+");
        int[] nodes = new int[2];
        nodes[0] = Integer.parseInt(nodeStr[0]);
        nodes[1] = Integer.parseInt(nodeStr[1]);

        int start1 = shortestPath(n, 1, nodes[0], nodes);
        int first = shortestPath(n, nodes[0], nodes[1], nodes);
        int end1 = shortestPath(n, nodes[1], n, nodes);

        int start2 = shortestPath(n, 1, nodes[1], nodes);
        int second = shortestPath(n, nodes[1], nodes[0], nodes);
        int end2 = shortestPath(n, nodes[0], n, nodes);
//        System.out.println(start1 + " " + first  +" " + end1);

//        System.out.println(start2 + " " + second  +" " + end2);
        boolean flag1 = true;
        if(start1 == -1 || first == -1 || end1 == -1){
            flag1 = false;
        }
        boolean flag2 = true;
        if(start2 == -1 || second == -1 || end2 == -1){
            flag2 = false;
        }

        int val1 = start1 + first + end1;
        int val2 = start2 + second + end2;

        if(!flag1 && !flag2){
            System.out.println(-1);
        }else if(!flag1){
            System.out.println(val2);

        }
        else if(!flag2){
            System.out.println(val1);
        }
        else if(val1 > val2){
            System.out.println(val2);
        }else{
            System.out.println(val1);
        }
    }
    public static int shortestPath(int n, int start, int target, int[]nodes){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] dist = new int[n+1];
        Arrays.fill(dist, 987654321);
        dist[start] = 0;
        pq.offer(new Node(start, 0, 0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.start == target){
                return dist[target];
            }
//            System.out.println(now.start);
            for(Node next: adjLs.get(now.start)){
                if(dist[next.end] > next.weight + dist[now.start]){
                    dist[next.end] = next.weight + dist[now.start];
                    pq.offer(new Node(next.end, 0, dist[next.end]));
                }

            }
        }
        return -1;
    }
    static class Node implements Comparable<Node>{
            int start;
            int end;
            int weight;
            Node(int start, int end, int weight){
                this.start = start;
                this.end = end;
                this.weight = weight;
            }
            public int compareTo(Node n){
                return this.weight - n.weight;
            }
    }
}