import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Map<Integer, Integer> minMap = new TreeMap<>();
        Map<Integer, Integer> maxMap = new TreeMap<>(Collections.reverseOrder());

        for(int i=0; i<operations.length; i++){
            String[] strArr = operations[i].split(" ");
            // System.out.print(strArr[0] + " " + strArr[1] + " ");
            if(strArr[0].equals("I")){
                // System.out.println();
                int val = Integer.parseInt(strArr[1]);
                minMap.put(val, minMap.getOrDefault(val, 0) + 1);
                maxMap.put(val, maxMap.getOrDefault(val, 0) + 1);
            }
            else if(strArr[1].equals("-1")){
                if(minMap.keySet().size() <= 0){
                    continue;
                }
                int minVal = minMap.keySet().iterator().next();
                // System.out.println(minVal);
                if(minMap.get(minVal) != null && maxMap.get(minVal) != null && minMap.get(minVal) <= 1){
                    minMap.remove(minVal);
                    maxMap.remove(minVal);
                }else{
                    minMap.put(minVal, minMap.get(minVal) - 1);
                    maxMap.put(minVal, maxMap.get(minVal) - 1);
                }
            }else{
                if(maxMap.keySet().size() <= 0){
                    continue;
                }
                int maxVal = maxMap.keySet().iterator().next();
                // System.out.println(maxVal);
                if(minMap.get(maxVal) != null && maxMap.get(maxVal) != null && maxMap.get(maxVal) <= 0){
                    minMap.remove(maxVal);
                    maxMap.remove(maxVal);
                }else{
                    minMap.put(maxVal, minMap.get(maxVal) - 1);
                    maxMap.put(maxVal, maxMap.get(maxVal) - 1);
                }
            }
            // System.out.print("minMap: ");
            // for(Map.Entry<Integer, Integer> m: minMap.entrySet()){
            //     System.out.print(m + ", ");
            // }
            // System.out.println();
            // System.out.print("maxMap: ");
            // for(Map.Entry<Integer, Integer> m: maxMap.entrySet()){
            //     System.out.print(m + ", ");
            // }
            // System.out.println("\n====================");
        }
        int minVal = 0;
        int maxVal = 0;
        
        for(Map.Entry<Integer, Integer> m : minMap.entrySet()){
            if((int)m.getValue() > 0){
                minVal = m.getKey();
                break;
            }
        }
        for(Map.Entry<Integer, Integer> m : maxMap.entrySet()){
            if((int)m.getValue() > 0){
                maxVal = m.getKey();
                break;
            }
        }     
        answer[0] = maxVal;
        answer[1] = minVal;
        return answer;
    }
}