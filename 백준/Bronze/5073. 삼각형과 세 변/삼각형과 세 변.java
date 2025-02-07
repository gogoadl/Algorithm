import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            Integer first = Integer.parseInt(st.nextToken());
            Integer second = Integer.parseInt(st.nextToken());
            Integer third = Integer.parseInt(st.nextToken());
            if (first == 0 && second == 0 && third == 0) break;
            int max = Math.max(first, Math.max(second, third));
            if (first.equals(second) && second.equals(third)) {
                System.out.println("Equilateral");
            } else if ((first == max && first >= second + third)
                    || (second == max && second >= first + third)
                    || (third == max && third >= first + second)) {
                System.out.println("Invalid");
            } else if (first.equals(second) || second.equals(third) || first.equals(third))
                System.out.println("Isosceles");
            else 
                System.out.println("Scalene");
            
        }
    }
}
