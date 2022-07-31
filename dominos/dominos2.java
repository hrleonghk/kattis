// Leong Hung Rey A0249225A

import java.util.*;

public class dominos2{
    public static boolean[] visited1;
    public static boolean[] visited2;
    public static LinkedList<Integer> topo;
    public static ArrayList<ArrayList<Integer>> adj;

    public static void toposort(int v){ 
        visited1[v] = true;
        ArrayList<Integer> lst = adj.get(v);
        for (int i = 0; i < lst.size(); i++){
            if (!visited1[lst.get(i)]){
                toposort(lst.get(i)); //recursive procedure 
            }
        }
        topo.add(v);
    }

    public static void dfs(int v){
        visited2[v] = true;
        ArrayList<Integer> lst = adj.get(v);
        for (int i = 0; i < lst.size(); i++){
            if (!visited2[lst.get(i)]){
                dfs(lst.get(i)); //recursive procedure 
            }
        }
    }

    public static int output(){
        int output = 0;
        while (topo.size() > 0){
            int last = topo.removeLast();
            if (!visited2[last]){
                output++;
                dfs(last);
            }
        }
        return output;
    }
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int testcases = io.getInt();
        for (int cases = 0; cases < testcases; cases++){
            int n = io.getInt();
            int lines = io.getInt();
            int output = 0;
            visited1 = new boolean[n];
            visited2 = new boolean[n];
            topo = new LinkedList<>();
            adj = new ArrayList<>();

            for (int j = 0; j < n; j++){ //init 
                visited1[j] = false;
                visited2[j] = false;
                adj.add(new ArrayList<>());
            }
            
            for (int j = 0; j < lines; j++){ //read lines
                int a = io.getInt()-1;
                int b = io.getInt()-1;
                adj.get(a).add(b); // update neighbor of a
            }

            for (int j = 0; j < n; j++){ //toposort procedure
                if (!visited1[j]){
                    toposort(j);
                }
            }

            output = output();
            io.println(output);
        }
        io.close();
    }
}


