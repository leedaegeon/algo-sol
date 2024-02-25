class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        while(Integer.bitCount(++n) != cnt){}
        return n;
    }
}