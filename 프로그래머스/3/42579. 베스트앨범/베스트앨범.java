import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, PriorityQueue<Music>> mMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            if(mMap.get(genres[i])==null){
                PriorityQueue<Music> pq = new PriorityQueue<>();
                pq.offer(new Music(i, genres[i], plays[i]));
                mMap.put(genres[i], pq);    
            }else{
                // System.out.println(mMap.get(genres[i]));
                mMap.get(genres[i]).offer(new Music(i, genres[i], plays[i]));
                
            }
        }
        PriorityQueue<Genre> pq = new PriorityQueue<>();
        for(Map.Entry<String, Integer> e: map.entrySet()){
            pq.offer(new Genre(e.getKey(), e.getValue()));
        }
        while(!pq.isEmpty()){
            String gen = pq.poll().name;
            PriorityQueue<Music> musicPQ = mMap.get(gen);
            for(int i=0; i<2 && !musicPQ.isEmpty(); i++){
                answer.add(musicPQ.poll().num);
            }
        }

        return answer;
    }
    class Music implements Comparable<Music>{
        int num;
        String genre;
        int play;
        Music(int num, String genre, int play){
            this.num = num;
            this.genre = genre;
            this.play = play;
        }
        public int compareTo(Music m){
            return m.play - this.play;
        }
        public String toString(){
            return num + " " + genre + " " + play + ", ";
        }
    }
    class Genre implements Comparable<Genre>{
        String name;
        int play;
        Genre(String name, int play){
            this.name = name;
            this.play = play;
        }
        public int compareTo(Genre g){
            return g.play - this.play;
        }
    }
}