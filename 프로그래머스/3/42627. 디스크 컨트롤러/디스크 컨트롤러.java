import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Process> pq = new PriorityQueue<>();
        
        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0];
            }
        });
    
        int t = 0;
        int time = 0;
        int idx = 0;
        while(idx<jobs.length || !pq.isEmpty()){
            
            for(int i=idx; i<jobs.length; i++){
                if(jobs[i][0] <= t){
                    // System.out.println(jobs[i][0] + " " + jobs[i][1]);
                    pq.offer(new Process(jobs[i][0], jobs[i][1]));
                    idx++;
                }
                
            }
            if(!pq.isEmpty()){
                Process p = pq.poll();
                time += t - p.start + p.duration;
                t += p.duration;
            }else{
                t++;
            }
            // System.out.println(t);
        
        }
        
        answer = (int)Math.floor(time / jobs.length);
        return answer;
    }
    
    class Process implements Comparable<Process>{
        int start;
        int duration;
        
        Process( int start, int duration){
            this.start = start;
            this.duration = duration;
        }
        public int compareTo(Process o2){
            if(this.duration == o2.duration){
                return this.start - o2.start;
            }else{
                return this.duration - o2.duration;
            }
        }
    }
}