import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int n = Integer.parseInt(number);
        boolean isContain = number.contains("7");
        boolean isDivisible = n % 7 == 0;

        if (!isContain && !isDivisible)
            System.out.println(0);
        else if (!isContain && isDivisible)
            System.out.println(1);
        else if (isContain && !isDivisible)
            System.out.println(2);
        else
            System.out.println(3);

    }
}