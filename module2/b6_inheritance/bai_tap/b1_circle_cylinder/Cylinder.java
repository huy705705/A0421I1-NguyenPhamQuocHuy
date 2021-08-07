package b6_inheritance.bai_tap.b1_circle_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    @Override
    public String toString() {
        return "a circle with height = "
                +height
                +",which is subclass of"
                +super.toString();
    }

}
