import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Reserve[] bookTime = new Reserve[book_time.length];
        
        for(int i=0; i<book_time.length; i++){
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
            int startMin = Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]);
            int endMin = Integer.parseInt(end[0])*60 + Integer.parseInt(end[1]) + 10;
            bookTime[i] = new Reserve(startMin, endMin);
        }
        Arrays.sort(bookTime);
        // for(Reserve a: bookTime){
        //     System.out.println(a);
        // }

        for(int i=0; i<bookTime.length; i++){
            int k=0;
            for(int j=i; j<bookTime.length; j++){
                if(bookTime[i].end > bookTime[j].start){
                    k++;
                }
            }
            answer = Math.max(answer, k);
        }
        return answer;
    }
    class Reserve implements Comparable<Reserve>{
        int start;
        int end;
        Reserve(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Reserve o){
            
            if(this.end == o.end){
                return this.start - o.start;
            }else{
                return this.end - o.end;
            }
            
        }
        public String toString(){
            return "시작 " + (start/60)+":" + (start%60)  + " 끝 "+ (end/60) + ":" + (end%60);
        }
    }
}