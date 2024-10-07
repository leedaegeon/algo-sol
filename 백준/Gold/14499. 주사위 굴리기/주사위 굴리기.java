import java.io.*;
import java.util.*;
public class Main {
	static final int[] dy = {0, 0, 0, -1, 1};
	static final int[] dx = {0, 1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int[][] dice = {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0}
		};
//		
//		soutDice(dice);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		int n, m, y, x, k;
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		y = Integer.parseInt(input[2]);
		x = Integer.parseInt(input[3]);
		k = Integer.parseInt(input[4]);
		int[][] map = new int[n][m];
		Point now = new Point(y,x);
		for(int i=0; i<n; i++) {
			input = br.readLine().split("\\s+");
			for(int j=0; j<input.length; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				
			}
		}
		String[] operation = br.readLine().split("\\s+");
		StringBuilder sb = new StringBuilder();

		for(String op: operation) {
			int dir = Integer.parseInt(op);
			Point next = new Point(now.y + dy[dir], now.x + dx[dir]);
			if(next.y < 0 || next.y >= n || next.x < 0 || next.x >= m) {
				continue;
			}
			dice = move(dice, dir);
			markBottom(dice, map, next);
			now = next;
			sb.append(dice[1][1] + "\n");
			
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb.toString());
	}
	public static void soutDice(int[][] dice) {
		for(int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(dice[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int[][] move(int[][] dice, int dir) {
		if(dir == 1) {
			dice = moveRight(dice);
		}else if(dir == 2) {
			dice = moveLeft(dice);
		}else if(dir == 3) {
			dice = moveUp(dice);
		}else {
			dice = moveDown(dice);
		}
		return dice;
	}
	public static int[][] moveDown(int[][] dice) {
		int[][] downDice = new int[4][3];
		
		downDice[0][1] = dice[3][1];
		downDice[1][1] = dice[0][1];
		downDice[2][1] = dice[1][1];
		downDice[3][1] = dice[2][1];
		downDice[1][0] = dice[1][0];
		downDice[1][2] = dice[1][2];
		
		return downDice;
	}
	public static int[][] moveUp(int[][] dice) {
		// TODO Auto-generated method stub
		int[][] upDice = new int[4][3];
		
		upDice[0][1] = dice[1][1];
		upDice[1][1] = dice[2][1];
		upDice[2][1] = dice[3][1];
		upDice[3][1] = dice[0][1];
		upDice[1][0] = dice[1][0];
		upDice[1][2] = dice[1][2];
		
		return upDice;
	}
	public static int[][] moveLeft(int[][] dice) {
		int[][] leftDice = new int[4][3];
		leftDice[0][1] = dice[0][1];
		leftDice[1][1] = dice[1][2];
		leftDice[2][1] = dice[2][1];
		leftDice[3][1] = dice[1][0];
		leftDice[1][0] = dice[1][1];
		leftDice[1][2] = dice[3][1];
		return leftDice;
	}
	public static int[][] moveRight(int[][] dice) {
		// TODO Auto-generated method stub
		int[][] rightDice = new int[4][3];
		rightDice[0][1] = dice[0][1];
		rightDice[1][1] = dice[1][0];
		rightDice[2][1] = dice[2][1];
		rightDice[3][1] = dice[1][2];
		rightDice[1][0] = dice[3][1];
		rightDice[1][2] = dice[1][1];
		
		return rightDice;
	}
	public static void markBottom(int[][] dice, int[][] map, Point now){
		if(map[now.y][now.x] == 0) {
			map[now.y][now.x] = dice[3][1];
		}else {
			dice[3][1] = map[now.y][now.x];
			map[now.y][now.x] = 0; 
		}
	}
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + "]";
		}
		
	}
}