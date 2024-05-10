import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for(int i=1; i<arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
        }
        for(int i=1; i<arrayB.length; i++){
            gcdB = gcd(gcdB, arrayB[i]);
        }
        boolean flagA = true;
        boolean flagB = true;
        for(int i=0; i<arrayA.length; i++){
            if(arrayA[i]%gcdB == 0){
                flagB = false;
                break;
            }
        }
        for(int i=0; i<arrayB.length; i++){
            if(arrayB[i] %gcdA == 0){
                flagA = false;
                break;
            }
        }
        if(!flagA && !flagB){
            answer = 0;
        }else{
            answer = Math.max(gcdA, gcdB);
        }
        
        return answer;
    }
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
        
    }
}