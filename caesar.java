import java.io.IOException;
import java.util.Scanner;

public class caesar {
    // public static void main(String args[]) {
    // String a="abcdefghijklmnopqrstuvwxyz";
    // String pt="hello";
    // System.out.println("The plain text is: "+pt.toUpperCase());
    // int len=pt.length();
    // System.out.print("The corresponding cipher text is: ");
    // for(int i=0;i<len;i++) {
    // char s1= pt.charAt(i);
    // int j=a.indexOf(s1);
    // String ct=a.substring(j+3,j+4);
    // System.out.print(ct.toUpperCase());
    // }
    // System.out.println(" ");
    // }

    public static void main(String args[]) throws IOException {
        String a = "abcdefghijklmnopqrstuvwxyz";
        String pt = "networks";
        System.out.println("The plaiin text is : "+pt.toUpperCase());
        System.out.print("The key : ");
        Scanner sc= new Scanner(System.in);
        int key=sc.nextInt();
        String st=new String();
        for(int i=0;i<pt.length();i++)
        {
            char c=pt.charAt(i);
            int m=(c+key-97);
            st=st+a.substring(m,m+1);
        }
        System.out.println("The encrypted Message : "+ st.toUpperCase());
        sc.close();    
    }
        
    

}