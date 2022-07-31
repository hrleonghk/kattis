import java.util.*;

public class cardtrading{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int cards = s.nextInt(); //number of cards in hand
        int combos = s.nextInt(); //number of combos available
        int want = s.nextInt(); //number of combos wanted
        long output = 0; //output
        ArrayList<int[]> arrList = new ArrayList<int[]>(); //to store buy,sell pairs

        s.nextLine();

        int[] freq = new int[combos];

        for (int i = 0; i < combos; i++){
            freq[i] = 0; //init
        }

        for (int i = 0; i < cards; i++){
            int c = s.nextInt();
            freq[c-1] += 1; //freq of each card
        }

        s.nextLine();

        for (int i = 0; i < combos; i++){
            int a = s.nextInt();
            int b = s.nextInt();

            int buy = a*(2-freq[i]); //amount paid to form combo
            int sell = b*(freq[i]); //amount gained if all cards of same type sold
            int[] cost = new int[] {buy, sell};
            arrList.add(cost);
        }

        Collections.sort(arrList, new Comparator<int[]>(){
            public int compare(int[] x, int[] y){
                return x[0]+x[1]-y[0]-y[1]; //sort based on sum of buy and sell
            }
        });

        for (int i = 0; i < arrList.size(); i++){
            if (i < want){
                output -= (long) arrList.get(i)[0]; //buy the first K combos
            }
            else{
                output += (long) arrList.get(i)[1]; //sell the rest
            }
        }
        System.out.println(output);
    }
}