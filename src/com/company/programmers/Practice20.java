package com.company.programmers;

public class Practice20 { // 다음 큰 숫자
    public int solution(int n) {
        int answer = 0;
        int n2 = n;
        int cnt = 0;
        String binaryString = Integer.toBinaryString(n);

        for(int i = 0; i < binaryString.length(); i++)
        {
            if(binaryString.charAt(i) == '1')
                cnt++;
        }

        while (true)
        {

            int cnt2 = 0;
            String binary = Integer.toBinaryString(n2);


            for (int i = 0; i < binary.length(); i++) {
                if(binary.charAt(i) == '1')
                    cnt2++;
            }
            if(cnt == cnt2 && n2 > n)
            {
                answer = n2;
                break;
            }
            n2++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Practice20 practice20 = new Practice20();
        practice20.solution(78);
    }
}
