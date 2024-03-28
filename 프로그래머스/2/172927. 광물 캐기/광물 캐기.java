import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int[] mapping = new int[minerals.length];
        for(int i=0; i<minerals.length; i++){
            if(minerals[i].equals("diamond")){
                mapping[i] = 0;
            }else if(minerals[i].equals("iron")){
                mapping[i] = 1;
            }else{
                mapping[i] = 2;
            }
        }
        Queue<Integer> toolQ = new ArrayDeque<>();
        
        for(int i=0; i<picks.length; i++){
            for(int j=0; j<picks[i]; j++){
                toolQ.offer(i);
            }
        }
        int toolNum = toolQ.size();
        
        int idx = 0;
        List<Map<Integer, Integer>> ls = new ArrayList<>();
        
        while(toolNum > 0 && idx < mapping.length){
            Map<Integer, Integer> map = new HashMap<>();
            int dia = 0;
            int iron = 0;
            for(int i = idx; i<idx+5 && i< mapping.length; i++){
                map.put(mapping[i], map.getOrDefault(mapping[i], 0) + 1);
                if(mapping[i] == 0){
                    dia++;
                }else if (mapping[i] == 1){
                    iron++;
                }
                
            }
            map.put(3, dia);
            map.put(4, iron);
            ls.add(map);
            toolNum--;
            idx += 5;
        }
        // for(Map<Integer, Integer> m: ls){
        //     for(Map.Entry<Integer, Integer> e: m.entrySet()){
        //         if(e.getKey() == 0){
        //             System.out.println("광물: 다이아 " + e.getValue() + "개 도구: " );
        //         }
        //         else if(e.getKey() == 1){
        //             System.out.println("광물: 철 " + e.getValue() + "개 도구: " );
        //         }
        //         else if(e.getKey() == 2){
        //             System.out.println("광물: 돌 " + e.getValue() + "개 도구: " );
        //         }
        //     }
        //     System.out.println("=================");
        // }
        Collections.sort(ls, (o1, o2) -> {
            if(o1.get(3) == o2.get(3)){
                return o2.get(4) - o1.get(4);
            }else{
                return o2.get(3) - o1.get(3);
            }
        });
        
        for(Map<Integer, Integer> m: ls){
            int tool = toolQ.poll();
            answer += calcValue(m, tool);
        }
        return answer;
    }
    
    public int calcValue(Map<Integer, Integer> map, int tool){
        int answer = 0;
        for(Map.Entry<Integer, Integer> e: map.entrySet()){ 
            if(e.getKey() == 0){
                if(tool == 0){
                    answer += 1*e.getValue();
                }else if(tool == 1){
                    answer += 5*e.getValue();
                }else{
                    answer += 25*e.getValue();
                }
            }else if(e.getKey() == 1){
                if(tool == 0){
                    answer += 1*e.getValue();
                }else if(tool == 1){
                    answer += 1*e.getValue();
                }else{
                    answer += 5*e.getValue();
                }
            }else if(e.getKey() == 2){
                answer += 1*e.getValue();
            }
        }
        return answer;
    }
}