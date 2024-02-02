import java.util.*;
class Solution {
    static int zeroCnt = 0;
    static int oneCnt = 0;
    static List<Integer> ls = new LinkedList<>();
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        // System.out.println();
        div(0, arr.length, 0, arr.length, arr, 0, arr.length);
        answer[0] = zeroCnt;
        answer[1] = oneCnt;
        return answer;
    }
    public int div(int sy, int ey, int sx, int ex, int[][] arr, int site, int size){
        int half = size/2;
        // System.out.println(sy + " " + ey + " " + sx + " " + ex);  
        if(size == 1){
            if(arr[sy][sx] == 1){
                oneCnt++;
            }else{
                zeroCnt++;
            }
            return arr[sy][sx];
        }
        
        int first = div(sy, sy+half, sx, sx+half, arr, 1, half);
        int second = div(sy, sy+half, sx+half, ex, arr, 2, half);
        int third = div(sy + half, ey, sx, sx+half, arr, 3, half);
        int fourth = div(sy+half, ey, sx+half, ex, arr, 4, half);
        
        // if((first==second && first==third && first==fourth) && (first == 0 || first == 1)){
        if((first==second && first==third && first==fourth)){
        
            // System.out.println(sy + " " + ey + " " + sx + " " + ex);  
            // System.out.println(site+"사분면 " + " value: " + first);  

            if(first == 1){
                oneCnt -= 3;
                return 1;
            }else if(first == 0){
                zeroCnt -= 3;
                return 0;
            }
            
        }
        
        // System.out.println(first + " " + second + " " + third + " " + fourth);
        // System.out.println(sy + " " + ey + " " + sx + " " + ex);  
        
        
        return -1;
    }
}