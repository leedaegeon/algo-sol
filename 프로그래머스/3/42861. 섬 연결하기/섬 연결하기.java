import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<Integer> connected = new HashSet<>();
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        for(int i=0; i<costs.length; i++){
            if(costs[i][2] != 0){
                pq.offer(new Node(costs[i][0], costs[i][1], costs[i][2]));
                // System.out.println(i + " " + j);
            }
        }
        
        while(!pq.isEmpty() && connected.size() < n){
            Node now = pq.poll();
            if(findParent(parent, now.start) == findParent(parent, now.end)){
                continue;
            }
            parent = union(parent, now.start, now.end);
            answer += now.cost;

        }

        
        return answer;
        
    }
    
    public int findParent(int[] parent, int child){
        if(child == parent[child]){
            return child;
        }
        return parent[child] = findParent(parent, parent[child]);
    }
    
    public int[] union(int[] parent, int a, int b){
        int parentA = findParent(parent, a);
        int parentB = findParent(parent, b);
        if(parentA < parentB){
            parent[parentB] = parentA;
        }else{
            parent[parentA] = parentB;
        }
        return parent;
    }
    
    class Node implements Comparable<Node>{
        int start;
        int end;
        int cost;
        Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        public int compareTo(Node n){
            if(this.cost == n.cost){
                return this.start - n.start;
            }else{
                return this.cost - n.cost;
            }
        }
    
    }
    
}