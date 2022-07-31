import java.util.*;

public class millionairemadness{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int m = io.getInt();
        int n = io.getInt();
        int[][] matrix = new int[m][n];
        int[][] visited = new int[m][n];
        int[] nextX = {-1, 1, 0, 0};
        int[] nextY = {0, 0, -1, 1};
        int output = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = io.getInt();
                visited[i][j] = 0;
            }
        }
        while (visited[m-1][n-1] == 0){
            Node node = pq.poll();
            int x = node.getX();
            int y = node.getY();
            int z = node.getZ();
            if (visited[x][y] == 1){
                continue;
            }
            if (z > output){
                output = z;
            }
            visited[x][y] = 1;

            for (int i = 0; i < 4; i++){
                int tempX = x + nextX[i];
                int tempY = y + nextY[i];
                if (tempX < 0 || tempY < 0 || tempX >= m || tempY >= n){
                    continue;
                }
                if (visited[tempX][tempY] == 1){
                    continue;
                }
                pq.offer(new Node(tempX, tempY, matrix[tempX][tempY]-matrix[x][y]));
            }
        }
        io.println(output);
        io.close();
    }
}

class Node implements Comparable<Node>{
    int x;
    int y;
    int z;  
    public Node(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getZ(){
        return this.z;
    }

    public int compareTo(Node other){
        return (this.z - other.z);
    }
}