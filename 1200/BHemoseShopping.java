import java.io.*;
import java.util.*;

public class BHemoseShopping {
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = fs.nextInt();
        while (t-- > 0) solve();
        System.out.print(out);
    }

    static void solve() throws Exception {
        int n = fs.nextInt();
        int x = fs.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
            b[i] = a[i];
        }

        Arrays.sort(b);

        boolean ok = true;

        int l = n - x;
        int r = x - 1;

        for (int i = Math.max(0, l); i <= Math.min(n - 1, r); i++) {
            if (a[i] != b[i]) {
                ok = false;
                break;
            }
        }

        out.append(ok ? "YES\n" : "NO\n");
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr, len;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
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

        int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }
    }
}