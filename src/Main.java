//package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("\n" +
                "███████╗██╗███╗   ███╗██████╗ ██╗     ███████╗    ███████╗██╗     ██████╗      ██████╗██╗██████╗ ██╗  ██╗███████╗██████╗ \n" +
                "██╔════╝██║████╗ ████║██╔══██╗██║     ██╔════╝    ██╔════╝██║     ██╔══██╗    ██╔════╝██║██╔══██╗██║  ██║██╔════╝██╔══██╗\n" +
                "███████╗██║██╔████╔██║██████╔╝██║     █████╗      █████╗  ██║     ██████╔╝    ██║     ██║██████╔╝███████║█████╗  ██████╔╝\n" +
                "╚════██║██║██║╚██╔╝██║██╔═══╝ ██║     ██╔══╝      ██╔══╝  ██║     ██╔══██╗    ██║     ██║██╔═══╝ ██╔══██║██╔══╝  ██╔══██╗\n" +
                "███████║██║██║ ╚═╝ ██║██║     ███████╗███████╗    ██║     ███████╗██║  ██║    ╚██████╗██║██║     ██║  ██║███████╗██║  ██║\n" +
                "╚══════╝╚═╝╚═╝     ╚═╝╚═╝     ╚══════╝╚══════╝    ╚═╝     ╚══════╝╚═╝  ╚═╝     ╚═════╝╚═╝╚═╝     ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝\n" +
                "                                                                                                                         \n");
        System.out.println("\uD835\uDFED- \uD835\uDDF2\uD835\uDDFB\uD835\uDDF0\uD835\uDDFF\uD835\uDE06\uD835\uDDFD\uD835\uDE01. " +
                "\uD835\uDDF2\uD835\uDE05:\uD835\uDDDA\uD835\uDDFC\uD835\uDDFC\uD835\uDDF1 \uD835\uDDD7\uD835\uDDEE\uD835\uDE06     , " +
                "\uD835\uDDDE\uD835\uDDF2\uD835\uDE06:\uD835\uDDEE\uD835\uDE00\uD835\uDDF1\uD835\uDDF3\n" +
                "\uD835\uDFEE- \uD835\uDDF1\uD835\uDDF2\uD835\uDDF0\uD835\uDDFF\uD835\uDE06\uD835\uDDFD\uD835\uDE01 \uD835\uDDF2\uD835\uDE05:" +
                "\uD835\uDDF2\uD835\uDFEC\uD835\uDFF2\uD835\uDFEE\uD835\uDDF2\uD835\uDFED\uD835\uDFF4\uD835\uDFEE\uD835\uDFEE\uD835\uDFF2\uD835\uDFED\uD835\uDDF0" +
                "\uD835\uDFEC\uD835\uDDEF\uD835\uDFEC\uD835\uDFEE      , \uD835\uDDDE\uD835\uDDF2\uD835\uDE06:\uD835\uDDEE\uD835\uDE00\uD835\uDDF1\uD835\uDDF3\n" +
                "\uD835\uDFEF- \uD835\uDDF2\uD835\uDE05\uD835\uDDF6\uD835\uDE01");
        int SIZE=64;
        int SIZEkey=32;
        Scanner input = new Scanner(System.in);
        int choice =0;
        System.out.print("Enter your choice number : ");
        choice = input.nextInt();
        input.nextLine();
        switch (choice){
            case 1:
                System.out.print("Enter Plaintext (8 letter/digit): "); // input plaintext
                String plaintext = input.nextLine(); //take
                String Pbinary = convertStringToBinary(plaintext); //string to binary
                //check length of Plaintext
                while (Pbinary.length() > SIZE || Pbinary.length() < SIZE){
                    System.out.println("!!!! ERROR !!!!"); // Error only accept 64 bit
                    System.out.print("Enter Plaintext (8 letter/digit): "); // input plaintext
                    plaintext = input.nextLine(); //take
                    Pbinary = convertStringToBinary(plaintext); //string to binary

                }
                System.out.print("Enter Key (4 letter/digit): ");//key
                String key = input.nextLine();
                String Kbinary = convertStringToBinary(key);//string to binary
                //check length of Key
                while (Kbinary.length() > SIZEkey || Kbinary.length() < SIZEkey){
                    System.out.println("!!!! ERROR !!!!"); // Error only accept 64 bit
                    System.out.print("Enter Key (4 letter/digit): "); // input Key
                    key = input.nextLine(); //take
                    Kbinary = convertStringToBinary(key); //string to binary

                }
                //Print after convert both (key , plaintext )
                System.out.printf("\nPlaintext after convert: %s", Pbinary);
                System.out.printf("\nkey after convert: %s", Kbinary);
                String Pleft =left(Pbinary, Pbinary.length()); // split the plain test & take the leftmost bit
                String Pright = right(Pbinary, Pbinary.length());//split the plain test & take the rightmost bit
                //------------------------------
                System.out.printf("\nleft: %s",Pleft);
                System.out.printf("\nright: %s",Pright);
                //--------------rotate binary "rightmost"
                String RR=R( Pright , Pright.length()); //right most after rotation
                System.out.printf("\nLeft Rotation : %s",RR);//print res rot
                String xorR = xoring(RR, Kbinary,RR.length());
                //----------------------------------------------- XOR-Left
                String xorL = xoring(Pleft, Kbinary,Pleft.length());
                System.out.printf("\nXOR: %s", xorL);
                //---------------------------------------
                String Cipher = swap(xorL,xorR);
                System.out.println();
                System.out.printf("\nCiphertext in Binary: %s",Cipher);
                System.out.printf("\nCiphertext in Hex: %s",binToHex(Cipher));
                break;
            case 2:
                System.out.print("Enter the Cipher in hex : ");
                String user_Cipher = input.nextLine();
                String bcihper = hextoBin(user_Cipher);
                while (bcihper.length() > SIZE || bcihper.length() < SIZE){
                    System.out.println("!!!! ERROR !!!!"); // Error only accept 64 bit
                    System.out.print("Enter Cihper in hex (16 letter/digit): "); // input Key
                    user_Cipher = input.nextLine();
                    bcihper = hextoBin(user_Cipher);
                }
                System.out.print("Enter Key (4 letter/digit): ");
                String Kcipher = input.nextLine();
                String kcbinary = convertStringToBinary(Kcipher);
                while (kcbinary.length() > SIZEkey || kcbinary.length() < SIZEkey){
                    System.out.println("!!!! ERROR !!!!"); // Error only accept 64 bit
                    System.out.print("Enter Key (4 letter/digit): "); // input Key
                    Kcipher = input.nextLine();
                    kcbinary = convertStringToBinary(Kcipher);

                }
                System.out.printf("Cipher in Binary: %s",bcihper);
                String Cleft =left(bcihper, bcihper.length()); // split the cipher test & take the leftmost bit
                String Cright = right(bcihper, bcihper.length());// split the cipher test & take the leftmost bit
                String CxorR = xoring(Cright, kcbinary,Cright.length());
                System.out.printf("\nXOR: %s", CxorR);

                String CxorL=xoring(Cleft,kcbinary,Cleft.length()) ;
                String DrL = DR( CxorL , CxorL.length());
                System.out.printf("\nInverse of Rotation: %s", DrL);

                String Final = swap(DrL, CxorR);
                String PLAIN =binaryToText(Final);
                System.out.printf("\nTHE PLAINTEXT: %s",PLAIN);
                break;
            case 3:
                System.exit(0);//out
        }
    }

    public static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")                         // zero pads
            );
        }
        return result.toString();

    }
    static String  xoring(String a, String b, int n){
        String ans = "";

        // Loop to iterate over the
        // Binary Strings
        for (int i = 0; i < n; i++)
        {
            // If the Character matches
            if (a.charAt(i) == b.charAt(i))
                ans += "0";
            else
                ans += "1";
        }
        return ans;
    }
    //decode the cihper
    public static void dcodeXOR(String key , String cipher){
        String p ="";
        for (int i = 0; i < cipher.length(); i++)
        {
            // If the Character matches
            if (cipher.charAt(i) == key.charAt(i))
                p += "0";
            else
                p += "1";
        }
        System.out.println("\nInverse XOR and find Plaintext :");
        System.out.print(p);
    }
    public  static  String KeyPadding(String key,int p){
        String padding ="";
        if (key.length()<p){
            int diff = p - key.length();
            for (int i=1;i<=diff;++i){
                padding+="0";
            }
        }
        key+=padding;
        return key;
    }
    public static String left(String p , int pl) {
        int size = pl / 2;
        String PL = "";
        String PR = " ";
        for (int i = 0; i < size; i++) {
            PL = PL + p.charAt(i);
        }
        return  PL;
    }
    public static String right(String p , int pl){
        int size = pl / 2;
        String PR = "";
        for (int i = size ; i < pl; i++) {
            PR = PR + p.charAt(i);
        }
        return PR;
    }
    //Swaping
    public static String swap(String L , String R){
        String text = R;
        text+=L;
        //System.out.printf("\nSwap :",text);
        return text;
    }
    //Rotate the Binary String to left 2
    public static String R(String R , int S){
        String RO="";
        String Zero="";
        String One="";
        Zero= Zero +R.charAt(0);
        One= One +R.charAt(1);
        for (int i=0;i<S;i++){
            if(i==S-2){
                RO=RO+One;
            }else if(i==S-1){
                RO=RO+Zero;
            }
            else{
                RO=RO+R.charAt(i+2);
            }
        }
        return RO;
    }
    //Inverse the Rotate
    public static String DR(String R , int S){
        String RO="";
    //String Last="";
        RO = RO + R.charAt(S-1);
        RO = RO + R.charAt(S-2);
        for (int i=0;i<S-2;i++){
            RO=RO+R.charAt(i);
        }
        return RO;
    }
    //Functions to Converts
    public static String binToHex(String input)
    {
        int n = (int)input.length() / 4;
        input = Long.toHexString(
                Long.parseUnsignedLong(input, 2));
        while (input.length() < n)
            input = "0" + input;
        return input;
    }
    public static String hextoBin(String input)
    {
        int n = input.length() * 4;
        input = Long.toBinaryString(
                Long.parseUnsignedLong(input, 16));
        while (input.length() < n)
            input = "0" + input;
        return input;
    }
    public static String binaryToText(String binaryString) {
        StringBuilder stringBuilder = new StringBuilder();
        int charCode;
        for (int i = 0; i < binaryString.length(); i += 8) {
            charCode = Integer.parseInt(binaryString.substring(i, i + 8), 2);
            String returnChar = Character.toString((char) charCode);
            stringBuilder.append(returnChar);
        }
        return stringBuilder.toString();
    }


}//end of class
