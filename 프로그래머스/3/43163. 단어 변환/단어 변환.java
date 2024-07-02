import java.util.*;
class Solution {

    static List<String> ls = new LinkedList<>();
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if(!listAdd(begin, target, words)){
            return 0;
        }
        int[][] adjMat = new int[ls.size()][ls.size()];
        
        for(int i=0; i<ls.size(); i++){
            for(int j=i; j<ls.size(); j++){
                if(check(ls.get(i), ls.get(j))){
                    adjMat[i][j] = 1;
                    adjMat[j][i] = 1;
                }
            }
        }
        // for(int i=0; i<ls.size(); i++){
        //     for(int j=0; j<ls.size(); j++){
        //         System.out.print(adjMat[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // for(String a: ls){
        //     System.out.print(a + " ");
        // }
        // System.out.println();
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[adjMat.length];
        q.offer(0);
        Arrays.fill(dist, 987654321);
        dist[0] = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            if(ls.get(now).equals(target)){
                answer = dist[now];
                break;
            }
            for(int i=0; i<adjMat[now].length; i++){
                if(adjMat[now][i] == 1){
                    if(dist[i] > adjMat[now][i] + dist[now]){
                        dist[i] = adjMat[now][i] + dist[now];
                        q.offer(i);
                    }
                }
            }
            
        }
        // System.out.print("=========================\n");
        // for(int d: dist){
        //     System.out.print(d + " ");
        // }
        
        return answer;
    }
    
    public boolean check(String now, String cmp){
        int diff = 0;
        for(int i=0; i<now.length(); i++){
            if(now.charAt(i) != cmp.charAt(i)){
                diff++;
            }
            if(diff>1){
                return false;
            }
        }
        return true;
    }
   public boolean listAdd(String begin, String target, String[] words){
       ls.add(begin);
       int cnt = 0;
        for(int i=0; i<words.length; i++){
            ls.add(words[i]);
            if(words[i].equals(target)){
                cnt++;
            }
        }
       if(cnt == 1){
           return true;
       }else{
           return false;
       }
   }
}