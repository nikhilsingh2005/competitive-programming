import java.util.*;

public class CSES {
    static void kingKohli(Scanner sc) {
        int n = sc.nextInt();
        System.out.print(2 + " ");
        int i = 3, j = n;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (n % mid == 1) {
                System.out.println(mid);
                return;
            } else if (n % mid > 1) {
                j--;
            } else {
                i++;
            }
        }

    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        sc.nextLine();
        while (t-- > 0)
            kingKohli(sc);
        sc.close();
    }
}
