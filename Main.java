
import java.io.*;
import java.util.Locale;

class Polyglot {
    private static String RToUpper(String token){
        String resultString=token.toUpperCase();

        return resultString;
    }

    private static int SumCRC(String token){
        int resultInt = 0;
        for (int i = 0;i<token.length();i++){
                resultInt= resultInt + token.charAt(i);
        }

        return resultInt;
    }

    public static void main(String[] args) {
        String array = "ab ba aa aa aa";

        String elem = "";
        for (int i = 0; i < array.length();i++){
            if(array.charAt(i) != ' ')
            elem = elem + array.charAt(i);
            else {
                String upper = RToUpper(elem);
                int crc = SumCRC(upper);
                System.out.println(upper + " -> " + crc);
                elem = "";
            }
        }
        Boolean[] viz = new Boolean[(int)array.length()];
        for(int i=0; i< viz.length; ++i){
            viz[i] = false;
        }

        String elemi = "";
        for (int i = 0; i < array.length()-1; i++) {
            viz[i] = true;
            if(array.charAt(i) != ' ')
             elemi =elemi + array.charAt(i);
            else {
                String upperi = RToUpper(elemi);
                int crci = SumCRC(upperi);
                String elemj ="";
                for (int j = i + 1; j < array.length(); j++) {
                    if(array.charAt(j) != ' ')
                    elemj = elemj + array.charAt(j);
                    else {
                        String upperj = RToUpper(elemj);
                        int crcj = SumCRC(upperj);
                        if (crci == crcj && viz[j] == false) {
                            System.out.println("Suma elem " + upperi + " = " + "suma elem " + upperj);
                            viz[j] = true;
                        }
                        elemj="";
                    }
                }
                elemi ="";
            }
        }
    }
}
