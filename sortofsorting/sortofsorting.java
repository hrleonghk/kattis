import java.util.*;

public class sortofsorting{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean flag = false;

        while (true){
            int n = s.nextInt();
            if (n == 0){
                break;
            }

            if (flag == false){
                flag = true;
            }
            else{
                System.out.println();
            }

            s.nextLine();
            String[] names = new String[n];

            for (int i = 0; i < n; i++){
                names[i] = s.nextLine();
            }

            for (int i = 1; i < names.length; i++){
                boolean isSorted = true;
                for (int j = 0; j < names.length - i; j++){
                    if ((int) names[j].charAt(0) > (int) names[j+1].charAt(0)){
                        String temp = names[j];
                        names[j] = names[j+1];
                        names[j+1] = temp;
                        isSorted = false;
                    }
                    else if((int) names[j].charAt(0) == (int) names[j+1].charAt(0)){
                        if ((int) names[j].charAt(1) > (int) names[j+1].charAt(1)){
                            String temp = names[j];
                            names[j] = names[j+1];
                            names[j+1] = temp;
                            isSorted = false;
                        }
                    }
                }
                if (isSorted) break;
            }

            for (String str: names){
                System.out.println(str);
            }
        }
    }
}