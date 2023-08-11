package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1873 {
    static int H;
    static int W;
    static int currentH = 0;
    static int currentW = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int testCaseCount = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= testCaseCount; i++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            char[][] map = new char[H][W];

            for (int j = 0; j < H; j++) {
                st = new StringTokenizer(br.readLine());
                char[] chars = st.nextToken().toCharArray();
                for (int k = 0; k < chars.length; k++) {
                    map[j][k] = chars[k];
                    if (map[j][k] == '<' ||
                            map[j][k] == '>' ||
                            map[j][k] == '^' ||
                            map[j][k] == 'v') {
                        currentH = j;
                        currentW = k;
                    }
                }
            }
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            char[] commands;
            st = new StringTokenizer(br.readLine());
            commands = st.nextToken().toCharArray();
            int commandIndex = 0;
            while(commandIndex < command) {
                char cmd = commands[commandIndex++];
                tankMove(map, cmd);
                shoot(map, cmd);
            }
            sb.append(String.format("#%d ", i));
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    sb.append(map[j][k]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    private static void tankMove(char[][] map, char command) {
        if (command == 'U') { // up이면, 탱크 모양을 바꾸고, 이동가능한지 확인하고, 이동가능하면 이동
            map[currentH][currentW] = '^';
            if (currentH-1 >= 0) { // 이동가능
                char target = map[currentH-1][currentW];
                if (target == '.') {
                    map[currentH][currentW] = '.';
                    currentH -=1; // 현재탱크위치 변경
                    map[currentH][currentW] = '^';
                }
            }
        } else if (command == 'D') {
            map[currentH][currentW] = 'v';
            if (currentH+1 < H) { // 이동가능
                char target = map[currentH+1][currentW];
                if (target == '.') {
                    map[currentH][currentW] = '.';
                    currentH +=1; // 현재탱크위치 변경
                    map[currentH][currentW] = 'v';
                }
            }
        } else if (command == 'L') {
            map[currentH][currentW] = '<';
            if (currentW-1 >= 0) { // 이동가능
                char target = map[currentH][currentW-1];
                if (target == '.') {
                    map[currentH][currentW] = '.';
                    currentW -=1; // 현재탱크위치 변경
                    map[currentH][currentW] = '<';
                }
            }
        } else if (command == 'R') {
            map[currentH][currentW] = '>';
            if (currentW+1 < W) { // 이동가능
                char target = map[currentH][currentW+1];
                if (target == '.') {
                    map[currentH][currentW] = '.';
                    currentW +=1; // 현재탱크위치 변경
                    map[currentH][currentW] = '>';
                }
            }
        }
    }
    private static void shoot(char[][] map, char command) {
        if (command == 'S') {
            char currentDir = map[currentH][currentW];
            int i = 1;
            if (currentDir == '>') {
                while(currentW+i < W) {
                    char target = map[currentH][currentW+i];
                    if (target == '*') {
                        map[currentH][currentW+i] = '.';
                        break;
                    } else if (target == '#') {
                        break;
                    }
                    i++;
                }
            } else if (currentDir == '<') {
                while(currentW-i >= 0) {
                    char target = map[currentH][currentW-i];
                    if (target == '*') {
                        map[currentH][currentW-i] = '.';
                        break;
                    } else if (target == '#') {
                        break;
                    }
                    i++;
                }
            } else if (currentDir == 'v') {
                while(currentH+i < H) {
                    char target = map[currentH+i][currentW];
                    if (target == '*') {
                        map[currentH+i][currentW] = '.';
                        break;
                    } else if (target == '#') {
                        break;
                    }
                    i++;
                }
            } else if (currentDir == '^') {
                while(currentH-i >= 0) {
                    char target = map[currentH-i][currentW];
                    if (target == '*') {
                        map[currentH-i][currentW] = '.';
                        break;
                    } else if (target == '#') {
                        break;
                    }
                    i++;
                }
            }
        }
    }
}