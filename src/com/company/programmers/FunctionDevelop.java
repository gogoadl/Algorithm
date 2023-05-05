package com.company.programmers;

import java.util.ArrayList;

public class FunctionDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        ArrayList<Integer> arrayList = new ArrayList();
        ArrayList<Integer> answerList = new ArrayList<>();
        int[] count = new int[progresses.length];

        for(int i = 0; i < progresses.length; i++)
        {
            int progress = progresses[i];
            while (progress < 100)
            {
                progress += speeds[i];
                count[i]++;
            }
            if(progress >= 100)
            {
                arrayList.add(count[i]);
            }
        }

        int i = 0;
        int cnt = 1;
        while (true)
        {
            if(arrayList.get(i) >= arrayList.get(i + 1))
            {
                arrayList.remove(i + 1);
                cnt++;
            }else
            {
                i++;
                answerList.add(cnt);
                cnt = 1;
            }
            if(arrayList.size() - 1 == answerList.size())
            {
                answerList.add(cnt);
                break;
            }
        }
        answer = new int[answerList.size()];
        for(int j = 0; j < answerList.size(); j++)
        {
            answer[j] = answerList.get(j);
        }

        return answer;
    }

    public static void main(String[] args) {
        FunctionDevelop functionDevelop = new FunctionDevelop();
        functionDevelop.solution(new int[]{5,5,5},new int[]{21,25,20});
    }
}
/*
progresses : [40, 93, 30, 55, 60, 65]
speeds : [60, 1, 30, 5 , 10, 7]
return : [1,2,3]

예제 2)
progresses : [93, 30, 55, 60, 40, 65]
speeds : [1, 30, 5 , 10, 60, 7]
return : [2,4]


 */