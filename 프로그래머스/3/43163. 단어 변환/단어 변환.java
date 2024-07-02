import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Set<String> visited = new HashSet<>();

        Queue<String> q = new ArrayDeque<>();
        q.offer(begin);
        int k = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s=0; s<size; s++) {
                String now = q.poll();
                if(visited.contains(now)){
                    continue;
                }
                visited.add(now);
                if (now.equals(target)) {
                    return k;
                }


                for (String w : words) {
                    int cnt = 0;
                    for (int i = 0; i < now.length(); i++) {
                        if (now.charAt(i) != w.charAt(i)) {
                            cnt++;
                        }
                        if (cnt > 1) {
                            break;
                        }
                    }
                    if (cnt == 1) {
                        q.offer(w);
                    }

                }

            }
            k++;
        }   
        
    
        return answer;
    }
}