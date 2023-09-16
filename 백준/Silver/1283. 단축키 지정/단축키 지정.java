import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Character> set = new ArrayList<>();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            boolean hasCommand = false;
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < input.length; j++) {
                if (!set.contains(Character.toLowerCase(input[j].charAt(0))) && !hasCommand) {
                    set.add(Character.toLowerCase(input[j].charAt(0)));
                    result.append(input[j]);
                    result.insert(0, "[");
                    result.insert(2, "]");
                    input[j] = result.toString();
                    hasCommand = true;
                    result.setLength(0);

                }
            }
            if (!hasCommand) {
                for (int j = 0; j < input.length; j++) {
                    for (int k = 0; k < input[j].length(); k++) {
                        if (!set.contains(Character.toLowerCase(input[j].charAt(k))) && !hasCommand) {
                            set.add(Character.toLowerCase(input[j].charAt(k)));
                            result.append(input[j]);
                            result.insert(k, "[");
                            result.insert(k+2, "]");
                            input[j] = result.toString();
                            hasCommand = true;
                            result.setLength(0);
                        }
                    }
                }
            }
            for (int j = 0; j < input.length; j++) {
                if (j == input.length -1) sb.append(input[j]);
                else sb.append(input[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}