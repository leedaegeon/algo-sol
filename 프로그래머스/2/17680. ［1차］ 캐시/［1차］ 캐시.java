import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Set<String> hs = new HashSet<>();

        List<String> ls = new ArrayList<>();
        for(String city: cities){
            city = city.toLowerCase();
            // System.out.println(city);
            if(hs.contains(city)){
//                 캐시 히트
                ls.remove(city);                
                ls.add(city);
                answer+=1;
            }else if(cacheSize > 0){
                if(hs.size()==cacheSize){
                    String remove = ls.get(0);
                    hs.remove(remove);
                    ls.remove(0);
                    // System.out.println(remove);
                }
                hs.add(city);
                ls.add(city);
                answer+=5;
            }else{
                answer+=5;
            }
        }
        
        return answer;
    }
}