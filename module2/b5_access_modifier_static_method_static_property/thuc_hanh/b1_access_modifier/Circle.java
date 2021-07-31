package b5_access_modifier_static_method_static_property.thuc_hanh.b1_access_modifier;

public class Circle {
    private double radius=1.0;
    private String color="red";
    public Circle(){

    }
    public Circle(double r){
        radius=r;
    }

     double getRadius() {
        return radius;
    }
     double getArea(){
        return 3.14*radius*radius;
    }
}
