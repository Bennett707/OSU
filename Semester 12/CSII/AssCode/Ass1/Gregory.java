public class Gregory {
    public static void main (String[] args) {

        int n = Integer.parseInt(args[0]);
        int i;
        double pi = 0;
        double denom = 1;
        double diff;

        for (i = 0; i < n; i++) {
            if (i % 2 == 0) {
                pi += (1.0 / denom);
            } else {
                pi -= (1.0 / denom);
            }
            denom += 2;
        }

        pi = pi * 4;
        diff = Math.abs(((pi - Math.PI) / Math.PI) * 100);
        
        System.out.println("Pi according to Gregory series: " + pi);
        System.out.println("This differs form Java's value by " + diff + " percent.");
    }

}
