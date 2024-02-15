import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String s) {
        String s1 = s.substring(1, s.length()-1);
        // System.out.println(s1);
        StringTokenizer st = new StringTokenizer(s1, "{}");
        Set<String> hs = new HashSet<>();
        List<List<String>> ls = new LinkedList<>();
        for(int i=0; i<st.countTokens()+1; i++){
            ls.add(new LinkedList<>());
        }
        int arrSize = 0;
        while(st.hasMoreTokens()){
            
            // hs.add(st.nextToken());
            String next = st.nextToken();
            if(next.equals(",")){
                continue;
            }
            StringTokenizer subSt = new StringTokenizer(next, ",");
            int size = subSt.countTokens();
            while(subSt.hasMoreTokens()){
                String subNext = subSt.nextToken();
                if(subNext.equals(",")){
                    continue;
                }
                ls.get(size).add(subNext);
            }
            
            // System.out.println(next.length());
            arrSize++;
        }
        int[] answer = new int[arrSize];
        int idx = 0;
        for(List<String> a: ls){
            for(String x : a){
                if(hs.add(x)){
                    answer[idx] = Integer.parseInt(x);
                    idx++;
                }
                // System.out.print(x + " ");
            }
            // System.out.println();
        }
        
        return answer;
    }
}