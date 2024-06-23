import java.util.*;
class Solution {
    static int[] answer = new int[11];
    static int p = 0;
    static int r = 0;
    static List<Node> ans = new ArrayList<>();
    public int[] solution(int n, int[] info) {
        for(int i=0; i<info.length; i++){
            if(info[i] != 0){
                p+=10-i;
            }
        }
        if(p==0){
            int[] a = {-1};
            return a;
        }
        combWithRep(0, 0, n, new int[info.length], info);
        // System.out.println(p + " " + r);
        if(r <= p || r<=0){
            int[] a = {-1};
            return a;
        }
        Collections.sort(ans);
        // for(Node a: ans){
        //     System.out.println(a);
        // }
        answer = ans.get(0).ls;
        return answer;
    }
    public void combWithRep(int idx, int cnt, int n, int[] point, int[] info){
        if(cnt == n){
            int peach = 0;
            int rion = 0;
            for(int i=0; i<point.length; i++){
                
                if(info[i] < point[i] && point[i] != 0){
                    rion += 10-i;

                }else if(info[i] >= point[i] && info[i] != 0){
                    peach += 10 - i;
                }
            }

            if(rion-peach >= r-p && rion-peach > 0){
                p = peach;
                r = rion;
                // for(int i=0; i<point.length; i++){
                //     answer[i] = point[i];
                // }
                int[] a = new int[answer.length];
                int last = 0;
                int cnt2 = 0;
                for(int i=0; i<answer.length; i++){
                    a[i] = point[i];
                    if(a[i] != 0){
                        last = 10 - i;
                        cnt2 = a[i];
                    }
                }
                ans.add(new Node(a, r, r-p, new Sub(last, cnt2)));
                
            
            }
            return;
        }
        for(int i=idx; i<point.length; i++){
            point[i]++;
            combWithRep(i, cnt+1, n, point, info);
            point[i]--;
        }
        
        
    }
    class Node implements Comparable<Node>{
        int[] ls;
        int r;
        int k;
        Sub s;
        public int compareTo(Node n){
            if(this.k == n.k){
                return this.s.compareTo(n.s);
            }else{
                return n.k - this.k;
            }
        }
        Node(int[] ls, int r, int k, Sub s){
            this.ls = ls;
            this.r = r;
            this.k = k;
            this.s = s;
        }
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<ls.length; i++){
                sb.append(ls[i]);
                sb.append(" ");
            }
            return sb + " " + k +" "+ s;
        }
    }
    class Sub implements Comparable<Sub>{
        int last;
        int cnt;
        Sub(int last, int cnt){
            this.last = last;
            this.cnt = cnt;
        }
        public int compareTo(Sub s){
            if(this.last == s.last){
                return s.cnt - this.cnt;
            }else{
                return this.last - s.last;
            }
        }
        public String toString(){
            return this.last +" "+ this.cnt;
        }
    }
}