import java.util.*;
class Solution {
    static int[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    
    public int solution(int[][] land) {
        int answer = 0;
        visited = new int[land.length][land[0].length];

        int cnt = 1;
        // int[] colOil = new int[land[0].length];
        List<Integer> colOil = new ArrayList<>();
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(visited[i][j] == 0 && land[i][j] == 1){
                    colOil.add(bfs(land, i, j, cnt++));
                }
                
            }
            
        }
        // System.out.println(colOil);
        // for(int i=0; i<visited.length; i++){
        //     System.out.println(Arrays.toString(visited[i]));
        // }
        List<Set<Integer>> ls = new ArrayList<>();
        for(int i=0; i<land[0].length; i++){
            ls.add(new HashSet<>());
        }
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(visited[i][j]!=0){
                    ls.get(j).add(visited[i][j]-1);
                }
            }
        }
        for(int i=0; i<ls.size(); i++){

            int sum = 0;
            for(int idx: ls.get(i)){
                sum += colOil.get(idx);
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    public int bfs(int[][] land, int starty, int startx, int cnt){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{starty, startx});
        int oil = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(visited[now[0]][now[1]] != 0){
                continue;
            }
            visited[now[0]][now[1]] = cnt;
            oil++;
            for(int i=0; i<4; i++){
                int nexty = now[0] + di[i];
                int nextx = now[1] + dj[i];
                if(nexty < 0 || nexty >= land.length
                  || nextx < 0 || nextx >= land[0].length 
                   || land[nexty][nextx] == 0){
                    continue;
                }
                q.offer(new int[]{nexty, nextx});
                
            }
        }
        return oil;
    }
}
