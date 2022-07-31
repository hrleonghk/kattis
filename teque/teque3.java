import java.util.*;

public class teque3{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int[] front = new int[1000000];
        int[] back = new int[1000000];
        int f_head = 500000;
        int f_tail = 500001;
        int b_head = 500000;
        int b_tail = 500001;

        for (int i = 0; i < n; i++){
            String cmd = io.getWord();
            int ele = io.getInt();
            if (cmd.equals("push_back")){
                back[b_tail] = ele;
                b_tail++;
            }else if (cmd.equals("push_front")){
                front[f_head] = ele;
                f_head--;
            }else if (cmd.equals("push_middle")){
                front[f_tail] = ele;
                f_tail++;
            }else if(cmd.equals("get")){
                if (ele < f_tail-f_head-1){
                    System.out.println(front[ele + f_head + 1]);
                }else{
                    System.out.println(back[ele + b_head - (f_tail-f_head-1)+1]);
                }
            }
            if (f_tail-f_head < b_tail-b_head){
                b_head++;
                front[f_tail] = back[b_head];
                back[b_head] = 0;
                f_tail++;
            }else if (f_tail-f_head > b_tail-b_head+1){
                f_tail--;
                back[b_head] = front[f_tail];
                front[f_tail] = 0;
                b_head--;
            }
        }
        
        io.close();
    }
}