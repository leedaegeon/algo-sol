import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        // for(int[] a: routes){
        //     System.out.println(a[0] + " " + a[1]);
        // }
        int point = routes[0][1];
        for(int i=0; i<routes.length; i++){
            if(routes[i][0] <= point && point <= routes[i][1]){
                continue;
            }else{
                answer++;
                point = routes[i][1];
            }
        }
        return answer;
    }
}