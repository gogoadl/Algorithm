package com.company;


import java.util.*;

public class Solution {
    // 레벨 3 보석 쇼핑 푸는중
//    public int[] solution(String[] gems) {
//        int[] answer = new int[2];
//        int[] ints = new int[gems.length];
//        PriorityQueue priorityQueue = new PriorityQueue();
//        HashMap<String, Integer> gemMap = new HashMap<>();
//        HashSet<String> hs = new HashSet<>();
//        for (String gem: gems) {
//            hs.add(gem);
//        }
//        int count = 0;
//        for (int i = 0; i < gems.length; i++) {
//            if(count == hs.size())
//                break;
//            if(gemMap.containsKey(gems[i])) {
//                gemMap.remove(gems[i]);
//            }
//            gemMap.put(gems[i],i);
//            count++;
//
//        }
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.solution(new String[]{"dia","ruby","ruby","dia", "dia", "emerald", "sapphire", "dia"});
//    }


//    public static void main(String[] args) throws IOException { 3번
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//
//        String[] strings = input.split(" ");
//
//        float gameCount = Integer.parseInt(strings[0]);
//        float winCount = Integer.parseInt(strings[1]);
//        float percent = winCount / gameCount * 100;
//        int count = 0;
//        int firstPercent = (int)percent;
//        if(firstPercent >= 99)
//        {
//            System.out.print("X");
//        }else
//        {
//            while (true)
//            {
//                gameCount++;
//                winCount++;
//                percent = winCount / gameCount * 100;
//                count++;
//                System.out.println(percent);
//                if((int)percent >= firstPercent + 1)
//                    break;
//                if (count > 10)
//                    break;
//            }
//            System.out.print(count);
//        }

//    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//
//        String[] strings = input.split(" ");
//        int A = Integer.parseInt(strings[0]);
//        int B = Integer.parseInt(strings[1]);
//
//        while (B > 0)
//        {
//            int temp = A;
//            A = B;
//            B = temp % B;
//        }
//        System.out.print(A);
//
//    }


//   public static Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        int sh = 9, sm = 38;
//
//        int myTime = sh * 60 + sm;
//        int min = myTime;
//        int[] bh = new int[]{8,17,21,12,11};
//        int[] bm = new int[]{32,24,33,43,46};
//        for(int i = 0; i < bh.length; i++)
//        {
//            int temp = bh[i] * 60 + bm[i];
//
//            if(bh[i] > sh)
//            {
//                if(min > temp - myTime)
//                    min = temp - myTime;
//            }else
//            {
//                if(min > temp + 1440 - myTime)
//                {
//                    min = temp + 1440 - myTime;
//                }
//            }
//
//        }
//        System.out.print(min);
//    }
}