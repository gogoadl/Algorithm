import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        while (true) {
          if (input.length()< 10) {
            String str = input.substring(0, input.length());  
            System.out.println(str);
            break;
          } else {
            String str = input.substring(0, 10);
            System.out.println(str);
            input = input.substring(10, input.length());
          }
        }
    }
}