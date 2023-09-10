package com.company.baekjoon;

public class Billiards {
    public static void main(String[] args) {
        int[] hole = new int[] {0,0};
        int[] me = new int[] {30,30};
        int[] target = new int[] {10,10};
        int r = 3;
        int holeMeX = Math.abs(hole[0]- me[0]);
        int holeMeY = Math.abs(hole[1] - me[1]);
        double a = Math.sqrt(Math.pow(holeMeX,2) + Math.pow(holeMeY,2));

        int holeTargetX = Math.abs(hole[0]- target[0]);
        int holeTargetY = Math.abs(hole[1] - target[1]);
        double b = Math.sqrt(Math.pow(holeTargetX,2) + Math.pow(holeTargetY,2));

        int meTargetX = Math.abs(target[0]- me[0]);
        int meTargetY = Math.abs(target[1] - me[1]);
        double c = Math.sqrt(Math.pow(meTargetX,2) + Math.pow(meTargetY,2));

        double d = Math.sqrt(Math.pow(hole[0]-me[0], 2) + Math.pow(hole[1]-me[1], 2));
        double ga = Math.atan(holeMeY/holeMeX);
        double na = Math.acos(Math.pow(a,2) + Math.pow(d,2) - Math.pow(b + 2 * r, 2) / 2*a*d);
        double da = Math.acos(Math.pow(a,2) + Math.pow(b,2) - Math.pow(c,2) / 2*a*b);

        double direction = ga + na;
        double degree = Math.toDegrees(direction);
        System.out.println(String.format("%f", direction));
    }
}
