import java.util.*;

public class islands{
    public static boolean[][] visited;
    public static char[][] matrix;
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int r = io.getInt();
        int c = io.getInt();
        matrix = new char[r][c];
        visited = new boolean[r][c];
        LinkedList<Coordinates> land = new LinkedList<>();
        int output = 0;
        for (int i = 0; i < r; i++){
            String input = io.getWord();
            for (int j = 0; j < c; j++){
                matrix[i][j] = input.charAt(j);
                visited[i][j] = false;
                if (matrix[i][j] == 'L'){
                    land.add(new Coordinates(i, j));
                }
            }
        }

        while (land.size() > 0){
            Coordinates current = land.removeLast();
            if (!visited[current.x][current.y]){
                output++;
                bfs(current);
            }
        }

        io.println(output);
        io.close();
    }

    public static void bfs(Coordinates c){
        LinkedList<Coordinates> neighbors = new LinkedList<>();
        int[] nextX = {-1, 1, 0, 0};
        int[] nextY = {0, 0, -1, 1};
        neighbors.add(c);
        visited[c.x][c.y] = true;

        while(neighbors.size() > 0){
            Coordinates current = neighbors.removeLast();
            int x = current.x;
            int y = current.y;
            for (int i = 0; i < 4; i++){
                int tempX = x + nextX[i];
                int tempY = y + nextY[i];
                if (tempX < 0 || tempY < 0 || tempX >= matrix.length || tempY >= matrix[0].length){
                    continue;
                }else if (visited[tempX][tempY] || matrix[tempX][tempY] == 'W'){
                    continue;
                }else{
                    neighbors.add(new Coordinates(tempX, tempY));
                    visited[tempX][tempY] = true;
                }
            }
            
        }
    }
}

class Coordinates{
    int x;
    int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
}