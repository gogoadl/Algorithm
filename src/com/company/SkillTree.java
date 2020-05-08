package com.company;

import java.util.ArrayList;

public class SkillTree {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < skill_trees.length; i++)
        {
            String str = "";
            for(int j = 0; j < skill_trees[i].length(); j++) {

                for (int k = 0; k < skill.length(); k++) {
                    if (skill.charAt(k) == skill_trees[i].charAt(j)) {
                        str += skill.charAt(k);
                    }
                }
            }
            array.add(str);
            System.out.println("결과는 " + str);
        }
        for(int i = 0; i < array.size(); i++)
        {
            int[] answers = new int[array.size()];
            answers[i] = 1;
            for (int j = 0; j < array.get(i).length(); j++)
            {
                if (array.get(i).charAt(j) != skill.charAt(j))
                {
                    System.out.println(skill_trees[i] + ":" + array.get(i).charAt(j) + "스킬을 배우기전에 "
                            + skill.charAt(j) + "스킬을 먼저 배워야 합니다.");
                    answers[i] = 0;
                    break;
                }
            }
            if (answers[i] == 1)
            {
                answer++;
            }
        }
        System.out.println("정답 수는" + answer);
        return answer;
    }

    public static void main(String[] args)
    {

        SkillTree s = new SkillTree();
        s.solution("CBD",new String[]{"BACDE","CBADF","AECB","BDA"});
    }


}


