import java.util.*;

public class kattissquest{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int lines = io.getInt();
        TreeMap<Quest, Integer> map = new TreeMap<Quest, Integer>();
        for (int i = 0; i < lines; i++){
            String cmd = io.getWord();
            if (cmd.equals("add")){
                Quest quest = new Quest(io.getInt(), io.getInt());
                if (map.containsKey(quest)){
                    map.put(quest, map.get(quest)+1);
                }else{
                    map.put(quest, 1);
                }
            }else if (cmd.equals("query")){
                int x = io.getInt();
                long output = 0;
                while (true){
                    Quest quest = map.floorKey(new Quest(x, Integer.MAX_VALUE));
                    if (quest == null){
                        break;
                    }
                    x -= quest.getEnergy();
                    output += quest.getGold();
                    
                    if (map.get(quest) == 1){
                        map.remove(quest);
                    }else{
                        map.put(quest, map.get(quest)-1);
                    }
                }
                io.println(output);
            }
        }
        io.close();
    }
}

class Quest implements Comparable<Quest>{
    int e;
    int g;

    public Quest(int e, int g){
        this.e = e;
        this.g = g;
    }
    public int getEnergy(){return this.e;}
    public int getGold(){return this.g;}
    public int compareTo(Quest q){
        if (this.e < q.e){
            return -1;
        }else if (this.e > q.e){
            return 1;
        }else{
            if (this.g < q.g){
                return -1;
            }else if (this.g > q.g){
                return 1;
            }else{
                return 0;
            }
        }
    }
}