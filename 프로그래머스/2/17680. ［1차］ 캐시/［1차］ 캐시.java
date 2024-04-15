import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Set<String> hs = new HashSet<>();
//         인덱스 조회, 도시명으로 특정 노드 삭제등 임의 접근이 많을 것으로 예상하여 ArrayList 사용
        List<String> ls = new ArrayList<>();
        
        for(String city: cities){
//             도시명 대소문자 구분X
            city = city.toLowerCase();
            if(hs.contains(city)){
//                 캐시 히트
                ls.remove(city);                
                ls.add(city);
                answer+=1;
            }else if(cacheSize > 0){
//                 캐시크기가 0보다 큰 경우
                if(hs.size()==cacheSize){
//                     캐시가 가득 찬 경우 가장 오래전에 사용한 원소 삭제(리스트 맨 앞 원소)
                    String remove = ls.get(0);
                    hs.remove(remove);
                    ls.remove(0);
                    // System.out.println(remove);
                }
//                 현재 읽은 도시 캐시에 추가
                hs.add(city);
                ls.add(city);
                answer+=5;
            }else{
//                 캐시 크기가 0이면 모든 조회가 캐시 미스임
                answer+=5;
            }
        }
        
        return answer;
    }
}