import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> hs = new HashSet<>();
        
        q.offer(x);
        int cnt = 0;
        while(!q.isEmpty()){
            int qsize = q.size();
            
            for(int i=0; i<qsize; i++){
                int current = q.poll();
                if(current == y){
                    return cnt;
                }
                if(current+n <= y && hs.add(current+n)){
                    q.offer(current+n);
                }
                if(current*2 <= y && hs.add(current*2)){
                    q.offer(current*2);
                }
                if(current*3 <= y && hs.add(current*3)){
                    q.offer(current*3);
                }
            }
            cnt++;
        }
        
        
        return answer;
    }
}