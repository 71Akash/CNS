import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Check {
    // method to check whether a number is prime or not
    void prime(int p, int q) {
        for (int i = 2; i <= p / 2; i++) {
            if (p % i == 0) {
                System.out.println("p is not prime");
                System.exit(0);
            }
        }
        for (int i = 2; i <= q / 2; i++) {
            if (q % i == 0) {
                System.out.println("q is not prime");
                System.exit(0);
            }
        }
    }

    // method to find GCD of two numbers
    public int gcd(int x, int y) {
        int g, f;
        if (x < 0)
            x = -x;
        if (y < 0)
            y = -y;
        g = x;
        f = y % x;
        if (f > 0)
            return gcd(f, g); // recursive call of gcd method
        return g;
    }
}

public class rsa {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter P: ");
        int p = Integer.parseInt(br.readLine());
        System.out.print("Enter Q: ");
        int q = Integer.parseInt(br.readLine());

        // check p, q are prime or not
        Check ob = new Check();
        ob.prime(p, q);

        int n = p * q;
        int z = (p - 1) * (q - 1);

        System.out.print("Enter Encryption key (e): ");
        int e = Integer.parseInt(br.readLine());

        // check whether e and z are relatively prime
        int g = ob.gcd(e, z);
        if (g != 1) {
            System.out.println("e and z are not relatively prime");
            System.exit(0);
        }

        int d = 1;
        while (((e * d) % z) != 1)
            d++;

        System.out.print("Enter the plain text: ");
        int m = Integer.parseInt(br.readLine());

        int c = (int) Math.pow(m, e) % n;

        System.out.println("The decryption key (d) is: " + d);
        System.out.println("The cipher text is: " + c);
    }
}
