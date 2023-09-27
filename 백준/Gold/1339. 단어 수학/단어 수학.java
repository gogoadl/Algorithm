import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                arr[c-'A'] += Math.pow(10, input.length()-j) / 10;
            }
        }

        Arrays.sort(arr);

        int val = 9;
        int sum = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == 0) break;
            sum += arr[i] * val--;
        }
        System.out.println(sum);
    }
}