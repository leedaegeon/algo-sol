import java.util.*;
class Solution {
    static boolean[] visited = new boolean[6];
    static long[] memo;
    static List<Integer> answer = new LinkedList<>();
    public List<Integer> solution(int n, long k) {

        memo = new long[n+1];
        factorial(n, n);
        // System.out.println(Arrays.toString(memo));
        List<Integer> ls = new LinkedList<>();
        for(int i=0; i<n; i++){
            ls.add(i+1);
        }
        
        getSeq(n, k, ls);
        return answer;
    }
    public void getSeq(int n, long k, List<Integer> ls){
        
        if(n == 0 ){
            return;
        }
        long index = (k-1)/memo[n-1];
        answer.add(ls.get((int)index));
        ls.remove((int)index);
        long nextK = (k-1)%memo[n-1];
        getSeq(n-1, ++nextK, ls);
    }
    public long factorial(long a, int idx){
        if(a == 0){
            memo[idx] = 1;
            return 1;
        }
        
        return memo[idx] = a*factorial(a-1, idx-1);
        
    }
}