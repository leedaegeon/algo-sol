import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] game = new int[land.length][4];
        for(int i=0; i<4; i++){
            game[0][i] = land[0][i];
        }
        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++){
                for(int k=0; k<4; k++){
                    if(j==k){
                        continue;
                    }
                    game[i][k] = Math.max(game[i][k], land[i][k] + game[i-1][j]);
                }
            }
        }
        // for(int i=0; i<game.length; i++){
        //     System.out.println(Arrays.toString(game[i]));
        // }
        for(int i=0; i<4; i++){
            answer = Math.max(answer, game[game.length-1][i]);
        }
        return answer;
    }
}