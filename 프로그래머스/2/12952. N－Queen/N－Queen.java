import java.util.*;
class Solution {
    static int answer = 0;
    
    public int solution(int n) {
        nqueen(n, 0, new ArrayList<>());
        return answer;
    }
    public void nqueen(int n, int row, List<Integer> selectedCol){
        if(row == n){
            answer++;     
            return;
        }
        for(int col=0; col<n; col++){
            if(check(selectedCol, col)){
                selectedCol.add(col);
                nqueen(n, row+1, selectedCol);
                selectedCol.remove(selectedCol.size()-1);
            }
        }
    }
    public boolean check(List<Integer> selectedCol, int col){
        int currentRow = selectedCol.size();
        
        for(int i=0; i<selectedCol.size(); i++){
            if(selectedCol.get(i) == col || Math.abs(selectedCol.get(i) - col) == currentRow - i){
                return false;
            }
        }
        return true;
    }
}