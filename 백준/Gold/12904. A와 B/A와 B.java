import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String t = st.nextToken();

        int size = t.length()-1;

        for(int i = size; i >= s.length(); i--){
            char c = t.charAt(i);
            t = t.substring(0, i);
            if(c == 'B') {
                StringBuilder temp = new StringBuilder();
                for (int j = i-1; j>=0;j--)
                    temp.append(t.charAt(j));
                t = temp.toString();
            }
        }

        if(s.equals(t))
            System.out.println(1);
        else
            System.out.println(0);
    }
}