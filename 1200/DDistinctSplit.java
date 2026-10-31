import java.io.*;
import java.util.*;

public class DDistinctSplit {
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
        String s = fs.next();
        if (s.length() == 1) {
            System.out.println(1);
            return;
        }

        int start = 0;
        int end = 1;
        int uniqueOne = 1;
        int uniqueTwo = 0;
        int[] uniqueOneArr = new int[26];
        int[] uniqueTwoArr = new int[26];
        uniqueOneArr[s.charAt(0) - 'a']++;

        for (int i = end; i < s.length(); i++) {
            if (uniqueTwoArr[s.charAt(i) - 'a'] == 0) {
                uniqueTwo++;
            }
            uniqueTwoArr[s.charAt(i) - 'a']++;
        }

        long max = uniqueOne + uniqueTwo;

        for (int i = end; i < s.length(); i++) {
            if (uniqueOneArr[s.charAt(i) - 'a'] == 0) {
                uniqueOne++;
            }
            if (uniqueTwoArr[s.charAt(i) - 'a'] == 1) {
                uniqueTwo--;
            }
            uniqueOneArr[s.charAt(i) - 'a']++;
            uniqueTwoArr[s.charAt(i) - 'a']--;

            max = Math.max(max, uniqueOne + uniqueTwo);
        }
        System.out.println(max);
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