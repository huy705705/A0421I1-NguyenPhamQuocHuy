package b5_access_modifier_static_method_static_property.thuc_hanh.b2_write_only_class;

public class Test {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.setClasses("codegym");
        s1.setName("huy");
        System.out.println(s1.getName()+" "+s1.getClasses());
    }
}
