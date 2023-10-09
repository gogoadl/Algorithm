import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String input = br.readLine();
        int sum = 0;
        
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        
        for(int i = chars.length - 1; i >= 0; i--) {
            int num = chars[i] - '0';
            sum += num;
            sb.append(num);
        }

        if(chars[0] != '0' || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sb.toString());
    }
}