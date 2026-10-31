import java.io.*;
import java.util.*;

public class DAliBabaAndPuzzles {
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0)
            solve();
        System.out.print(out);
    }

    static void solve() throws Exception {
        long a = fs.nextLong();
        long b = fs.nextLong();
        long c = fs.nextLong();
        long d = fs.nextLong();

        char[] operators = { '+', '*', '-' };
        boolean possible = false;

        for (int i = 0; i < operators.length; i++) {
            long val = 0;
            for (int j = 0; j < operators.length; j++) {
                if (i == j) {
                    continue;
                }
                if (operators[i] == '*') {
                    val = a * b;
                    if (operators[j] == '+') {
                        val += c;
                    } else if (operators[j] == '-') {
                        val -= c;
                    }
                } else if (operators[j] == '*') {
                    val = b * c;
                    if (operators[i] == '+') {
                        val += a;
                        // System.out.println(val);
                    } else if (operators[i] == '-') {
                        val -= a;
                    }
                } else {
                    val = a;
                    if (operators[i] == '+') {
                        val += b;
                        // System.out.println(val);
                    } else if (operators[i] == '-') {
                        val -= b;
                    }

                    if (operators[j] == '+') {
                        val += c;
                    } else if (operators[j] == '-') {
                        val -= c;
                    }
                }
                // System.out.println(val + " " + i + "" + j);
                if (val == d) {
                    possible = true;
                    break;
                }

            }
            if (possible) {
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
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