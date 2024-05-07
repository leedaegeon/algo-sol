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
            
            if(h2<h){
                end = 1439;    
            }
            
            String title = musicInfos[idx][2];
            
            String tones = musicInfos[idx][3];
            int totalTime = tones.length();
            int sCnt = 0;
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i - sCnt < end - start; i++){
                
                sb.append(tones.charAt(i%totalTime));
                if(tones.charAt((i+1)%totalTime) != '#'){
                    sb.append(" ");
                }else{
                    sb.append("# ");
                    i++;
                    sCnt++;
                }
            }
            
            ls.add(new Music(start, end, title, sb.toString().split(" "), idx));
            idx++;
        }
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
        // System.out.println(Arrays.toString(mArr));
        for(Music music: ls){
            for(int left=0; left<music.tone.length; left++){
                if(mArr[0].equals(music.tone[left])){
                    int i = 1;
                    // System.out.print(left + " ");
                    for(int right = left+1; right < music.tone.length && i < mArr.length; right++){
                        
                        if(music.tone[right].equals(mArr[i])){
                            // System.out.print(right + " ");
                            i++;
                            
                        }else{
                            break;
                        }
                        
                    }
                    if(i == mArr.length){
                        answer = music.title;
                        return answer;
                    }
                    System.out.println(": " + i);
                   
                }
            }
            // System.out.println("===================");
        }
        answer = "(None)";
        return answer;
    }
    class Music implements Comparable<Music>{
        int start;
        int end;
        String title;
        String[] tone;
        int idx;
        Music(int start, int end, String title, String[] tone, int idx){
            this.start = start;
            this.end = end;
            this.title = title;
            this.tone = tone;
            this.idx = idx;
        }
        public int compareTo(Music m){
            int dur1 = this.end - this.start;
            int dur2 = m.end - m.start;
            if(dur1 == dur2){
                return this.idx - m.idx;
            }else{
                return dur2 - dur1;
            }
        }
        public String toString(){
            return start + " " + end + " " + title + " " + Arrays.toString(tone) +"| 전체 플레이 시간 " + (end - start) + "분\n";
        }
    }
}