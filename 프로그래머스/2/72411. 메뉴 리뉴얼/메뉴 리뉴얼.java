import java.util.*;
class Solution {
    static TreeMap<String, Integer> map = new TreeMap<>();
    static Map<Integer, Integer> max = new HashMap<>();
    
    public List<String> solution(String[] orders, int[] course) {
        
        List<Character> cards;
        
        for(int i=0; i<orders.length; i++){
            cards = new ArrayList<>();
            for(int j=0; j<orders[i].length(); j++){
                cards.add(orders[i].charAt(j));
            }
            for(int j=0; j<course.length; j++){
                comb(0, 0, cards, new TreeSet<>(), course[j]);
            }
        }
        
        List<String> answer = new ArrayList<>();
        for(Map.Entry<String, Integer> e: map.entrySet()){
            if(e.getValue()>=2 && max.get(e.getKey().length()) == e.getValue()){
                answer.add(e.getKey());
            }
        }
        // Collections.sort(answer);
        return answer;
    }
    public void comb(int idx, int cnt, List<Character> cards, TreeSet<Character> ts, int n){
        if(cnt == n){
            StringBuilder sb = new StringBuilder();
            for(Character c: ts){
                sb.append(c);
            }
            String str = sb.toString();
            map.put(str, map.getOrDefault(str, 0)+1);
            
            max.put(str.length(), Math.max(max.getOrDefault(str.length(), 0), map.get(str)));
            return;
        }
        if(idx == cards.size()){
            return;
        }
        ts.add(cards.get(idx));
        comb(idx + 1, cnt+1, cards, ts, n);
        ts.remove(cards.get(idx));
        comb(idx+1, cnt, cards, ts, n);
        
    }
}