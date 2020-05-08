package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FineRectangle {
    public long solution(int w, int h) {
        long answer = 1;

        long wlong = Long.parseLong(String.valueOf(w));
        long hlong = Long.parseLong(String.valueOf(h));
        BigInteger bigIntegerw = BigInteger.valueOf(wlong);
        BigInteger bigIntegerh = BigInteger.valueOf(hlong);
        long sum = wlong * hlong;

        long gcd = bigIntegerw.gcd(bigIntegerh).longValue();

        answer = sum - gcd * ((wlong/gcd) + (hlong/gcd) - 1);
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        FineRectangle f = new FineRectangle();
        f.solution(8,12);
    }
}
