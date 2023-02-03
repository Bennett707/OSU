public class Fib {
    public static void main (String[] args) {

        int n = Integer.parseInt(args[0]);
        int i;
        int a = 0;
        int b = 1;
        int c = 0;

        for (i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }
}
