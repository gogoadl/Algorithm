import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] l;
    static int[] r;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        l = new int[n+1];
        r = new int[n+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            int leftVal = Integer.parseInt(st.nextToken());
            int rightVal = Integer.parseInt(st.nextToken());
            l[val] = leftVal;
            r[val] = rightVal;
        }

        System.out.println(2*(n-1) - getDepth(1,0));
    }
    static int getDepth(int val, int depth) {
        if (r[val] != -1) return getDepth(r[val], depth+1);
        return depth;
    }
}
