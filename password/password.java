import java.util.*;

public class password{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double m = 0;
        double output = 1;
        double[] prob = new double[n];
        
        for (int i = 0; i < n; i++){
            s.nextLine();
            s.next();
            prob[i] = s.nextDouble();
        }
        Arrays.sort(prob);
        
        for (int i = n-1; i >= 0; i--){
            output += m*prob[i];
            m += 1;
        }
        
        System.out.println(output);
    }
}