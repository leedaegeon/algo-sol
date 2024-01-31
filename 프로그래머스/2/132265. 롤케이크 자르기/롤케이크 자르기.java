import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] bigArr = new int[10_001];
        
        Set <Integer> bigSet = new HashSet<>();
        Set<Integer> smallSet = new HashSet<>();
        
        for(int t:topping){
            bigArr[t] += 1;
            bigSet.add(t);
        }
        
        for(int t:topping){
            bigArr[t] -= 1;
            
            if(bigArr[t] == 0){
                bigSet.remove(t);
            }
            smallSet.add(t);
            
            if(bigSet.size() == smallSet.size()){
                answer++;
            }
        }
        // for(Map.Entry e: big.entrySet()){
        //     System.out.print(e.getKey() + " " + e.getValue() + " \n");
        // }
        
        return answer;
    }
}