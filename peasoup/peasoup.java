import java.util.*;

public class peasoup{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        //number of restaurats
        int no_res = s.nextInt();
        boolean flag = false;
        
        for (int i = 1; i <= no_res; i++){
            int menu_size = s.nextInt();
            s.nextLine();
            String res_name = s.nextLine();
            boolean soup, cake;
            soup = false;
            cake = false;
            for (int j = 1; j <= menu_size; i++){
                String ln = s.nextLine();
                if (ln.equals("pea soup")){
                    soup = true;
                }
                else if (ln.equals("pancakes")){
                    cake = true;
                }
            }
            if (soup && cake){
                System.out.println(res_name);
                flag = true;
                break;
            }
        }
        if (flag = false){
            System.out.println("Anywhere is fine I guess");
        }
    }
}