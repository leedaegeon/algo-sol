import java.util.*;
class Solution {
    static List<List<String>> cards = new LinkedList<>();
    static Set<Set<String>> hyperSet = new HashSet<>();
    static Set<String> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        for(int i=0; i< banned_id.length; i++){
            cards.add(new LinkedList<>());
        }
        for(int i=0; i<user_id.length; i++){
            for(int j=0; j<banned_id.length; j++){
                if(user_id[i].length() == banned_id[j].length() && check(user_id[i], banned_id[j])){               
                    cards.get(j).add(user_id[i]);
                }
            }
        }
        comb(0, user_id, banned_id);
        
        answer = hyperSet.size();
        
        return answer;
    }
    public void comb(int idx, String[] user_id, String[] banned_id){
        if(idx == cards.size()){

            Set<String> hs = new HashSet<>(set);
            hyperSet.add(hs);
            return;
        }
        
        for(String s: cards.get(idx)){
            if(set.contains(s)){
                continue;
            }
            set.add(s);
            comb(idx+1, user_id, banned_id);
            set.remove(s);
                
        }
        
    }
    public boolean check(String user, String ban){
        for(int i=0; i<user.length(); i++){
            if(ban.charAt(i) == '*'){
                continue;
            }else if(user.charAt(i) != ban.charAt(i)){
                return false;
            }
            
        }
        return true;
    }
    
}