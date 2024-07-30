import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int n, x;
        n = Integer.parseInt(input[0]);
        x = Integer.parseInt(input[1]);
        input = br.readLine().split("\\s+");
        int[] income = new int[input.length];
        for(int i=0; i<income.length; i++){
            income[i] = Integer.parseInt(input[i]);
        }
        int left = 0;
        int right = x;
        int record = 0;
        for(int i=0; i<x; i++){
            record += income[i];
        }
        int cont = record==0?0:1;
        int answer = record;
        while(right < income.length){

            record -= income[left];
            record += income[right];
            if(answer < record){
                cont = 1;
                answer = record;
            }else if(answer == record && answer != 0){
                cont++;
            }
            left++;
            right++;
            
//            System.out.println(record);
        }
        if(record == 0){
            System.out.println("SAD");
        }else{
            System.out.println(answer);
            System.out.println(cont);
        }

    }
}