import java.util.*;

public class lostmap{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        Edge[] edges = new Edge[(n*n-n)/2];
        int counter = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (j <= i){
                    io.getInt();
                }
                else{
                    int curr = io.getInt();
                    edges[counter] = new Edge(i+1, j+1, curr);
                    counter++;
                }
            }
        }
        Arrays.sort(edges);
        counter = 0;
        int arrcounter = 0;

        UnionFind vertices = new UnionFind(n);
        while (counter < n-1){
            int x = edges[arrcounter].x;
            int y = edges[arrcounter].y;
            if (!vertices.isSameSet(x-1, y-1)){
                counter++;
                vertices.unionSet(x-1, y-1);
                io.println(x + " " + y);
            }
            arrcounter++;
        }

        io.close();
    }
}

class Edge implements Comparable<Edge>{
    int x;
    int y;
    int w;

    public Edge(int x, int y, int w){
        this.x = x;
        this.y = y;
        this.w = w;
    }

    public int compareTo(Edge other){
        return this.w-other.w;
    }
}

class UnionFind {                                              
    public int[] p;
    public int[] rank;
  
    public UnionFind(int N) {
      p = new int[N];
      rank = new int[N];
      for (int i = 0; i < N; i++) {
        p[i] = i;
        rank[i] = 0;
      }
    }
  
    public int findSet(int i) { 
      if (p[i] == i) return i;
      else {
        p[i] = findSet(p[i]);
        return p[i]; 
      } 
    }
  
    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
  
    public void unionSet(int i, int j) { 
      if (!isSameSet(i, j)) { 
        int x = findSet(i), y = findSet(j);
        // rank is used to keep the tree short
        if (rank[x] > rank[y]) 
            p[y] = x;
        else { 
            p[x] = y;
          if (rank[x] == rank[y]) 
            rank[y] = rank[y]+1; 
        } 
      } 
    }
  }