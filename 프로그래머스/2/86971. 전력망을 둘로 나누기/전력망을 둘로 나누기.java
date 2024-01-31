import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        List<List<Integer>> adjTree = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjTree.add(new ArrayList<>());
        }
        for(int i=0; i<wires.length; i++){
            adjTree.get(wires[i][0]).add(wires[i][1]);
            adjTree.get(wires[i][1]).add(wires[i][0]);
        }

        // for(int i=1; i<adjTree.size(); i++){
        //     for(int j: adjTree.get(i)){
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }
        for(int[] wire: wires){
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n+1];
            int cnt = 0;

            q.offer(1);
            // System.out.print(1 + " ");

            while(!q.isEmpty()){
                int now = q.poll();
                visited[now] = true;
                cnt++;

                for(int adjItem: adjTree.get(now)){
                    if((now == wire[0] && adjItem == wire[1])
                      ||  (now == wire[1] && adjItem == wire[0])){
                        continue;
                    }
                    if(visited[adjItem]){
                       continue; 
                    }
                    q.offer(adjItem);
                    // System.out.print(adjItem + " ");
                }
            }
            answer = Math.min(answer, Math.abs(n-cnt-cnt));

            // System.out.println("\n" + wire[0] + " " + wire[1] + "를 끊었을 때 카운팅 되는 노드 수: " + (cnt));
        }
        return answer;
    }
}