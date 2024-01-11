import java.util.*;

class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int[][] tempAnswer = new int[data.length][4];
        String[] cmp = {"code", "date", "maximum", "remain"};
        Map<String, Integer> category = new HashMap<>();
        List<int[]> answer = new LinkedList<>();
        
        for(int i=0; i<4; i++){
            category.put(cmp[i], i);
        }
        int idx = 0;
        
        idx = category.get(ext);
        final int finalSortIdx = category.get(sort_by); 
        
        int ansIdx=0;
        for(int i=0; i<data.length; i++){
            if(data[i][idx] < val_ext){
                answer.add(data[i]);
            }
        }
        
        Collections.sort(answer, (o1, o2) ->{
            return o1[finalSortIdx] - o2[finalSortIdx];
        });
        

        return answer;
    }
}
