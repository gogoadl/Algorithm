import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public static int solution(int N, int number) {
  
        List<HashSet<Integer>> list=  new ArrayList<HashSet<Integer>>();

        for(int i=0; i<=8; i++)
            list.add(new HashSet<Integer>());
        list.get(1).add(N);
        if(number==N) return 1;

        for(int i=2; i<=8; i++) {

            HashSet<Integer> total = list.get(i);
            
            for(int j=1; j<i; j++) {
                HashSet<Integer> a = list.get(j);
                HashSet<Integer> b = list.get(i-j);
                
                for(int x:a) {
                    for(int y:b) {
                        total.add(x+y);
                        total.add(x-y);
                        total.add(x*y);
                        if(x!=0 && y!=0) total.add(x/y);
                    }
                }
                total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }

            if(total.contains(number)) 
                return i;
        }
        return -1;
    }
}