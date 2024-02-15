import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        String[] strArr = s.replaceAll("[{}]", " ").trim().split(" , ");
        Set<String> hs = new HashSet<>();
        
        Arrays.sort(strArr, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        answer = new int[strArr.length];
        int idx = 0;
        for(String s2 : strArr){
            for(String s3 : s2.split(",")){
                if(hs.add(s3)){
                    answer[idx++] = Integer.parseInt(s3);
                }        
            }
        }
        
        return answer;
    }
}