package b5_access_modifier_static_method_static_property.bai_tap.b1_static_method;

public class Student {
    private int rollon;
    private String name;
    private static String college="BBDIT";
    Student(int r,String n){
        rollon=r;
        name=n;
    }
    static void change(){
        college="Codegym";
    }
    void display(){
        System.out.println(rollon+" "+name+" "+college);
    }
}
