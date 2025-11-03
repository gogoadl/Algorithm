import java.util.HashMap;

class Solution {
        public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            hashMap.put(phone_book[i], i);
        }
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (hashMap.containsKey(phone_book[i].substring(0,j)))
                    return false;
            }

        }
        return true;
    }
    
}