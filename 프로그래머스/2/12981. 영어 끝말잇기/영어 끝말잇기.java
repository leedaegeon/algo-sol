import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Arrays.fill(answer, 0);
        Set<String> hs = new HashSet<>();
        int player = 1;
        int turn = 1;
        char lastChar = words[0].charAt(words[0].length()-1);
        hs.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            // System.out.println(lastChar + " " + words[i].charAt(0));
            player++;
            if(player > n){
                player = 1;
                turn++;
            }
            if(!hs.add(words[i]) || lastChar != words[i].charAt(0)){
                answer[0] = player;
                answer[1] = turn;
                break;
            }
            
            lastChar = words[i].charAt(words[i].length()-1);
        }
        
        return answer;
    }
}