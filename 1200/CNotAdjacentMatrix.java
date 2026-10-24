import java.io.*;
// import java.util.*;

public class CNotAdjacentMatrix {
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = fs.nextInt();
        while (t-- > 0) solve();
        System.out.print(out);
    }

    static void solve() throws Exception {
        int n = fs.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(-1);
            return;
        }
        int[][] arr = new int[n][n];
        int countEven = 2;
        int countOdd = 1;
        // int iMark = 0;
        // int jMark = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (countEven > n*n) {
                    arr[i][j] = countOdd;
                    countOdd += 2;
                } else {
                    arr[i][j] = countEven;
                    countEven+= 2;
                }
                
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        /* for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i+" "+j);
            }
            System.out.println();
        } */
        
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