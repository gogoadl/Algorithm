import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    static long[] tree;
    static int N ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  
        int M = Integer.parseInt(st.nextToken());   
        int K = Integer.parseInt(st.nextToken()); 
        
        arr = new long[N+1];
        tree = new long[N+1];
        
        long l = 0;
        for (int i = 1; i <= N; i++) {
            l = Long.parseLong(br.readLine());
            arr[i]=l;
            update(i,l);
        }

        int a,b;
        long c,diff,result;
        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

            if(a==1){
                diff = c-arr[b];
                arr[b] = c;
                update(b,diff);
            }
            else{
                result = pre_sum((int)c)-pre_sum(b-1);
                System.out.println(result);
            }
        }
    }

    private static void update(int i , long l) {
        while(i<=N){
            tree[i] += l;
            i += i&-i;
        }
    }

    private static long pre_sum(int end_idx){
        long sum = 0;
        while(0<end_idx){
            sum += tree[end_idx];
            end_idx -= (end_idx&-end_idx);
        }
        return sum;
    }
}