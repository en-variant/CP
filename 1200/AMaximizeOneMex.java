import java.io.*;
import java.util.*;

public class AMaximizeOneMex {
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
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
            map.put(a[i], i);
        }

        int val = n - k;

        boolean swapPossible = false;
        int index = -1;

        for (int i = 0; i <= val; i++) {
            if (a[i] > val) {
                swapPossible = true;
                index = i;
                break;
            }

        }

        if (swapPossible) {
            // System.out.println("YES");
            int index2 = -1;
            for (int i = 0; i <= val; i++) {
                int get = map.get(i);
                if (get > val) {
                    index2 = get;
                    break;
                }
            }
            index = index + 1;
            index2 = index2 + 1;
            System.out.println(index + " " + index2);

        } else {
            // System.out.println("NO");
            System.out.println(-1);
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