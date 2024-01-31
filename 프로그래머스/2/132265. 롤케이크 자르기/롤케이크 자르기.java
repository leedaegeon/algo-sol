import java.util.*;
class Solution {
    public int solution(int[] topping) {
         int answer = 0;
        Map<Integer, Integer> big = new HashMap<>();
        Map<Integer, Integer> small = new HashMap<>();
        Set <Integer> bigSet = new HashSet<>();
        Set<Integer> smallSet = new HashSet<>();

        for(int t: topping){
            if(big.get(t) == null){
                big.put(t, 1);
                bigSet.add(t);
            }else{
                big.put(t, big.get(t) + 1);
            }
        }
        for(int t:topping){
            big.put(t, big.get(t) -1);
            if(big.get(t).equals(0)){
                bigSet.remove(t);
            }

            if(small.get(t) == null){
                small.put(t, 1);
                smallSet.add(t);
            }else{
                small.put(t, small.get(t) + 1);
            }
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