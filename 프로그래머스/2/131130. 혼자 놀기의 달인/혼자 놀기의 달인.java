import java.util.*;
class Solution {
    static List<Set<Integer>> ls;
    static Set<Integer> visited;
    public int solution(int[] cards) {
        int answer = 0;
        

        ls = new ArrayList<>();
        for(int k=0; k<cards.length; k++){
            ls.add(new HashSet<>());
        }
        visited = new HashSet<>();
        int j=0;
        while(visited.size() < cards.length && j<cards.length){
            if(visited.contains(j+1) && j<cards.length){
                j++;
                continue;
            }
            find(j, cards, j+1);

        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Set<Integer> hs: ls){
            pq.offer(hs.size());
        }
        // System.out.println("---------------------");
        int first = pq.poll();
        if(pq.isEmpty()){
            return 0;
        }
        int second = pq.poll();
        answer = first*second;
        return answer;
    }
    public void find(int start, int[] cards, int target){
        visited.add(start+1);
        ls.get(target-1).add(cards[start]);
        
        if(target == cards[start]){
            return;
        }
        find(cards[start]-1, cards, target);
    }
}