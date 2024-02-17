import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        for(int i=0; i<operations.length; i++){
            String[] op = operations[i].split(" ");
            if(op[0].equals("I")){
                int val = Integer.parseInt(op[1]);
                tmap.put(val, tmap.getOrDefault(val, 0) + 1);
            }else if(op[1].equals("-1")){
                if(tmap.size() > 0){
                    int minVal = tmap.firstKey();
                    tmap.put(minVal, tmap.get(minVal) - 1);
                    if(tmap.get(minVal) == 0){
                        tmap.remove(minVal);
                    }
                }
            }else{
                
                if(tmap.size() > 0){
                    int maxVal = tmap.lastKey();
                    tmap.put(maxVal, tmap.get(maxVal) - 1);
                    if(tmap.get(maxVal) == 0){
                        tmap.remove(maxVal);
                    }
                }
            }
        }
        answer = new int[2];
        if(tmap.size() > 0){
            answer[0] = tmap.lastKey();
            answer[1] = tmap.firstKey();
        }
        return answer;
    }
}