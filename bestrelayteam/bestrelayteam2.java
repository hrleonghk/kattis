import java.util.*;

public class bestrelayteam2{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        Runner[] runners = new Runner[n];
        Runner[] output = new Runner[4];
        double time = -1;

        for (int i = 0; i < n; i++){
            String name = s.next();
            double t1 = s.nextDouble();
            double t2 = s.nextDouble();
            runners[i] = new Runner(name, t1, t2);
        }

        Arrays.sort(runners);
    
        for (int i = 0; i < n; i++){
            Runner[] temp = new Runner[4];
            temp[0] = runners[i];
            int idx = 0;
            for (int j = 1; j < 4; j++){
                if (idx == i){
                    idx += 1;
                }
                temp[j] = runners[idx];
                idx += 1;
            }

            if (time < 0 || temp[0].getT1() + temp[1].getT2() + temp[2].getT2() + temp[3].getT2() < time){
                time = temp[0].getT1() + temp[1].getT2() + temp[2].getT2() + temp[3].getT2();
                output = temp;
            }
        }

        System.out.println(time);
        for (int i = 0; i < 4; i++){
            System.out.println(output[i].getName());
        }
    }
}

class Runner implements Comparable<Runner>{
    String name;
    double t1;
    double t2;

    public Runner(String name, double t1, double t2){
        this.name = name;
        this.t1 = t1;
        this.t2 = t2;
    }

    public String getName(){
        return this.name;
    }

    public double getT1(){
        return this.t1;
    }

    public double getT2(){
        return this.t2;
    }

    public int compareTo(Runner r){
        if (this.t2 < r.t2){
            return -1;
        }
        else if (this.t2 > r.t2){
            return 1;
        }
        else{
            return 0;
        }
    }
}