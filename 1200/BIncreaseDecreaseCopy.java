import java.io.*;
import java.util.*;

public class BIncreaseDecreaseCopy {
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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = fs.nextInt();

        int[] arr2 = new int[n + 1];
        for (int i = 0; i <= n; i++)
            arr2[i] = fs.nextInt();

        long res = 0;
        int val = arr2[n];

        for (int i = 0; i < n; i++) {
            if (arr[i] >= arr2[i]) {
                res += (arr[i] - arr2[i]);
            } else {
                res += (arr2[i] - arr[i]);
            }
        }

        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr2[i]) {
                if (val <= arr[i] && val >= arr2[i]) {
                    flag = true;
                    break;
                }
            } else {
                if (val >= arr[i] && val <= arr2[i]) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println(res + 1);
        } else {
            long value = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                value = Math.min(value, Math.min(Math.abs(arr[i] - val), Math.abs(arr2[i] - val)));
            }

            System.out.println(res + value + 1);
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