public class numberfun{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        for (int i = 0; i < n; i++){
            String in = s.nextLine();
            String[] str_abc = in.split(" ");
            int[] arr = new int[str_abc.length];
            for (int j = 0; j < str_abc.length; j++){
                arr[j] = Integer.valueOf(str_abc[j]);
            }
            Arrays.sort(arr);
            if (arr[0]+arr[1] == arr[2] || arr[0]*arr[1] == arr[2]){
                System.out.println("Possible");
            }
            else{
                System.out.println("Impossible");
            }
        }
    }
}