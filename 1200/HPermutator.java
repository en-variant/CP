import java.io.*;
import java.util.*;

public class HPermutator {
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0) solve();
        System.out.print(out);
    }

    static void solve() throws Exception {
        int n = fs.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++){
            long val = 1L*(i+1)*(n-i);
            arr[i] = (val)*(fs.nextInt());
        }

        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = fs.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(arr2);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += arr[i]*arr2[n-1-i];         // why this?
        }
        System.out.println(res);
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

/* import java.io.*;
import java.util.*;

public class HPermutator {
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0) solve();
        System.out.print(out);
    }

    static void solve() throws Exception {
        int n = fs.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = fs.nextInt();
            arr[i][1] = i;
        }

        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) arr2[i] = fs.nextInt();

        // Arrays.sort(arr);
        Arrays.sort(arr,(a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(arr2);
        int left = 0;
        int right = n-1;
        long res = 0;

        for (int i = 0; i < arr.length; i++) {
            long temp = 1L*(arr[i][1]+1)*(n-arr[i][1]);
            if (arr[i][0] > 0) {
                res += temp*(arr[i][0])*(arr2[left]);
                left++;
            }
            else{
                res += temp*(arr[i][0])*(arr2[right]);
                right--;
            }
        }
        System.out.println(res);
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
} */