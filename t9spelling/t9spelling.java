import java.util.*;

public class t9spelling{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();
        int case_no = 0; 

        HashMap<String, String> encrypt = new HashMap<String, String>();

        //defining the hashmap
        encrypt.put("a", "2");
        encrypt.put("b", "22");
        encrypt.put("c", "222");
        encrypt.put("d", "3");
        encrypt.put("e", "33");
        encrypt.put("f", "333");
        encrypt.put("g", "4");
        encrypt.put("h", "44");
        encrypt.put("i", "444");
        encrypt.put("j", "5");
        encrypt.put("k", "55");
        encrypt.put("l", "555");
        encrypt.put("m", "6");
        encrypt.put("n", "66");
        encrypt.put("o", "666");
        encrypt.put("p", "7");
        encrypt.put("q", "77");
        encrypt.put("r", "777");
        encrypt.put("s", "7777");
        encrypt.put("t", "8");
        encrypt.put("u", "88");
        encrypt.put("v", "888");
        encrypt.put("w", "9");
        encrypt.put("x", "99");
        encrypt.put("y", "999");
        encrypt.put("z", "9999");
        encrypt.put(" ", "0");

        for (int i = 0; i < n; i++){
            String read = s.nextLine();
            String temp = "";
            String output = "";
            for (int j = 0; j < read.length(); j++){
                String ch = "" + read.charAt(j);
                temp = encrypt.get(ch);
                if (output.length() == 0 || output.charAt(output.length()-1) != temp.charAt(0)){
                    output += temp;
                }
                else{
                    output = output + " " + temp;
                }
            }
            case_no += 1;
            System.out.println("Case #" + case_no + ": " + output);
        }
    }
}