import java.util.*;

public class conformity{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        HashMap<String, Integer> freq = new HashMap<>();
        int max = -1;
        int output = 0;
        
        for (int i = 0; i < n; i++){
            int[] a = new int[5];
            for (int j = 0; j < 5; j++){
                a[j] = io.getInt();
            }
            Arrays.sort(a);
            
            String temp = "";

            for (int x: a){
                temp += String.valueOf(x); 
            }

            if (freq.containsKey(temp)){
                freq.put(temp, freq.get(temp)+1);
            }else{
                freq.put(temp, 1);
            }
        }

        for (Integer y: freq.values()){
            int b = y;
            if (b > max){
                max = b;
                output = b;
            }else if (b == max){
                output += b;
            }
        }
        System.out.println(output);

        io.close();
    }
}