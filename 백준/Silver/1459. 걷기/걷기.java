import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        long x =Integer.parseInt(inputs[0]);
        long y =Integer.parseInt(inputs[1]);
        long w =Integer.parseInt(inputs[2]); // 1블록 걷는데 걸린 시간
        long s =Integer.parseInt(inputs[3]); // 1블록 가로지르는데 걸린 시간

        long temp1,temp2,temp3;

        temp1 = (x+y) * w;

        temp2 = 0;

        if((x+y) % 2 == 0) temp2 = Math.max(x,y) * s;
        else temp2 = (Math.max(x,y) - 1) * s + w;

        temp3 = (Math.min(x, y))*s+(Math.abs(x-y))*w;

        System.out.println(Math.min(temp1, Math.min(temp2, temp3)));
    }
}