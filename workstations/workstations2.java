import java.util.*;

public class workstations2{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int lines = io.getInt();
        int m = io.getInt();
        int output = 0;

        PriorityQueue<Integer> status = new PriorityQueue<Integer>();
        PriorityQueue<Timings> timings = new PriorityQueue<Timings>();

        for (int i = 0; i < lines; i++){
            int a = io.getInt();
            int b = io.getInt();
            timings.add(new Timings(a, b));
        }

        for (int i = 0; i < lines; i++){
            int time = timings.peek().get_arrive();
            while (status.size() > 0){
                if (status.peek() + m < time){
                    status.poll();
                }
                else{
                    break;
                }
            }
            if (status.size() > 0){
                int c = status.peek();
                int d = timings.peek().get_arrive();
                if (c <= d && d <= c + m){
                    output++;
                    status.poll();
                }
            }
            int leave = timings.poll().get_leave();
            status.add(leave);
        }
        io.println(output);
        io.close();  
    }  
}

class Timings implements Comparable<Timings>{
    public int arrive;
    public int duration;

    public Timings(int arrive, int duration){
        this.arrive = arrive;
        this.duration = duration;
    }

    public int get_arrive(){return this.arrive;}
    public int get_leave() {return this.arrive + this.duration;}

    public int compareTo(Timings t){
        if (this.arrive < t.arrive){
            return -1;
        }
        if (this.arrive > t.arrive){
            return 1;
        }
        else{
            return 0;
        }
    }
}