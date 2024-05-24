class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        // System.out.println(inc);
        answer = (long)w*(long)h;
        long count = 0;
        for(int i=0; i<w; i++){
            int leftX = i;
            int rightX = i+1;
//             long leftY = leftX * h/w;
            
//             long rightY = (rightX *h + w-1) / w;
            
            
            long lY = (long)Math.floor((double)h*leftX/w);
            long rY = (long)Math.ceil((double)h*rightX/w);
            // System.out.print("[" + leftX + ", " + rightX + ") ");
            // System.out.println("[" + leftY + ", " + rightY + ")");
            
            answer -= rY - lY;
        }

        return answer;
    }
}