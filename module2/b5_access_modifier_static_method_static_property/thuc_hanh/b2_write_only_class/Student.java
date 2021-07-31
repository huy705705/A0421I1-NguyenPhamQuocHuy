package b5_access_modifier_static_method_static_property.thuc_hanh.b2_write_only_class;

public class Student {
    private String name;
    private String classes;
    public Student(){

    }

     void setName(String name) {
        this.name = name;
    }

     void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }
}
