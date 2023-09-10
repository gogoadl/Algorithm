import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        double dist = Math.sqrt(X*X+Y*Y);
        double result = dist;

        if (T > D) {
            System.out.println(dist + "\n");
        } else {
            int jump = (int) dist / D;

            double time = dist - D * jump;

            result = Math.min(result, time + T * jump);

            result = Math.min(result, D * (jump + 1) - dist + T * (jump + 1));

            if (jump > 0)
                result = Math.min(result, (double) (jump + 1) * T);
            else
                result = Math.min(result, T * 2.0);
            System.out.println(result + "\n");
        }
    }
}