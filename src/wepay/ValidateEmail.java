package wepay;

import java.util.HashSet;
import java.util.Set;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : ValidateEmail
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ValidateEmail {
    //make a function that corrects the email address by its domain
    //https://stackoverflow.com/questions/30415594/email-validation-in-java-without-using-regular-expression
    private static Set<Character> bad = new HashSet<>();
    public static void check(String email) {
        String name = email.substring(0, email.indexOf('@'));
        String domain = email.substring(email.indexOf('@')+1, email.length());
//    String[] split = email.split("@");
        checkAgain(name);
        checkAgain(domain);
    }


    public static void checkAgain(String part) {
        if (bad.contains(part.charAt(0))) System.out.println("bad start:"+part);
        if (bad.contains(part.charAt(part.length()-1))) System.out.println("bad end:"+part);
    }

    public static void main(String[] args) {
        char[] specialChars = new char[] {'!', '#', '$', '%', '^', '&', '*', '(', ')', '-', '/', '~', '[', ']'} ;
        for (char c : specialChars) {
            bad.add(c);
        }
        check("#abc.xyz@gmail.com");
        check("abc.xyz&@gmail.com");
        check("abc.xyz&@!gmail.com");
        check("abc.xyz&@gmail.com!");
    }
}
