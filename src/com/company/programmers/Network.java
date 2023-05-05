package com.company.programmers;

public class Network {
    public int solution(int n, int[][] computers) {
        int answer = n;
        for (int i = 0; i < computers.length - 1; i++) {
            for (int j = 0; j < computers[i].length - 1; j++) {
                if(computers[i][j] == 1 &&
                    computers[i][j+1] == 1 &&
                    computers[i+1][j] == 1 &&
                    computers[i+1][j+1] == 1) {
                    answer--;
                }
            }
        }
        if (answer < 1)
            answer = 1;
        return answer;
    }
    public static void main(String[] args) {
        Network network = new Network();
        network.solution(3, new int[][]{{1,1,1},{1,1,1},{1,1,1}});
    }
}
