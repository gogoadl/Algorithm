import javafx.util.Pair;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        PriorityQueue<Pair<String,Integer>> queue = new PriorityQueue<>(new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        boolean isContain = false;
        for (String word:
             words) {
            if (word.equals(target)) {
                isContain = true;
            }
        }
        if (!isContain)
            return 0;
        queue.add(new Pair<>(begin, 0));
        while (true) {
            Pair<String, Integer> p = queue.poll();
            if (p.getKey().equals(target)) {
                answer = p.getValue();
                break;
            }
            for (int i = 0; i < words.length; i++) {
                int diff = 0;
                for (int j = 0; j < p.getKey().length(); j++) {
                    if (words[i].charAt(j) != p.getKey().charAt(j)) {
                        diff++;
                    }
                }
                if (diff == 1) {
                    queue.add(new Pair<>(words[i], p.getValue()+1));
                }
            }
        }
        return answer;
    }
}