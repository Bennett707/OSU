public class Euler4 {
    public static void main (String[] args) {
        int max = 0;
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                int product = i * j;
                if (isPalindrome(product) && product > max) {
                    max = product;
                }
            }
        }
        System.out.println(max);
    }

    public static boolean isPalindrome (int n) {
        String s = Integer.toString(n);
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}
