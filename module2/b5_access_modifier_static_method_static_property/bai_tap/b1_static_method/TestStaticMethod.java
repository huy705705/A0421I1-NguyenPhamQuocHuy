package b5_access_modifier_static_method_static_property.bai_tap.b1_static_method;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        Student s1=new Student(111,"hoang");
        Student s2=new Student(222,"khanh");
        Student s3=new Student(333,"nam");
        s1.display();
        s2.display();
        s3.display();
    }
}
