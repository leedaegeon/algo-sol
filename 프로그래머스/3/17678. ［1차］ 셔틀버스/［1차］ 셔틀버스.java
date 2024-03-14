import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {

//         1. 버스 시간표 제작
//         2. 버스 시간표에 따라 사람들 태우기
//         3-1. 마지막 버스 시간에 타는 사람이 m보다 적으면 answer에 마지막 버스 시간 저장
//         3-2. 마지막 버스에 탈 수 있는 사람이 m이랑 같으면 가장 늦게 탈 수 있는 버스 탐색
        int[] busTime = new int[n];
        int[] boontable = new int[timetable.length];
        
//         첫 차부터 막차까지 배열에 저장
        for(int i=0; i<n; i++){
            busTime[i] = 540 + i*t;
        }
//         String, 24시간 형식을 int, 60분 형식으로변환
        for(int i=0; i<boontable.length; i++){
            String[] time = timetable[i].split(":");
            int si = Integer.parseInt(time[0])*60;
            int boon = Integer.parseInt(time[1]);
            boontable[i] = si+boon;
        }
//         먼저 기다린 사람 오름차순으로 정렬
        Arrays.sort(boontable);
        
//         boontable 인덱스로 사용할 qustn
        int j=0;
        
//         각 버스별로 탈 수 있는 사람들 기록하기 위한 리스트
        List<List<Integer>> ls = new ArrayList<>();

//         버스 선택
        for(int i=0; i<busTime.length; i++){
            ls.add(new ArrayList<>());
//             현재 버스에 탄 사람이 m보다 작고, 못탄 사람들 남았을 때
            while(ls.get(i).size()<m && j<boontable.length){
                
//                 버스 시간보다 일찍 나와 기다린 사람이면 태움
                if(busTime[i] >= boontable[j]){
                    ls.get(i).add(j);
                    j++;
                }else{
//                     버스 놓침
                    break;
                }
            }
        }
        String T="";
        String M="";
        StringBuilder sb = new StringBuilder();
//         마지막 버스에 사람 더 탈 수 있는 경우
        if(ls.get(ls.size()-1).size() < m){
            T = Integer.toString(busTime[busTime.length-1]/60);
            M = Integer.toString(busTime[busTime.length-1]%60);            
        }
//          마지막버스까지 만차여서 마지막으로 탈 수 있는 버스 탐색
        else{
            int last = 0;
             for(List<Integer> bus: ls){
                for(int num:bus){
                    last = Math.max(boontable[num]-1, last);
                }
             }
            T = Integer.toString(last/60);
            M = Integer.toString(last%60);
        }
        
        if(T.length()==1){
            sb.append("0");
            
        }
        sb.append(T);
        sb.append(":");
        if(M.length()==1){
            sb.append("0");
        }
        sb.append(M);
        
        return sb.toString();
    }
}