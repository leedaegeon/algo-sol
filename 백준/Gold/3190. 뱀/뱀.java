import java.io.*;
import java.util.*;

public class Main {
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		Set<Point> apple = new HashSet<>();
		StringTokenizer st = null;
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			apple.add(new Point(y-1, x-1));
		}
		int l = Integer.parseInt(br.readLine());
		Queue<Op> opQ = new ArrayDeque<>();
		
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			opQ.add(new Op(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		Deque<Point> snake = new LinkedList<>();
		Set<Point> snakeSet = new HashSet<>();
		snake.addFirst(new Point(0, 0, 1));
		snakeSet.add(new Point(0, 0));

		int time = 0;
	
		while(true) {
			Point head = snake.peekFirst();
			int dir = head.dir;
			if(!opQ.isEmpty() && opQ.peek().time == time) {
				String nextDir = opQ.poll().dir;
				if(nextDir.equals("D")) {
					dir++;
					dir %= 4;
				}else {
					if(dir != 0) {
						dir--;
					}else {
						dir = 3;
					}
				}
			}
			
			int nexty = head.y + dy[dir];
			int nextx = head.x + dx[dir];
			Point next = new Point(nexty, nextx, dir);
			if(!checkWallAndBody(n, next, snakeSet)) {
				System.out.println(time+1);
				break;
			}
			 
			snake.addFirst(next);
			snakeSet.add(next);
			
			if(snake.size() > 1 && !apple.contains(next)) {
				Point tail = snake.pollLast();
				snakeSet.remove(tail);
			}else if(apple.contains(next)){
				apple.remove(next);
			}
			
			time++;
		}
	
	}
	
	
	public static boolean checkWallAndBody(int n, Point next, Set<Point> snakeSet) {
		
		if(next.y < 0 || next.y >= n || next.x < 0 || next.x >= n || snakeSet.contains(next)) {
			return false;
		}
		return true;
	}
	
	static class Point{
		int y;
		int x;
		int dir;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		public Point(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + "]";
		}
		
	}
	static class Op {
		int time;
		String dir;
		public Op(int time, String dir) {
			
			this.time = time;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "Op [time=" + time + ", dir=" + dir + "]";
		}
		
	}
}