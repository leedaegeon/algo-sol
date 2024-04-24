import java.util.*;
class Solution {
    static String[][] map;
    static boolean[][] visited;
    static int[] di = {0, 1, 1};
    static int[] dj = {1, 1, 0};
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new String[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = Character.toString(board[i].charAt(j));
            }
        }
        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int newRound = -1;
        // int round = 0;
        while(newRound != 0){
            if(newRound==0){
                break;
            }
            // if(round==3){
            //     break;
            // }
            newRound = game(map);
            answer += newRound;
            map = mapArrange(map);
            // for(int i=0; i<m; i++){
            //     for(int j=0; j<n; j++){
            //         if(map[i][j].equals(" ")){
            //             System.out.print("*");
            //         }else{
            //             System.out.print(map[i][j] + " ");
            //         }
            //     }
            //     System.out.println();
            // }
            // for(int i=0; i<m; i++){
            //     for(int j=0; j<n; j++){
            //         System.out.print(visited[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println(newRound);
            // round++;   
        }
        return answer;
    }
    public int game(String[][] map){
        visited = new boolean[map.length][map[0].length];

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(!map[i][j].equals("*")){
                    bfs(map, i, j);
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<visited.length; i++){
            for(int j=0; j<visited[0].length; j++){
                if(visited[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void bfs(String[][] map, int y, int x){
        
        String item = map[y][x];
        
        int cnt = 0;
        List<Cord> ls = new ArrayList<>();
        ls.add(new Cord(y,x));
        for(int i=0; i<3; i++){
            int nexty = y + di[i];
            int nextx = x + dj[i];
            if(nexty<0 || nexty >= map.length || nextx < 0 || nextx >= map[0].length){
                return ;
            }
            if(map[nexty][nextx].equals(item)){
                cnt++;
                ls.add(new Cord(nexty, nextx));
            }
        }
        
        if(cnt>=3){
            for(Cord c: ls){
                visited[c.y][c.x] = true;
            }
        }
        return;
    }
    public String[][] mapArrange(String[][] map){
        String[][] newMap = new String[map.length][map[0].length];
        for(int i=0; i<map.length; i++){
            Arrays.fill(newMap[i], "*");
        }
        for(int j=0; j<map[0].length; j++){
            Deque<String> dq = new ArrayDeque<>();
            
            for(int i=0; i<map.length; i++){
                if(!visited[i][j]){
                    dq.addFirst(map[i][j]);
                }
            }
            int row = map.length-1;
            while(!dq.isEmpty()){
                newMap[row--][j] = dq.removeFirst();
            }
        }
        return newMap;
    }
    class Cord{
        int y;
        int x;
        Cord(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}