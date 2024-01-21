class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean flag = true;
        int firstCnt = 0;
        int otherCnt = 0;
        char firstChar = s.charAt(0);
        for(int i=0; i<s.length(); i++){
            if(flag){
                firstChar = s.charAt(i); 
                // System.out.println(firstChar);
                
                firstCnt = 0;
                otherCnt = 0;
                flag = false;
            }
            if(s.charAt(i) == firstChar){
                firstCnt++;
            }else{
                otherCnt++;
            }
            if(firstCnt == otherCnt){
                // System.out.println(s.charAt(i));
                answer++;
                flag = true;
            }
            if(!flag && i == s.length()-1){
                // System.out.println(s.charAt(i));
                answer++;
            }
        }
        
        return answer;
    }
}