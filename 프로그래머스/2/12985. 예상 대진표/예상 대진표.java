class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int temp = n;
        while(true){
            if(temp==1){
                break;
            }
            temp=temp>>1;
            answer++;
        }
        // System.out.println(Double.compare(2.0, 1.0));
        double min = Math.min(a,b);
        double max = Math.max(a,b);
        double start = 1;
        double end = n;
        // System.out.println(answer);
        while(true){
            
            double mid = start + (end-start)/2.0;
            // System.out.println(mid + " " + min + " " + max);
            boolean leftFlag = Double.compare(min, mid) != 1?true:false;
            boolean rightFlag = Double.compare(mid, max) != 1?true:false;
            boolean rightFlagRev = Double.compare(mid, max) != -1?true:false;
            if(leftFlag && rightFlag){
                break;

            }else if(leftFlag && rightFlagRev){
                end = mid;
            }else{
                start = mid;
            }
            answer--;
        }

        return answer;
    }
}