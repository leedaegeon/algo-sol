class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        answer = (long)w*h;
        long count = 0;
        for(int i=0; i<w; i++){
            int leftX = i;
            int rightX = i+1;
            
            long leftY = (long)Math.floor((double)h*leftX/w);
            long rightY = (long)Math.ceil((double)h*rightX/w);
            // System.out.print("[" + leftX + ", " + rightX + ") ");
            // System.out.println("[" + leftY + ", " + rightY + ")");
            
            answer -= rightY - leftY;
        }

        return answer;
    }
}