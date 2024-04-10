class Solution
{
    public int solution(int n, int a, int b)
    {
//         최대 경기수
        int answer = Integer.toBinaryString(n).length()-1;
        
        // System.out.println(Double.compare(2.0, 1.0));
        double min = Math.min(a,b);
        double max = Math.max(a,b);
        
//         이진탐색으로 두 참가자가 서로 어느 위치만큼 떨어져있는지 탐색
        double start = 1.0;
        double end = n*1.0;        
        while(true){
//             탐색할 지점
            double mid = start + (end-start)/2.0;
            
//             double 타입은 Double.compare 사용하기
//             min<=mid
            boolean leftFlag = Double.compare(min, mid) != 1?true:false;
//             mid <= max
            boolean rightFlag = Double.compare(mid, max) != 1?true:false;
            
//             min <= mid && max >= mid
            if(leftFlag && rightFlag){
                break;
//              min < mid && max < mid       
            }else if(leftFlag && !rightFlag){
                end = mid;
            }else{
//              min > mid && max > mid
                start = mid;
            }
            answer--;
        }

        return answer;
    }
}