import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        String[][] musicInfos = new String[musicinfos.length][4];
        List<Music> ls = new ArrayList<>();
        
        int idx=0;
        for(String info : musicinfos){
            musicInfos[idx] = info.split(",");
            
            String[] startTime = musicInfos[idx][0].split(":");
            int h = Integer.parseInt(startTime[0])*60;
            int min = Integer.parseInt(startTime[1]);
            int start = h + min;
            
            String[] endTime = musicInfos[idx][1].split(":");
            int h2 = Integer.parseInt(endTime[0])*60;
            min = Integer.parseInt(endTime[1]);
            int end = h2 + min;
//             00:00을 넘겨서까지 재생되는 일은 없다.
            if(h2<h){
                end = 1439;    
            }
            
            String title = musicInfos[idx][2];
            
            String tones = musicInfos[idx][3];
            int totalTime = tones.length();
            int sCnt = 0;
            StringBuilder sb = new StringBuilder();
            
//             여기서 좀 고생했음
//             다음부터는 파싱해야 하는 문자열 길이가 두 가지인 경우 다른 알파벳으로 매핑해서 하자!
            for(int i=0; i - sCnt < end - start; i++){
//                 재생시간으로 인한 반복
                sb.append(tones.charAt(i%totalTime));

                if(tones.charAt((i+1)%totalTime) != '#'){
                    sb.append(" ");
                }else{
                    sb.append("# ");
                    i++;
                    sCnt++;
                }
            }
            
            ls.add(new Music(start, end, title, sb.toString().split(" ")));
            idx++;
        }
//         다 찾고나서 정렬하지 말고 정렬된 상태에서 가장 먼저 찾은 노래가 정답일 수 있도록
        Collections.sort(ls);
        // System.out.println(ls);
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<m.length(); i++){
            sb.append(m.charAt(i));
            if(i<m.length()-1 && m.charAt(i+1) != '#'){
                sb.append(" ");
            }
        }
        String[] mArr = sb.toString().split(" ");
        for(Music music: ls){

            for(int left=0; left<music.tone.length; left++){
//                 첫 음이 같으면
                if(mArr[0].equals(music.tone[left])){
                    int i = 1;
                    int next = -1;
//                     다음 음 체크
                    for(int right = left+1; right < music.tone.length && i < mArr.length; right++){
//                         다음음 체크중에 첫 음이랑 같은 경우가 있으면 다음 탐색할 지점으로 저장
                        if(next == -1 && music.tone[right].equals(mArr[0])){
                            next = right;
                        }                    
//                         다음 탐색 지점이 같은 음이면 그 다음 음으로 넘어감
                        if(music.tone[right].equals(mArr[i])){
                            i++;
                            
                        }else{
                            break;
                        }
                        
                    }
//                     탐색 지점이 내가 찾고자 하는 멜로디의 마지막인경우 리턴
                    if(i == mArr.length){
                        answer = music.title;
                        return answer;
                    }
//                     만약 다음 탐색 지점을 미리 찾았다면 거기로 점프
                   if(next!=-1){
                       i = next-1;
                   }
                }
            }
        }
        answer = "(None)";
        return answer;
    }
    class Music implements Comparable<Music>{
        int start;
        int end;
        String title;
        String[] tone;
        Music(int start, int end, String title, String[] tone){
            this.start = start;
            this.end = end;
            this.title = title;
            this.tone = tone;
        }

        public int compareTo(Music m){
            int dur1 = this.end - this.start;
            int dur2 = m.end - m.start;
            return dur2 - dur1;
        }
        public String toString(){
            return start + " " + end + " " + title + " " + Arrays.toString(tone) +"| 전체 플레이 시간 " + (end - start) + "분\n";
        }
    }
}