import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> cranes = new ArrayList<>();
        ArrayList<Integer> baggages = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            baggages.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(cranes, Collections.reverseOrder());
        Collections.sort(baggages, Collections.reverseOrder());

        int time = 0;
        if (cranes.get(0) < baggages.get(0)) {
            System.out.println(-1);
            return;
        }

        while (!baggages.isEmpty()) {
            for (int i = 0; i < cranes.size(); i++) {
                int val = cranes.get(i);
                if (baggages.isEmpty()) break;
                if  (val < baggages.get(baggages.size()-1)) {
                    break;
                }
                for (int j = 0; j < baggages.size(); j++) {
                    int bag = baggages.get(j);
                    if (bag <= val) {
                        baggages.remove(j);
                        break;
                    }
                }
            }
            time++;
        }
        System.out.println(time);

    }
}

/*
3
10 6 5
11
6 8 9 6 8 6 9 6 8 6 9
 */