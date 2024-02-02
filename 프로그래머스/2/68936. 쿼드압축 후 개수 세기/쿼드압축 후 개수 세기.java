import java.util.*;
class Solution {
    static int zeroCnt = 0;
    static int oneCnt = 0;
    static List<Integer> ls = new LinkedList<>();
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        // System.out.println();
        div(0, arr.length, 0, arr.length, arr, 0);
        answer[0] = zeroCnt;
        answer[1] = oneCnt;
        return answer;
    }
    public int div(int sy, int ey, int sx, int ex, int[][] arr, int site){
        // System.out.println(sy + " " + ey + " " + sx + " " + ex);  
        if(ey - sy <= 1 || ex - sx <= 1){
            if(arr[sy][sx] == 1){
                oneCnt++;
            }else{
                zeroCnt++;
            }
            return arr[sy][sx];
        }
        
        
        int first = div(sy, sy+(ey-sy)/2, sx, sx + (ex-sx)/2, arr, 1);
        // System.out.println("first");
        int second = div(sy, sy+(ey-sy)/2, sx+(ex-sx)/2, ex, arr, 2);
        // System.out.println("second");
        int third = div(sy + (ey-sy)/2, ey, sx, sx+(ex-sx)/2, arr, 3);
        // System.out.println("third");
        int fourth = div(sy + (ey-sy)/2, ey, sx + (ex-sx)/2, ex, arr, 4);
        // System.out.println("fourth");
        
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