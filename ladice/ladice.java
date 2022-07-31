import java.util.*;

public class ladice{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int items = io.getInt();
        int drawers = io.getInt();

        UnionFind ufds = new UnionFind(drawers);
        for (int i = 0; i < items; i++){
            int a = io.getInt() - 1;
            int b = io.getInt() - 1;
            ufds.unionSet(a, b);
            int c = ufds.findSet(a);
            if (ufds.count[c]< ufds.size[c]){
                ufds.count[c]++;
                io.println("LADICA");
            }else{
                io.println("SMECE");
            }
        }
        io.close();
    }
}

class UnionFind {                                              
    public int[] p;
    public int[] rank;
    public int[] count;
    public int[] size;
  
    public UnionFind(int N) {
      p = new int[N];
      rank = new int[N];
      count = new int[N];
      size = new int[N];
      for (int i = 0; i < N; i++) {
        p[i] = i;
        rank[i] = 0;
        count[i] = 0;
        size[i] = 1;
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
          if (rank[x] > rank[y]){
            p[y] = x;
            size[x] += size[y];
            count[x] += count[y];
          } 
          else { 
              p[x] = y;
              size[y] += size[x];
              count[y] += count[x];
            if (rank[x] == rank[y]){
                rank[y] = rank[y]+1;
            } 
          } 
        } 
      }
  }