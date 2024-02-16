import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> ls = new LinkedList<>();
        boolean flag = false;
        for(int i=0; i<ingredient.length; i++){
            ls.add(ingredient[i]);
            
            if(ls.size() >= 4){
                if(check(ls)){
                    int idx = ls.size()-4;
                    for(int j=0; j<4; j++){
                        ls.remove(idx);
                    }
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
    
    public boolean check(List<Integer> ls){
        int next = 1;
        
        for(int i = ls.size()-4; i<ls.size(); i++){
            if(ls.get(i) == next){
                next++;
            }else{
                return false;
            }
            if(next == 4){
                next = 1;
            }
        }
        return true;
    }
}