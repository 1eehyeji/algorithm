package softeer.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 수퍼바이러스 {

    private static final long MOD = 1000000007;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long k = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        System.out.println((func(p, 10 * n) * k) % MOD);

        br.close();
    }

    public static long func(long p, long n) {
        if (n == 1) return p;

        long ret = func(p, n / 2);

        ret = ret * ret % MOD;

        if (n % 2 == 1) {
            ret = ret * p % MOD;
        }

        return ret;
    }
}