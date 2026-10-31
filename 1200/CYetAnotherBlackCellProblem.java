import java.io.*;
import java.util.*;

public class CYetAnotherBlackCellProblem {
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
        int k = fs.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }

        int[] diff = new int[100001];
        for (int i = 1; i < a.length; i++) {
            diff[a[i] - a[i - 1]]++;
        }

        for (int i = diff.length - 1; i >= 1; i--) {
            if (i == 1) {
                System.out.println(i);
                break;
            }
            if (diff[i] != 0) {
                while (k > 0 && diff[i] > 0) {
                    if (i % 2 == 0) {
                        diff[i / 2] += 2;
                    } else {
                        diff[i / 2]++;
                        diff[(i / 2) + 1]++;
                    }
                    diff[i]--;
                    k--;
                }
            }
            if (k == 0 && diff[i] != 0) {
                System.out.println(i);
                break;
            }
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