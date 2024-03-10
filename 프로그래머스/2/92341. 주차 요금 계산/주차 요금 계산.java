import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        String[][] recArr = new String[records.length][3];
        for(int i=0; i<records.length; i++){
            recArr[i] = records[i].split(" ");
        }
        
        Arrays.sort(recArr, (o1, o2) -> {
            if(o1[1].equals(o2[1])){
                int t1 = Integer.parseInt(o1[0].substring(0,2));
                int m1 = Integer.parseInt(o1[0].substring(3));
                int t2 = Integer.parseInt(o2[0].substring(0,2));
                int m2 = Integer.parseInt(o2[0].substring(3));
                if(t1>t2){
                    return 1;
                }else if(t1 == t2){
                    if(m1 > m2){
                        return 1;
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }else{
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }
        });
        
        // for(int i=0; i<recArr.length; i++){
        //     System.out.println(Arrays.toString(recArr[i]));
        // }
        Map<Integer, Queue<Node>> map = new TreeMap<>();
        for(int i=0; i<recArr.length; i++){
            map.put(Integer.parseInt(recArr[i][1]), new ArrayDeque<>());
        }
        int[] answer = new int[map.size()];
        
        for(int i=0; i<recArr.length; i++){
            int t = Integer.parseInt(recArr[i][0].substring(0,2));
            int m = Integer.parseInt(recArr[i][0].substring(3));
            boolean io = recArr[i][2].equals("IN") ? true : false;
            Queue<Node> q = map.get(Integer.parseInt(recArr[i][1]));
            q.offer(new Node(t,m,io));
            map.put(Integer.parseInt(recArr[i][1]), q);
        }
        int num=0;
        for(Map.Entry<Integer, Queue<Node>> e: map.entrySet()){
            // System.out.println("차량번호: "+e.getKey());
            Queue<Node> q = e.getValue();
            int price = 0;
            int totalTime = 0;
            while(!q.isEmpty()){
                Node n = q.poll();
//                 입차
                if(n.io){
                    if(q.isEmpty()){
//                         출차가 23:59
                        totalTime += (23-n.t)*60 + 59 - n.m;
                    }else{
                        Node n2 = q.poll();
                        int maxT = n2.t;
                        int minT = n.t;
                        int maxM = 0;
                        int minM = 0;
                        
                        if(n.m > n2.m){
                            maxT -= 1;
                            maxM = n2.m + 60;
                            minM = n.m;
                        }else{
                            maxM = n2.m;
                            minM = n.m;
                        }
                        
                        totalTime += (maxT - minT)*60 + maxM - minM;
                        
                    }
                }
            }
            price += fees[1];
                        
            if(totalTime> fees[0]){
                int addTime = (int)Math.ceil((totalTime - fees[0])*1.0/fees[2]*1.0);
                price += addTime*fees[3];
            }
            answer[num++] = price;
            
            // System.out.println(totalTime);

        }
        return answer;
    }
    
    class Node{
        int t;
        int m;
        boolean io;
        
        Node(int t, int m, boolean io){
            this.t = t;
            this.m = m;
            this.io = io;
        }
        
        public String toString(){
            if(this.io){
                return t+ "시 "+ m +"분 입차";
            }else{
                return t+ "시 "+ m +"분 출차";
            }
        }
    }
}