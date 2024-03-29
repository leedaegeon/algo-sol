import java.util.*;
class Solution {
    
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        char[][] waitRoom = new char[5][5];
        Arrays.fill(answer, 1);
        int roomNum=0;
        for(String[] wait: places){
            for(int i = 0; i<wait.length; i++){
                waitRoom[i] = wait[i].toCharArray();
            }
            for(int i=0; i<waitRoom.length; i++){
                for(int j=0; j<waitRoom[i].length; j++){
                    if(waitRoom[i][j] == 'P'){
                        if(!bfs(i, j, waitRoom)){
                            answer[roomNum] = 0;
                            break;
                        }
                    }
                }
                if(answer[roomNum] == 0){
                    break;
                }
            }
            roomNum++;

        }
        
        return answer;
    }
    public boolean bfs(int starty, int startx, char[][] waitRoom){
//         1. 오른쪽, 아래 벽 탐색
//         2. 오른쪽, 아래 2칸 떨어져있는 애들 탐색
//         3. 오른쪽 대각에 있는 애들 탐색
        int[] di = {0, 1, 0};
        int[] dj = {1, 0, -1};
        int wall[] = new int[3];
        for(int i=0; i<3; i++){
            int nexty = starty + di[i];
            int nextx = startx + dj[i];
            if(nexty<0 || nexty >= 5
               || nextx < 0 || nextx >= 5){
                continue;
            }
            if(waitRoom[nexty][nextx] == 'X'){
                wall[i] = 1;
            }else if(waitRoom[nexty][nextx] == 'P'){
                return false;
            }
        }
        int[] di2 = {0, 2};
        int[] dj2 = {2, 0};
        for(int i=0; i<2; i++){
            int nexty = starty + di2[i];
            int nextx = startx + dj2[i];
            if(nexty<0 || nexty >= 5
               || nextx < 0 || nextx >= 5 
               || wall[i] == 1){
                continue;
            }
            
            if(waitRoom[nexty][nextx] == 'P'){
                return false;
            }
        }
        int[] di3 = {1,1};
        int[] dj3 = {1, -1};
        
        for(int i=0; i<2; i++){
            int nexty = starty + di3[i];
            int nextx = startx + dj3[i];
            if(nexty<0 || nexty >= 5
               || nextx < 0 || nextx >= 5){
                continue;
            }
            if(wall[i] == 1 && wall[i+1] == 1){
                continue;
            }
            if(waitRoom[nexty][nextx] == 'P'){
                return false;
            }
        }
        return true;
    }
}