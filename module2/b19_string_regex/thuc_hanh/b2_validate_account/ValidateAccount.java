package b19_string_regex.thuc_hanh.b2_validate_account;

import java.util.regex.Pattern;

public class ValidateAccount {
    public static final String[] validAccount = new String[] { "123abc_", "_abc123", "______", "123456","abcdefgh" };
    public static final String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abcde" };

    public static void main(String[] args) {
        String patternAccount="^[_a-z0-9]{6,}$";
        for(String account:validAccount){
            System.out.println("Account is " + account +" is valid: "+ Pattern.matches(patternAccount,account));
        }
        for(String account:invalidAccount){
            System.out.println("Account is " + account +" is invalid: "+ Pattern.matches(patternAccount,account));
        }
    }
}
