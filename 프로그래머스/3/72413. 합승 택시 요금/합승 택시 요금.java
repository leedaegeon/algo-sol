import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
//         200 x 200이어서 그냥 인접배열 씀
        int[][] adjMat = new int[n+1][n+1];
        for(int i=0; i<fares.length; i++){
            adjMat[fares[i][0]][fares[i][1]] = fares[i][2];
            adjMat[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        List<Node> als = new LinkedList<>();
        List<Node> bls = new LinkedList<>();
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, 987654321);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.offer(new Node(s,0));
        dist[s] = 0;
        boolean[] visited = new boolean[n+1];
        int cnt = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.num]){
               continue; 
            }
            visited[now.num] = true;
                        
            for(int i=1; i<adjMat[now.num].length; i++){
                if(adjMat[now.num][i] != 0){
                    if(dist[i] > now.weight + adjMat[now.num][i]){
                        dist[i] = now.weight + adjMat[now.num][i];
                        pq.offer(new Node(i, dist[i]));
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        
        for(int i=1; i<n+1; i++){             
            
            pq = new PriorityQueue<>();
            
            int[] subDist = new int[n+1];
            Arrays.fill(subDist, 987654321);
            subDist[i] = dist[i];         
            
            pq.offer(new Node(i, subDist[i]));
            
            visited = new boolean[n+1];
            while(!pq.isEmpty()){
                Node now = pq.poll();
                if(visited[now.num]){
                    continue;
                }
                visited[now.num] = true;
                
                for(int j=1; j<adjMat[now.num].length; j++){
                    if(adjMat[now.num][j] != 0){
                        if(subDist[j] > now.weight + adjMat[now.num][j]){
                            subDist[j] = now.weight + adjMat[now.num][j];
                            pq.offer(new Node(j, subDist[j]));
                        }
                    }
                }
            }
            min = Math.min(min, subDist[a] + subDist[b] - dist[i]);
        }
        
        answer = min;
        return answer;
    }
    
    class Node implements Comparable<Node>{
        int num;
        int weight;
        Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
        @Override
        public String toString(){
            return this.num + " " + this.weight;
        }
    }
}