import java.util.*;

public class akcija{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] prices = new int[n];
        int output = 0;
        
        for (int i = 0; i < n; i++){
            prices[i] = s.nextInt();
        }
        Arrays.sort(prices);
        
        for (int i = 0; i < prices.length/2; i++){
            int temp = prices[i];
            prices[i] = prices[prices.length - i - 1];
            prices[prices.length - i - 1] = temp;
        }
        
        for (int i = 0; i < n; i++){
            if (i % 3 != 2){
                output += prices[i];
            }
        }
        
        System.out.println(output);
    }
}