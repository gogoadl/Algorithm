import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String regExp = "(100+1+|01)+";
        String s = br.readLine();
        if (s.matches(regExp)) {
            System.out.println("SUBMARINE");
        } else
            System.out.println("NOISE");
    }
}