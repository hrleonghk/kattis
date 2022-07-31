import java.util.*;

public class humancannonball{
    public static final double inf = Double.POSITIVE_INFINITY;
    public static double[] distances;
    public static boolean[] visited;


    public static double dijkstra(int n, double[][] matrix){
        distances = new double[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++){
            distances[i] = inf;
            visited[i] = false;
        }
        distances[0] = 0;

        for (int i = 0; i < n; i++){
            double min = inf;
            int minidx = -1;
            for (int j = 0; j < n; j++){
                if (distances[j] < min && !visited[j]){
                    min = distances[j];
                    minidx = j;
                }
            }
            visited[minidx] = true;
            for (int j = 0; j < n; j++){
                if (matrix[minidx][j] > 0 && !visited[j] && distances[j] > distances[minidx] + matrix[minidx][j]){
                    distances[j] = distances[minidx] + matrix[minidx][j];
                }
            }
        }
        return distances[n-1];
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        double x1 = io.getDouble();
        double y1 = io.getDouble();
        double x2 = io.getDouble();
        double y2 = io.getDouble();
        int n = io.getInt();
        double[][] coords = new double[n+2][2];
        double[][] matrix = new double[n+2][n+2];

        coords[0][0] = x1;
        coords[0][1] = y1;
        coords[n+1][0] = x2;
        coords[n+1][1] = y2;
        for (int i = 1; i <= n; i++){
            double x = io.getDouble();
            double y = io.getDouble();
            coords[i][0] = x;
            coords[i][1] = y;
        }

        for (int i = 0; i < n+2; i++){
            for (int j = i; j < n+2; j++){
                if (i == j){
                    matrix[i][j] = 0;
                }else if (i == 0 || j == 0){
                    double dist = Math.sqrt(Math.pow(coords[i][0]-coords[j][0], 2) + Math.pow(coords[i][1]-coords[j][1], 2));
                    matrix[i][j] = dist/5;
                    matrix[j][i] = dist/5;
                }else{
                    double dist = Math.sqrt(Math.pow(coords[i][0]-coords[j][0], 2) + Math.pow(coords[i][1]-coords[j][1], 2));
                    double time = Math.min(Math.abs(dist-50)/5+2, dist/5);
                    matrix[i][j] = time;
                    matrix[j][i] = time;
                }
            }
        }

        io.println(dijkstra(n+2, matrix));
        io.close();
    }
}