import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        int[][] tempAnswer = new int[data.length][4];
        String[] cmp = {"code", "date", "maximum", "remain"};
        
        int idx = 0;
        
        for(int i=0; i<4; i++){
            if(ext.equals(cmp[i])){
                idx = i;
                break;
            }
        }
        int sortIdx = 0;
        for(int i=0; i<4; i++){
            if(sort_by.equals(cmp[i])){
                sortIdx = i;
                break;
            }
        }
        
        int ansIdx=0;
        for(int i=0; i<data.length; i++){
            if(data[i][idx] < val_ext){
                tempAnswer[ansIdx++] = data[i];
            }
        }
        answer = new int[ansIdx][4];
        for(int i=0; i<ansIdx; i++){
            answer[i] = tempAnswer[i];
        }

        
        final int finalSortIdx = sortIdx;
        
        Arrays.sort(answer, (o1, o2)->{
                    return o1[finalSortIdx] - o2[finalSortIdx];
                });
        // for(int i=0; i<answer.length; i++){
        //     for(int j=0; j<4; j++){
        //         System.out.print(tempAnswer[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }
}