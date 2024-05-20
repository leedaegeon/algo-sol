import java.util.*;
class Solution {
    static boolean[] visited = new boolean[6];
    static long[] memo;
    static List<Integer> answer = new LinkedList<>();
    public List<Integer> solution(int n, long k) {

        memo = new long[n+1];
        factorial(n, n);
        memo[0] = 1;
        // System.out.println(Arrays.toString(memo));
        List<Integer> ls = new LinkedList<>();
        for(int i=0; i<n; i++){
            ls.add(i+1);
        }
        
        getSeq(n, k, ls);
        return answer;
    }
    public void getSeq(int n, long k, List<Integer> ls){
        // System.out.println(n + " " + k);
        
        
        if(n == 0 ){
            // System.out.println(ls);
            if(ls.size()>0){
                answer.add(ls.get(0));
            }
            return;
        }
        long index;
        
        index = (k-1)/memo[n-1];
        try{
            answer.add(ls.get((int)index));
            ls.remove((int)index);
        }catch(IndexOutOfBoundsException e){
            System.out.println(n + " " +k);
        }
        long nextK;
        nextK = (k-1)%memo[n-1];
        nextK++;
        getSeq(n-1, nextK, ls);
    }
    public long factorial(long a, int idx){
        if(a == 1){
            memo[idx] = 1;
            return 1;
        }
        
        return memo[idx] = a*factorial(a-1, idx-1);
        
    }
}