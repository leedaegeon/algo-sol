import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Set<String> set1 = new HashSet<>();
        for(int i=0; i<cards1.length; i++){
            set1.add(cards1[i]);
        }

        List<String> ls1 = new ArrayList<>();
        List<String> ls2 = new ArrayList<>();
        for(int i=0; i<goal.length; i++){
            if(set1.contains(goal[i])){
                ls1.add(goal[i]);
            }else{
                ls2.add(goal[i]);
            }
        }
        if(check(cards1, ls1) && check(cards2, ls2)){
            answer = "Yes";
        }else{
            answer = "No";
        }
        return answer;
    }
    public boolean check(String[] cards, List<String> ls){
        for(int i=0; i<cards.length && i<ls.size(); i++){
            if(!cards[i].equals(ls.get(i))){
                return false;
            }
        }
        return true;
    }
}