import java.util.ArrayList;

class Solution {
      public int solution(int[] players, int m, int k) {
    int totalExpansion = 0;

    ArrayList<int[]> list = new ArrayList<>();
    for (int i = 0; i < players.length; i++) {
      for (int j = 0; j < list.size(); j++) {
        int[] server = list.get(j);
        if (server[2] == i) { // 서버 증설 시간 만료
//          System.out.println(String.format("server expired. count : %d, start : %d, end : %d", server[0], server[1], server[2]));
          list.remove(server);
        }
      }
      int serverCount = list.stream().mapToInt(server -> server[0]).sum() + 1;
      int acceptable = list.isEmpty() ? m : m * serverCount; // 현재 가동중인 서버 갯수 * 수용가능 인원 알아내기
      int expansionCount = 0;

      if (players[i] >= acceptable) {
        int need = players[i] - acceptable;
        expansionCount = (need + m) / m;
        totalExpansion += expansionCount;
        list.add(new int[]{expansionCount, i, i+k}); // 증설한 양 만큼 K 시간 뒤 만료
      }

//      System.out.println(String.format("time  %d player %d expServer: %d total : %d", i, players[i], serverCount + expansionCount -1, expansionCount));
    }

//    System.out.println(totalExpansion);
    return totalExpansion;
  }
}