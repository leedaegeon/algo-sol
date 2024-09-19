import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        List<List<Integer>> adjRoad = getAdjRoad(n, roads);
        int[] distance = getDistance(n, destination, adjRoad);
        int[] answer = getAnswer(distance, sources);
        
        return answer;
    }
    public int[] getAnswer(int[] distance, int[] sources){
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
            answer[i] = distance[sources[i]];
            if(answer[i] == 987654321){
                answer[i] = -1;
            }
        }
        return answer;
    }
    public List<List<Integer>> getAdjRoad(int n, int[][] roads){
        List<List<Integer>> adjRoad = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            adjRoad.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++){
            adjRoad.get(roads[i][0]).add(roads[i][1]);
            adjRoad.get(roads[i][1]).add(roads[i][0]);
        }
        return adjRoad;
    }
    public int[] getDistance(int n, int destination, List<List<Integer>> adjRoad){
        Queue<Edge> edges = new ArrayDeque<>();
        edges.offer(new Edge(destination, destination));
        int[] distance = new int[n+1];
        Arrays.fill(distance, 987654321);
        distance[destination] = 0;
        
        while(!edges.isEmpty()){
            Edge now = edges.poll();
            for(int next: adjRoad.get(now.end)){
//                 start에서 next를 가는데 end를 거쳐서 가는게 져럼한지 이전에 가는 방식이 저렴한지 검사
                if(distance[next] > distance[now.end] + 1){
                    distance[next] = distance[now.end] + 1;
                    edges.offer(new Edge(now.end, next));
                }
            }
        }
        return distance;
    }
    class Edge{
        int start;
        int end;
        Edge(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}