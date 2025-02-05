import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] preOrdered;
    static int[] inOrdered;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            preOrdered = new int[n+1];
            inOrdered = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                preOrdered[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                inOrdered[j] = Integer.parseInt(st.nextToken());
            }
            getPostOrdered(0,0,n);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void getPostOrdered(int root, int start, int end) {
        int rootIndex = preOrdered[root];
        for (int i = start; i < end; i++) {
            if (inOrdered[i] == rootIndex) {
                getPostOrdered(root+1, start, i);
                getPostOrdered(root+i+1-start, i+1, end);
                sb.append(rootIndex + " ");
            }

        }
    }
}
