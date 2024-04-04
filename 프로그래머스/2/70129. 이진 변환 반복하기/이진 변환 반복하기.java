import java.util.*;
class Solution {
    static int[] answer = new int[2];

    public int[] solution(String s) {
        dfs(s, 0, 0);
        return answer;
    }
    public void dfs(String s, int zeroCnt, int cnt){
        
        if(s.equals("1")){
            answer[0] = cnt;
            answer[1] = zeroCnt;
            return;
        }
        
        // long oneCnt = Long.bitCount(Long.parseLong(s,2));
        String oneS = s.replace("0", "");
        int oneCnt = oneS.length();
        zeroCnt += s.length() - oneCnt;
        
        StringBuilder sb = new StringBuilder();        
        while(oneCnt>0){
            sb.append(oneCnt%2);
            oneCnt/=2;
        }
        sb.reverse();
        dfs(sb.toString(), zeroCnt, cnt+1);
        return;
    }
}