import java.util.*;
class Solution {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int k=0;
        q.offer(new int[]{0, 0});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] now = q.poll();
                if(now[0] == n-1 && now[1] == m-1){
                    answer = k;
                    break;
                }
                if(maps[now[0]][now[1]] == 2){
                    continue;
                }
                maps[now[0]][now[1]] = 2;
                for(int dir=0; dir<4; dir++){
                    int nexty = now[0] + di[dir];
                    int nextx = now[1] + dj[dir];
                    if(nexty < 0 ||nexty >= n || nextx < 0 || nextx >= m || maps[nexty][nextx] == 0 || maps[nexty][nextx] == 2){
                        continue;
                    }
                    q.offer(new int[]{nexty, nextx});
                }
                
            }
            if(answer != 0){
                break;
            }
            k++;

        }
        if(answer == 0){
            answer = -1;
        }else{
            answer++;
        }
        
        return answer;
    }
}