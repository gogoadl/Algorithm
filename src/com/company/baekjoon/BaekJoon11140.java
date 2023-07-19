package com.company.baekjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BaekJoon11140 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());
        // lol or lo ol or l o l else

        for (int i = 0; i < testCaseCount; i++) {
            String input = scanner.nextLine();
            if (input.contains("lol"))
                System.out.println(0);
            else if (input.contains("lo") || input.contains("ol") || input.contains("ll"))
                System.out.println(1);
            else if (!input.contains("l") && !input.contains("o"))
                System.out.println(3);
            else if(Pattern.matches(".*l.l.*", input))
                System.out.println(1);
            else
                System.out.println(2);
        }
    }
}
