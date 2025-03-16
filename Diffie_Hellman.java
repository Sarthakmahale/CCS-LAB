import java.util.*;

public class Diffie_Hellman {

    private static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private static int modExp(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            exp >>= 1;
            base = (base * base) % mod;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p;
        while (true) {
            System.out.println("Enter the prime number");
            p = sc.nextInt();
            if (!isPrime(p)) {
                System.out.println("p is not prime. Try again.");
                continue;
            }
            System.out.println("Entered prime no is-->" + p);
            break;
        }

        System.out.println("Enter the primitive root of P");
        int g = sc.nextInt();
        System.out.println("Entered primitive root is-->" + g);

        System.out.println("Enter the private key for user A");
        int x = sc.nextInt();
        System.out.println("Entered private key of user A is-->" + x);
        System.out.println("Enter the private key for user B");
        int y = sc.nextInt();
        System.out.println("Entered private key of user B is-->" + y);

        if (x < p && y < p) {
            System.out.println("private key selected");
        } else {
            System.out.println("private key must be less than prime number P");
        }

        int a = modExp(g, x, p);
        System.out.println("public key for user A is-->" + a);

        int b = modExp(g, y, p);
        System.out.println("public key for user B is-->" + b);

        int k = modExp(b, x, p);
        System.out.println("Secrete key for user A is-->" + k);

        int k1 = modExp(a, y, p);
        System.out.println("Secrete key for user B is-->" + k1);

    }
}
