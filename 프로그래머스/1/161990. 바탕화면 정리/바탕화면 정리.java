import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        List<Integer> rowList = new LinkedList<>();
        List<Integer> colList = new LinkedList<>();
        
        for(int i=0; i<wallpaper.length; i++){
            char[] row = wallpaper[i].toCharArray();
            for(int j=0; j<wallpaper[i].length(); j++){
                if(row[j] == '#'){
                    rowList.add(i);
                    colList.add(j);
                }    
            }
        }
        Collections.sort(rowList);
        Collections.sort(colList);
        answer[0] = rowList.get(0);
        answer[1] = colList.get(0);
        answer[2] = rowList.get(rowList.size()-1)+1;
        answer[3] = colList.get(colList.size()-1)+1;
        // for(int item: rowList){
        //     System.out.print(item + " ");
        // }
        // System.out.println("\n==================");
        // for(int item: colList){
        //     System.out.print(item + " ");
        // }
        
        
        return answer;
    }
}