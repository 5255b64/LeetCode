import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Demo3 {

    public static void main(String[] args) {

    }

    static class Console {

        private final BufferedReader bf;
        private StringTokenizer tokenizer;
        private static final Console instance;

        static {
            instance = new Console();
        }

        private Console() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        public static String nextLine() {
            try {
                return instance.bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static StringTokenizer nextTokenizer() {
            return new StringTokenizer(nextLine());
        }

        public static String next() {
            if (instance.tokenizer == null || !instance.tokenizer.hasMoreTokens()) {
                instance.tokenizer = nextTokenizer();
            }
            return instance.tokenizer.nextToken();
        }

        public static int nextInt() {
            return Integer.parseInt(next());
        }

        public static long nextLong() {
            return Long.parseLong(next());
        }

        public static double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}