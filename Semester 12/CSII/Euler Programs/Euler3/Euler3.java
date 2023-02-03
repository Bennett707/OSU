public class Euler3 {
    public static void main (String[] args) {
        long n = 600851475143L;
        long i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                n /= i;
            } else {
                i++;
            }
        }
        System.out.println(n);
    }
}
