import java.io.*;
import java.util.*;

public class ACircularLocalMinimax {
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = fs.nextInt();
        while (t-- > 0)
            solve();
        System.out.print(out);
    }

    static void solve() throws Exception {
        int n = fs.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = fs.nextInt();
        /*
         * if (n % 2 == 0) {
         * System.out.println("YES");
         * } else {
         * System.out.println("NO");
         * }
         */
        if (n % 2 != 0) {
            System.out.println("NO");
            return;
        }
        int[] res = new int[n];
        Arrays.sort(a);
        int left = 0;
        int right = n / 2;
        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = a[left];
                left++;
            } else {
                res[i] = a[right];
                right++;
            }
        }

        boolean possible = true;
        for (int i = 1; i < res.length - 1; i++) {
            if ((res[i] < res[i - 1] && res[i] < res[i + 1]) || (res[i] > res[i - 1] && res[i] > res[i + 1])) {
                continue;
            } else {
                possible = false;
                // System.out.println(i); // 1
                // System.out.println(a[i]);// 4
                // System.out.println(a[i - 1]); // 1
                // System.out.println(a[i + 1]); // 8
                break;
            }
        }

        if (!(a[0] < a[n - 1] && a[0] < a[1])) {
            // possible = false;
            // System.out.println(a[0]);
            // System.out.println(a[n - 1]);
            // System.out.println(a[1]);
            // System.out.println("last case");
        }
        if (!possible) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            for (int i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr, len;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        String nextToken() throws IOException {
            StringBuilder s = new StringBuilder();
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);
            while (c > ' ') {
                s.append((char) c);
                c = read();
            }
            return s.toString();
        }

        String next() throws IOException {
            return nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }

        char nextChar() throws IOException {
            return nextToken().charAt(0);
        }
    }
}