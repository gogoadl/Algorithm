import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
         class Pair<T,V> {
        T first;
        V second;

        public Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }
    }
    class Triple<T,K,V> {
        T first;
        K second;
        V third;

        public Triple(T first, K second, V third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Triple<Integer, String, Integer>> list = new ArrayList<>();
        ArrayList<Pair<String, Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            list.add(new Triple(i, genres[i], plays[i]));
        }
        map.forEach((s, i) -> {
            arrayList.add(new Pair(s,i));
        });
        Collections.sort(list, new Comparator<Triple<Integer, String, Integer>>() {
            @Override
            public int compare(Triple<Integer, String, Integer> o1,
                Triple<Integer, String, Integer> o2) {
                return o2.third - o1.third;
            }
        });

        Collections.sort(arrayList, new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                return o2.second-o1.second;
            }
        });
        int idx = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            String s = arrayList.get(i).first;
            int cnt = 0;
            for (int j = 0; j < list.size(); j++) {
                if (cnt == 2) break;
                if (list.get(j).second.equals(s)) {
                    ans.add(list.get(j).first);
                    cnt++;
                }
            }
        }
        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}