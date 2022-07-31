import java.util.*;

public class weakvertices{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        while (io.hasMoreTokens()){
            int[][] edges = new int[100][100];
            ArrayList<Integer> output = new ArrayList<>();
            int n = io.getInt();
            if (n == -1){
                break;
            }

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    int a = io.getInt();
                    edges[i][j] = a;
                }
            }

            for (int i = 0; i < n; i++){
                ArrayList<Integer> neighbors = new ArrayList<>(); 
                for (int j = 0; j < n; j++){
                    if (edges[i][j] == 1){
                        neighbors.add(j);
                    }
                }
                if (neighbors.size() < 2){
                    output.add(i);
                }else{
                    boolean weak = true;
                    for (int j = 0; j < neighbors.size(); j++){
                        if (weak == false){
                            break;
                        }
                        for (int k = 0; k < n; k++){
                            if (edges[neighbors.get(j)][k] == 1 && neighbors.contains(k)){
                                weak = false;
                            }
                        }
                    }
                    if (weak == true){
                        output.add(i);
                    }
                }
            }  
            for (int i = 0; i < output.size(); i++){
                if (i != output.size()-1){
                    io.print(output.get(i) + " ");
                }else{
                    io.println(output.get(i));
                }
            }
        }
        io.close();
    }
}
