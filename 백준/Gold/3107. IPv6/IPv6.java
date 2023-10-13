import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();



//        int start = 0;
//        int end = 0;
//        while (true) {
//            end = input.indexOf(":");
//            if (end == -1) break;
//            int len = end - start;
//            String s = input.substring(start, end);
//            if (len < 4) {
//                for (int i = 0; i < 4-len; i++) {
//                    sb.append("0");
//                }
//            }
//            sb.append(s).append(":");
//            input = input.substring(end+1);
//        }
//        int len = input.length();
//        if (len < 4) {
//            for (int i = 0; i < 4-len; i++) {
//                sb.append("0");
//            }
//        }
//        sb.append(input);
//
//        len = sb.length();
//        if (len != 39) {
//            String code = "0000";
//            while(sb.length() != 39) {
//                int idx = sb.indexOf("::");
//                sb.insert(idx+1, code,0, code.length());
//                if (sb.length() < 39) {
//                    sb.insert(idx+1+code.length(),":",0,1);
//                    if (sb.charAt(0) == ':') {
//                        sb.deleteCharAt(0);
//                    }
//                }
//            }
//        }

        String[] arr = input.split(":");
        for (int i = 0; i < arr.length; i++) {
            int length = arr[i].length();
            if (length == 0) {
                sb.append(":");
                continue;
            }
            if (length < 4) {
                for (int j = 0; j < 4 - length; j++) {
                    sb.append(0);
                }
            }
            sb.append(arr[i]);
            if (i != arr.length - 1) sb.append(":");
        }
        int len = sb.length();
        if (input.indexOf("::") == input.length()-2) {
            while (sb.length() < 39) {
                sb.append(":0000");
            }
        }
        else if (len != 39) {
            String code = "0000";
            while(sb.length() < 39) {
                int idx = sb.indexOf("::");
                sb.insert(idx+1, code,0, code.length());
                if (sb.length() < 39) {
                    sb.insert(idx+1+code.length(),":",0,1);
                }
            }
        }
        if (sb.charAt(0) == ':') {
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
    }
}