package des;

import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Decrypt {
    public static void main(String args[]) {
        try {
            File desFile = new File("Encrypt.des");
            File desFileBis = new File("Decrypt.des");
            FileInputStream fis;
            FileOutputStream fos;
            CipherInputStream cis;

            // Creation of Secret key
            byte key[] = "abcdEFGH".getBytes();
            SecretKey secretKey = new SecretKeySpec(key, "DES");

            // Creation of Cipher objects
            Cipher decrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
            decrypt.init(Cipher.DECRYPT_MODE, secretKey);

            // Open the Encrypted file
            fis = new FileInputStream(desFile);
            cis = new CipherInputStream(fis, decrypt);

            // Write to the Decrypted file
            fos = new FileOutputStream(desFileBis);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
