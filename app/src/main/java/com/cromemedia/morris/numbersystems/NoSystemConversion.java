package com.cromemedia.morris.numbersystems;

/**
 * Created by Morris on 10/9/2014.
 */
public class NoSystemConversion {
    public static String GuessNoSystem(String text){
        String type="";
        Boolean isDec= text.matches("^([0-9]*)$");
        Boolean isBin= text.matches("^([01]*)$");
        Boolean isOct= text.matches("^([0-8]*)$");
        Boolean isHex= text.matches("^([0-9A-Fa-f]*)$");
        if(isHex && !isDec && !isOct && !isBin){//definitely an hexa
            type="hex";
        }else if(isHex && isDec && (!isOct || !isBin)){//probably a deci
            type="dec";
        }else if(isHex && isDec && isOct && !isBin){//probably an oct
            type = "oct";
        }else if(isHex && isDec && isOct && isBin) {//probably a bin
            type = "bin";
        }

        return type;
    }

    public static String convertNo(String no,String from,String to){
        String ans="";
        if(from.equals(to)){
            return no;
        }
        if(from.equals("dec")){
            return NoSystemConversion.convertInt(Integer.parseInt(no),to);
        }else if(from.equals("bin")){
            return  NoSystemConversion.convertBin(no,to);
        }else if(from.equals("oct")){
            return NoSystemConversion.convertOct(no,to);
        }else if(from.equals("hex")){
            return NoSystemConversion.convertHex(no,to);
        }
        return  ans;
    }
    public static String convertBin(String bin,String to){
        String ans="";
        if (to.equals("dec")) {
            ans = Integer.toString(Integer.parseInt(bin, 2));

        } else if (to.equals("oct")) {
            ans = Integer.toOctalString(Integer.parseInt(bin, 2));

        } else if (to.equals("hex")) {
            ans = Integer.toHexString(Integer.parseInt(bin, 2));

        }
        return  ans;
    }

    public static String convertOct(String oct,String to){
        String ans="";
        if (to.equals("dec")) {
            ans = Integer.toString(Integer.parseInt(oct, 8));

        } else if (to.equals("bin")) {
            ans = Integer.toBinaryString(Integer.parseInt(oct, 8));

        } else if (to.equals("hex")) {
            ans = Integer.toHexString(Integer.parseInt(oct, 8));

        }
        return  ans;
    }
    public static String convertHex(String hex,String to){
        String ans="";
        if (to.equals("dec")) {
            ans = Integer.toString(Integer.parseInt(hex, 16));

        } else if (to.equals("bin")) {
            ans = Integer.toBinaryString(Integer.parseInt(hex, 16));

        } else if (to.equals("oct")) {
            ans = Integer.toOctalString(Integer.parseInt(hex, 16));

        }
        return  ans;
    }
    public static String convertInt(int no,String to){
        String ans="";
        if(to.equals("bin")){
            ans=Integer.toBinaryString(no);
        }else if(to.equals("oct")){
            ans=Integer.toOctalString(no);
        }else if(to.equals("hex")){
            ans=Integer.toHexString(no);
        }
        return ans;
    }
}
