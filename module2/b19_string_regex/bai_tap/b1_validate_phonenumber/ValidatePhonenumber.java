package b19_string_regex.bai_tap.b1_validate_phonenumber;

import java.util.regex.Pattern;

public class ValidatePhonenumber {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("\\(\\d{2}\\)-\\(0\\d{9}\\)", "(84)-(0978489648)"));
    }
}
