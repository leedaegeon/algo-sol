import java.util.*;
class Solution {
    static List<List<Integer>> graph = new LinkedList<>();
    static int answer = 0;
    
    public int solution(int n, int[][] edge) {
        Arrays.sort(edge, (o1, o2) ->{
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0];
            }
        });
        for(int i=0; i<=n; i++){
            graph.add(new LinkedList<>());
        }
        for(int i=0; i<edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        int parent = 0;
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, 987654321);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        
        dist[1] = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int a: graph.get(now)){
                if(dist[a] > dist[now] + 1){
                    dist[a] = dist[now] + 1;
                    q.offer(a);
                }
            }
        }
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        
        for(int i=1; i<dist.length; i++){
            tMap.put(dist[i], tMap.getOrDefault(dist[i], 0) + 1);
        }
        answer = tMap.get(tMap.lastKey());
        return answer;
    }
    
}