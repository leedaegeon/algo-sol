import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
//         1. 버스 시간표 제작
//         2. 버스 시간표에 따라 사람들 태우기
//         3-1. 마지막 버스 시간에 타는 사람이 m보다 적으면 answer에 마지막 버스 시간 저장
//         3-2. 마지막 버스에 탈 수 있는 사람이 m보다 크거나 같으면 answer에 마지막에 탈 수 있는 사람보다 1분 빠르게 answer에 저장
        int[] busTime = new int[n];
        int[] boontable = new int[timetable.length];
        for(int i=0; i<n; i++){
            busTime[i] = 540 + i*t;
        }
        for(int i=0; i<boontable.length; i++){
            String[] time = timetable[i].split(":");
            int si = Integer.parseInt(time[0])*60;
            int boon = Integer.parseInt(time[1]);
            boontable[i] = si+boon;
        }
        Arrays.sort(boontable);
        
        System.out.println(Arrays.toString(busTime));
        System.out.println(Arrays.toString(boontable));
        int lastBusCnt = 0;
        int j=0;
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0; i<busTime.length; i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0; i<busTime.length; i++){
            while(ls.get(i).size()<m && j<boontable.length){
                if(busTime[i] >= boontable[j]){
                    ls.get(i).add(j);
                    j++;
                }else{
                    break;
                }
            }
        }
        String T="";
        String M="";
        int num = 1;
        // for(List<Integer> bus: ls){
        //     System.out.print(num++ + ": ");
        //     for(int k:bus){
        //         System.out.print(boontable[k] + " ");
        //     }
        //     System.out.println();
        // }
        if(ls.get(ls.size()-1).size() < m){
            // answer = busTime[busTime.length-1];
            T = Integer.toString(busTime[busTime.length-1]/60);
            M = Integer.toString(busTime[busTime.length-1]%60);
            // System.out.println("막차시간");
            
        }else{
            int last = 0;
             for(List<Integer> bus: ls){

                for(int k:bus){
                    last = Math.max(boontable[k]-1, last);
                }
             }
            T = Integer.toString(last/60);
            M = Integer.toString(last%60);
        }
        if(T.length()==1){
            T = "0"+T;
        }
        if(M.length()==1){
            M = "0"+M;
        }
        answer = T+":"+M;
        
        return answer;
    }
}