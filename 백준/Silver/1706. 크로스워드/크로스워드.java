import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        int R = Integer.parseInt(size[0]);
        int C = Integer.parseInt(size[1]);
        char[][] array = new char[R][C];
        for (int i = 0; i < R; i++) {
            array[i] = br.readLine().toCharArray();
        }
        LinkedList<String> list = new LinkedList<>();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < R; i++) {
            buf.setLength(0);
            for (int j = 0; j < C; j++) {
                if (array[i][j] == '#') {
                    if (buf.length() != 0) {
                        if (buf.length() > 1) list.add(buf.toString());
                        buf.setLength(0);
                    }
                } else {
                    buf.append(array[i][j]);
                }
            }
            if (buf.length() > 1) list.add(buf.toString());
        }
        for (int i = 0; i < C; i++) {
            buf.setLength(0);
            for (int j = 0; j < R; j++) {
                if (array[j][i] == '#') {
                    if (buf.length() != 0) {
                        if (buf.length() > 1) list.add(buf.toString());
                        buf.setLength(0);
                    }
                } else {
                    buf.append(array[j][i]);
                }
            }
            if (buf.length() > 1)
                list.add(buf.toString());
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}