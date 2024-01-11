import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        int[][] tempAnswer = new int[data.length][4];
        
        int idx = 0;
        if(ext.equals("code")){
            idx = 0;
        }else if(ext.equals("date")){
            idx = 1;
        }else if(ext.equals("maximum")){
            idx = 2;
        }else if(ext.equals("remain")){
            idx = 3;
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
        
        if(sort_by.equals("code")){
            Arrays.sort(answer, (o1, o2)->{return o1[0]-o2[0];});
            
        }else if(sort_by.equals("date")){
            Arrays.sort(answer, (o1, o2)->{return o1[1]-o2[1];});
        }else if(sort_by.equals("maximum")){
            Arrays.sort(answer, (o1, o2)->{return o1[2]-o2[2];});
            
        }else if(sort_by.equals("remain")){
            Arrays.sort(answer, (o1, o2)->{return o1[3]-o2[3];});
        }
        for(int i=0; i<answer.length; i++){
            for(int j=0; j<4; j++){
                System.out.print(tempAnswer[i][j] + " ");
            }
            System.out.println();
        }
        return answer;
    }
}