package b19_string_regex.thuc_hanh.b1_email;

import java.util.regex.Pattern;

public class ValidateEmail {
    public static final String[] validEmail = new String[] { "a@gmail.com", "ab@yahoo.com", "abc@hotmail.com" };
    public static final String[] invalidEmail = new String[] { "@gmail.com", "ab@gmail.", "@#abc@gmail.com" };
    public static void main(String[] args) {
        String patternEmail="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

        System.out.println(Pattern.matches(".a","as"));
        for (String email:validEmail){
            System.out.println("Email is " + email +" is valid: "+Pattern.matches(patternEmail,email));
        }
        for (String email:invalidEmail){
            System.out.println("Email is " + email +" is invalid: "+Pattern.matches(patternEmail,email));
        }
    }
}
