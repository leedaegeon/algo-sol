import java.io.*;
import java.math.BigDecimal;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
//		BufferedReader fr = new BufferedReader(new FileReader("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String line;
		List<Integer> ls = new ArrayList<>();		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			ls.add(Integer.parseInt(st.nextToken()));
		}
		
		int b,c;
		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		
		
		int[] arr = new int[ls.size()];
		long answer = ls.size();
//		BigDecimal answer = BigDecimal.valueOf(ls.size());
		for(int i=0; i<ls.size(); i++) {
			arr[i] = ls.get(i) - b;
			
			if(arr[i] > 0) {
				if(arr[i]%c != 0) {
					answer += arr[i]/c + 1;
//					answer = answer.add(BigDecimal.valueOf(arr[i]/c + 1));
				}else {
					answer += arr[i]/c;
//					answer = answer.add(BigDecimal.valueOf(arr[i]/c));
				}
			}
		}
		System.out.println(answer);
		
	}

}