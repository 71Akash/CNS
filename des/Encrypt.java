package des;

import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Encrypt {
    public static void main(String args[]) {
        if (args.length < 1) {
            System.out.println("Usage: java Encrypt <file name>");
            System.exit(-1);
        }

        String fileName = args[0];

        try {
            File desFile = new File("Encrypt.des");
            FileInputStream fis = null;
            FileOutputStream fos;
            CipherInputStream cis;

            // Creation of Secret key
            byte key[] = "abcdEFGH".getBytes();
            SecretKey secretKey = new SecretKeySpec(key, "DES");

            // Creation of Cipher objects
            Cipher encrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
            encrypt.init(Cipher.ENCRYPT_MODE, secretKey);

            // Open the Plaintext file
            try {
                fis = new FileInputStream(fileName);
            } catch (IOException err) {
                System.out.println("Cannot open file!");
                System.exit(-1);
            }

            cis = new CipherInputStream(fis, encrypt);

            // Write to the Encrypted file
            fos = new FileOutputStream(desFile);
            byte[] b = new byte[8];
            int i = cis.read(b);
            while (i != -1) {
                fos.write(b, 0, i);
                i = cis.read(b);
            }
            fos.flush();
            fos.close();
            cis.close();
            fis.close();
            System.out.println("Encryption complete. Encrypted file: encrypt.des");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
