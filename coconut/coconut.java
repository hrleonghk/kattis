import java.util.*;

public class coconut{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int syllables = sc.nextInt();
        int people = sc.nextInt();
        int pointer = 0;
        ArrayList<Person> players = new ArrayList<Person>();

        for (int i = 1; i <= people; i++){
            players.add(new Person(i, "coconut"));
        }

        // for(int i = 0; i < players.size(); i++){
        //     System.out.print(players.get(i).get_id());
        //     System.out.println(players.get(i).get_hand());
        // }

        while(players.size() > 1){
            pointer = (pointer + syllables - 1) % players.size();
            int n = players.get(pointer).get_id();
            if (players.get(pointer).get_hand() == "coconut"){
                players.remove(pointer);
                players.add(pointer, new Person(n, "fist"));
                players.add(pointer, new Person(n, "fist"));
            }
            else if(players.get(pointer).get_hand() == "fist"){
                players.remove(pointer);
                players.add(pointer, new Person(n, "palm"));
                pointer++;
            }
            else if(players.get(pointer).get_hand() == "palm"){
                players.remove(pointer);
            }
        }

        System.out.println(players.get(0).get_id());
    }
}

class Person{
    int id;
    String hand;

    public Person(int id, String hand){
        this.id = id;
        this.hand = hand;
    }

    public int get_id(){
        return this.id;
    }

    public String get_hand(){
        return this.hand;
    }
}