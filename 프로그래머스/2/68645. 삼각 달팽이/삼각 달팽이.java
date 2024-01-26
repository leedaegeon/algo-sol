import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[][] ans = new int[n][n];
        int max = n*(n+1)/2;
        
        int[] di = {1,0,-1};
        int[] dj = {0, 1, -1};
        
        int l,r,u,d;
        l = 0;
        u = 0;
        r = n;
        d = n;
        int k = 1;
        int dir = 0;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0,0));
        while(!q.isEmpty()){
            Node current = q.poll();
            ans[current.y][current.x] = k++;
            if(current.y+di[dir] < u || current.y+di[dir] >= d || current.x+dj[dir] < l || current.x+dj[dir] >= r){
                dir++;
                dir%=3;

            }
            else if(ans[current.y+di[dir]][current.x+dj[dir]] != 0){
                dir++;
                dir%=3;
            }
            q.offer(new Node (current.y+di[dir], current.x+dj[dir]));
            
            if(k == max+1){
                break;
            }
        }
        List<Integer> ls = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(ans[i][j]==0){
                    continue;
                }
                ls.add(ans[i][j]);
            }
        }
        int[] answer = new int[ls.size()];
        for(int i=0; i<ls.size(); i++){
            answer[i] = ls.get(i);
        }
        
        return answer;
    }
    class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}