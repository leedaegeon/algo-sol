import java.util.*;
class Solution {
    static List<Node> ls = new ArrayList<>();
    public int[][] solution(int n) {
        
        hanoi(n, 1, 3, 2);
        System.out.println(ls);
        int[][] answer = new int[ls.size()][2];
        for(int i=0; i<ls.size(); i++){
            answer[i][0] = ls.get(i).start;
            answer[i][1] = ls.get(i).end;
        }
        return answer;
    }
    public void hanoi(int n, int start, int end, int mid){
        if(n==1){
            ls.add(new Node(start, end));
            return;
        }
        hanoi(n-1, start, mid, end);
        hanoi(1, start, end, mid);
        hanoi(n-1, mid, end, start);
    }
    class Node{
        int start;
        int end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        public String toString(){
            return this.start + "->" + this.end;
        }
    }
}