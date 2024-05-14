import java.util.*;
class Solution {
    boolean[] visited;
    static long answer;
    public long solution(String expression) {

        String[] numbers = expression.replaceAll("[+\\-*]","_").split("_");
        String[] ops = expression.replaceAll("[0-9]", " ").trim().split("\\s+");
        // System.out.println(Arrays.toString(ops));
        Set<String> hs = new HashSet<>();
        for(int i=0; i<ops.length; i++){
            hs.add(ops[i]);
        }
        String[] cards = new String[hs.size()];
        int idx = 0;
        for(String op: hs){
            cards[idx++] = op;
        }
        visited = new boolean[cards.length];
        perm(cards, 0, new ArrayList<>(), numbers, ops);

        return answer;
    }
    public void perm(String[] cards, int cnt, List<String> opOrder, String[] numbers, String[] ops){

        if(cnt == cards.length){
            // System.out.println("***************************");
            // System.out.println(opOrder);
            // System.out.println("***************************");
            
            answer = Math.max(calc(opOrder, numbers, ops), answer);
            return;
        }
        for(int i=0; i<cards.length; i++){
            if(visited[i]){
                continue;
            }        
            visited[i] = true;
            opOrder.add(cards[i]);
            perm(cards, cnt+1, opOrder, numbers, ops);
            opOrder.remove(opOrder.size()-1);
            visited[i] = false;
            
        }
    }
    public long calc(List<String> opOrder, String[] numbers, String[] ops){
        Deque<String> dq = new ArrayDeque<>();
        dq.addFirst(numbers[0]);
        for(int i=1; i<numbers.length; i++){
            dq.addFirst(ops[i-1]);
            dq.addFirst(numbers[i]);
        }
        for(int odr = 0; odr < opOrder.size(); odr++){
            String nowOp = opOrder.get(odr);
            int size = dq.size();
            
            // for(String s: dq){
            //     System.out.print(s + " ");
            // }
            // System.out.println();
            for(int i=0; i<size; i++){
                String now;                
                now = dq.removeLast();
                
                
                if(now.equals(nowOp)){
                    long left = Long.parseLong(dq.removeFirst());
                    long right = Long.parseLong(dq.removeLast()); 
                    
                    long val;
                    if(now.equals("+")){
                        val = left + right;
                    }else if(now.equals("-")){
                        val = left - right;
                    }else {
                        val = left * right;
                    }

                    
                    dq.addLast(Long.toString(val));
    
                    
                    // System.out.println(left + " " + now +" " + right);
                }else{
                    
                    dq.addFirst(now);
                    
                }
            }
            // System.out.println("============================");
            
        }
        // System.out.println(dq.removeFirst());
        // System.out.println(dq.size());
        

        return Math.abs(Long.parseLong(dq.removeFirst()));
    }
}