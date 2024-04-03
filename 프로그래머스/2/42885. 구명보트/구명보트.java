import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        boolean[] visited = new boolean[people.length];
        int left = people.length;
        for(int i=0; i<people.length; i++){
            if(visited[i]){
                continue;
            }
            int pair = i;
            visited[i] = true;
            for(int j=left-1; j>i; j--){
                
                if(people[i]+people[j] <= limit){
                    pair = j;
                    left = j;
                    break;
                }else{
                    visited[j] = true;
                    answer++;
                }
            }
            visited[pair] = true;
            answer++;
        }
        return answer;
    }
}