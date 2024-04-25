import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Item> dq = new ArrayDeque<>();
        dq.addFirst(new Item(0, prices[0]));
        for(int i=1; i<prices.length; i++){
            
            while(!dq.isEmpty() && dq.peekFirst().value > prices[i]){
                Item now = dq.removeFirst();
                answer[now.idx] = i-now.idx;
            }
            dq.addFirst(new Item(i, prices[i]));
        }
        while(!dq.isEmpty()){
            Item now = dq.removeFirst();
            answer[now.idx] = prices.length - now.idx-1;
        }
        return answer;
    }
    class Item{
        int idx;
        int value;
        Item(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }
}