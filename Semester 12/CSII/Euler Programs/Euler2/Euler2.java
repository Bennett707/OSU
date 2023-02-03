public class Euler2 {
   public static void main(String[] args) {
      int sum = 0;
      int a = 1;
      int b = 2;
      while (a < 4000000) {
         if (a % 2 == 0) {
            sum += a;
         }
         int c = a + b;
         a = b;
         b = c;
      }
      System.out.println(sum);
   } 
}
