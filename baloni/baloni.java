import java.util.*;
import java.io.*;

public class baloni{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        int output = 0;
        int[] h = new int[1000000];
        for (int i = 0; i < 1000000; i++){
            h[i] = 0;
        }
//        List<Integer> heights = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            list.add(Integer.parseInt(arr[i]));
        }
        
        for (int i = 0; i < n; i++){
            int x = list.get(i);
            if (h[x] == 0){
                output += 1;
                h[x-1] += 1;
            }
            else{
                h[x] -= 1;
                h[x-1] += 1;
            }
            
        }
        
        System.out.println(output);
    }
}