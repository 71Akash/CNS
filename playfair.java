import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class playfair {
    public static void main(String a[]) throws ArrayIndexOutOfBoundsException, IOException {
        String[][] pt1 = new String[5][5];
        String all = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        String key = "MONARCHY";
        System.out.print("Enter the plain text: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pt = br.readLine();
        pt = pt.toUpperCase();
        if ((pt.length() % 2 != 0))
            pt = pt + "X";
        System.out.println("The plain text is: " + pt);
        String ct = "";
        int len2, k = 0;
        int len1 = key.length();
        for (int i = 0; i < len1; i++) {
            len2 = all.length();
            String s = key.substring(i, i + 1);
            if (s.equals("J")) {
                s = "I";
            }
            int n = all.indexOf(s);
            all = all.substring(0, n) + "" + all.substring(n + 1, len2);
        }
        all = key + "" + all;
        // Preparing the playfair matrix System.out.println("The playfair matrix is:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (k >= all.length()) {
                    break;
                }
                pt1[i][j] = all.substring(k, k + 1);
                k++;
            }
            System.out.println("");
        }
        for(int i=0;i<5;i++)
        {
            for (int j = 0; j < 5; j++) {
                System.out.print(pt1[i][j] + " ");
            }
            System.out.println("");
        }
        for (k = 0; k < pt.length(); k = k + 2) {
            int i, j, a1 = 0, b = 0, c = 0, d = 0;
            String s = pt.substring(k, k + 2);
            String s1 = s.substring(0, 1);
            String s2 = s.substring(1, 2);
            for (i = 0; i < 5; i++) {
                for (j = 0; j < 5; j++) {
                    if (pt1[i][j].equals(s1)) {
                        a1 = i;
                        b = j;
                        break;
                    }
                }
            }
            for (i = 0; i < 5; i++) {
                for (j = 0; j < 5; j++) {
                    if (pt1[i][j].equals(s2)) {
                        c = i;
                        d = j;
                        break;
                    }
                }
            }
            if (a1 == c) {
                if ((b + 1) >= 5)
                    b = 0;
                if ((d + 1) >= 5)
                    d = 0;
                s1 = pt1[a1][b + 1];
                s2 = pt1[a1][d + 1];
            }
            if (b == d) {
                if ((a1 + 1) >= 5)
                    a1 = 0;
                if ((c + 1) >= 5)
                    c = 0;
                s1 = pt1[a1 + 1][b];
                s2 = pt1[c + 1][b];
            }
            if (a1 != c && b != d) {
                s1 = pt1[a1][d];
                s2 = pt1[c][b];
            }
            ct = ct + "" + s1 + "" + s2;
        }
        System.out.println("The cipher text is: " + ct);
    }
}
