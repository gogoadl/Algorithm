import java.util.ArrayList;
import java.util.Collections;

class Solution {
 static ArrayList<String> list = new ArrayList<>();
    public static void dfs(String[][] tickets, boolean[] visited, String start, String route, int count) {
        if (count == tickets.length) {
            list.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets, visited, tickets[i][1], route + " " + tickets[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length];
        boolean[] visited = new boolean[tickets.length];
        dfs(tickets, visited, "ICN", "ICN", 0);
        Collections.sort(list);
        answer = list.get(0).split(" ");
        return answer;
    }

}