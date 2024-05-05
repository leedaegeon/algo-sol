import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
//         다익스트라 풀이시 인접리스트로 풀어야하는 문제!!
//         두 노드간 간선이 두 개 이상이기에 인접리스트로 풀이(1-2: 5, 1-2: 3 과 같은 입력값이 존재)
        List<List<Node>> adjList = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] r: road){
            adjList.get(r[0]).add(new Node(r[1], r[2]));
            adjList.get(r[1]).add(new Node(r[0], r[2]));
            
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, 987654321);
        dist[1] = 0;
        pq.offer(new Node(1, 0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int nowIdx = now.idx;
            
            for(Node next: adjList.get(nowIdx)){
                if(dist[next.idx] > next.cost + dist[nowIdx]){
                    dist[next.idx] = next.cost + dist[nowIdx];

                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        for(int a: dist){
            // System.out.println(a);
            if(a != 987654321 && a <= K){
                answer++;
            }
        }
        return answer;
    }
    class Node implements Comparable<Node>{
        int idx;
        int cost;
        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
}