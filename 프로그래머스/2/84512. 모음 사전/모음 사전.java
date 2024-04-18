import java.util.*;
class Solution {
    static char[] cards = {'A', 'E', 'I', 'O', 'U'};
    static int max;
    static int answer = 0;
    static List<String> ls = new LinkedList<>();
    static Set<String> set = new HashSet<>();
    public int solution(String word) {
        max = word.length();
        
        repPerm(0, new StringBuilder());
        // for(int i=0; i<100 && i<ls.size(); i++){
        //     System.out.println(ls.get(i));
        // }
        // System.out.println(ls.get(ls.size()-1));
        Collections.sort(ls);
        for(int i=0; i<ls.size(); i++){
            
            if(ls.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public void repPerm(int cnt, StringBuilder sb){
        if(cnt == 5){
            return;
        }
        
        
        for(int i=0; i<cards.length; i++){
            sb.append(cards[i]);
            if(set.add(sb.toString())){
                ls.add(sb.toString());
            }
            repPerm(cnt+1, sb);
            
            sb.delete(sb.length()-1, sb.length());
            if(set.add(sb.toString())){
                ls.add(sb.toString());
            }
            repPerm(cnt+1, sb);
            
        }
    }
    
}