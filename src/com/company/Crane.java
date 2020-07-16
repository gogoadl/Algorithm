package com.company;

import java.util.Stack;

public class Crane {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> answerStack = new Stack<>();
        for(int i = 0; i < moves.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                if(board[board.length - 1][moves[i] - 1] == 0)
                    break;
                if(board[j][moves[i] - 1] != 0)
                {
                    answerStack.add(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    if(answerStack.size() >= 2 && answerStack.peek() == answerStack.get(answerStack.size() - 2))
                    {
                        answerStack.pop();
                        answerStack.pop();
                        answer += 2;
                    }
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Crane crane = new Crane();
        crane.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},new int[]{1,5,3,5,1,2,1,4});
    }
}
