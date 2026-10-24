import java.io.*;
import java.util.*;

public class LTheBrothers {
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0) solve();
        System.out.print(out);
    }

    static void solve() throws Exception {
        String s1 = fs.next();
        String s2= fs.next();
        String s3 = fs.next();
        String s4 = fs.next();

        if (s2.equals(s4)) {
            System.out.println("ARE Brothers");
        }
        else{
            System.out.println("NOT");
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
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String nextToken() throws IOException {
            StringBuilder s = new StringBuilder();
            int c;
            do { c = read(); } while (c <= ' ' && c != -1);
            while (c > ' ') { s.append((char) c); c = read(); }
            return s.toString();
        }

        String next() throws IOException { return nextToken(); }
        int nextInt() throws IOException { return Integer.parseInt(nextToken()); }
        long nextLong() throws IOException { return Long.parseLong(nextToken()); }
        double nextDouble() throws IOException { return Double.parseDouble(nextToken()); }
        char nextChar() throws IOException { return nextToken().charAt(0); }
    }
}