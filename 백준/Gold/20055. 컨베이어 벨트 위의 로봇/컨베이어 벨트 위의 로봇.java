import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;

    public static class Belt {
        int durability;
        boolean hasRobot;
        public Belt(int durability) {
            this.durability = durability;
        }

        @Override
        public String toString() {
            return durability+"";
        }
    }
    static ArrayList<Belt> topConvayor = new ArrayList<>();
    static ArrayDeque<Belt> bottomConvayor = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int loopCount = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            topConvayor.add(new Belt(Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < N; i++) {
            bottomConvayor.add(new Belt(Integer.parseInt(st.nextToken())));
        }
        
        while (K > 0) {
            loopCount++;
            moveBelt();
            lowerRobot();
            moveRobot();
            lowerRobot();
            raiseRobot();

        }
        System.out.println(loopCount);
    }
    public static void moveBelt() {
        topConvayor.add(0, bottomConvayor.pollLast());
        bottomConvayor.addFirst(topConvayor.get(N));
        topConvayor.remove(N);
    }
    public static void moveRobot() {
        for (int i = N-1; i > 0; i--) {
            Belt currentBelt = topConvayor.get(i-1);
            Belt nextBelt = topConvayor.get(i);
            if (currentBelt.hasRobot && !nextBelt.hasRobot && nextBelt.durability >= 1) {
                // 현재 벨트위에 로봇이 있고, 다음 벨트에 로봇이 없으며 내구도가 1이상이라면 로봇을 이동시킬 수 있다.
                currentBelt.hasRobot = false;
                nextBelt.hasRobot = true;
                nextBelt.durability -= 1;
                if (nextBelt.durability == 0) {
                    K--;
                }
            }

        }
    }
    public static void raiseRobot() {
        Belt b = topConvayor.get(0);
        if (!b.hasRobot && b.durability >= 1) { // 0번째 벨트에 로봇이 없고, 내구도가 1이상이라면 로봇을 올릴 수 있다.
            topConvayor.get(0).hasRobot = true;
            topConvayor.get(0).durability -= 1;
            if (topConvayor.get(0).durability == 0) {
                K--;
            }
        }
    }
    public static void lowerRobot() {
        topConvayor.get(N-1).hasRobot = false;
    }
}