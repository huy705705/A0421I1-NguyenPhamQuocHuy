package b5_access_modifier_static_method_static_property.thuc_hanh.b1_access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1=new Circle(20);
        System.out.println("radius: "+c1.getRadius());
        System.out.println("area: "+c1.getArea());
    }
}
