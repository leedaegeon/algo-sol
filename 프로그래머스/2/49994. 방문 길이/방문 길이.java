import java.util.*;
class Solution {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static boolean[][][] visited = new boolean[2][11][11];
    static Map<Character, Integer> operMap = new HashMap<>();
    static Set<Location> hs = new HashSet<>();
    static int answer = 0;
    
    public int solution(String dirs) {
        Location start = new Location(5,5);
        operMap.put('U', 0);
        operMap.put('D', 2);
        operMap.put('R', 1);
        operMap.put('L', 3);
        dfs(start, 0, dirs);
        return answer;
    }
    public void dfs(Location loc, int idx, String dirs){
        
        if(idx == dirs.length()){
            return;
        }

        int nexty = loc.y + di[operMap.get(dirs.charAt(idx))];
        int nextx = loc.x + dj[operMap.get(dirs.charAt(idx))];
        int a = loc.y*11 + loc.x;
        int b = nexty*11 + nextx;
        
        if(nexty < 0 || nexty >= 11 || nextx < 0 || nextx >= 11){
            // System.out.println("1"+dirs.charAt(idx) + " nexty: " + (nexty-5) + " nextx: " + (nextx-5) + " 처음 길: " +answer);    
            dfs(loc, idx+1, dirs);
        }else if(hs.contains(new Location(a,b))){
            // System.out.println("2"+dirs.charAt(idx) + " nexty: " + (nexty-5) + " nextx: " + (nextx-5) + " 처음 길: " +answer);
            dfs(new Location(nexty, nextx), idx+1, dirs);
        }else{
            answer++;
            // System.out.println("3"+dirs.charAt(idx) + " nexty: " + (nexty-5) + " nextx: " + (nextx-5) + " 처음 길: " +answer);
            
            hs.add(new Location(a,b));
            hs.add(new Location(b,a));
            dfs(new Location(nexty, nextx), idx+1, dirs);
        }
    }
    class Location{
        int y;
        int x;
        Location(int y, int x){
            this.y = y;
            this.x = x;
        }
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(o == null || this.getClass() != o.getClass()){
                return false;
            }
            Location location = (Location) o;
            return this.y == location.y && this.x == location.x;
        }
        public int hashCode(){
            return Objects.hash(y,x);
        }
    }
}