package b19_string_regex.bai_tap.b2_validate_name_class;

import java.util.regex.Pattern;

public class ValidateNameClass {
    public static void main(String[] args) {
        String[] nameClass={"M0318G","P0323A","C0318G"};
        for (String name:nameClass){
            System.out.println(Pattern.matches("[CAP]\\d{4}[GHIKLM]",name));
        }
    }
}
