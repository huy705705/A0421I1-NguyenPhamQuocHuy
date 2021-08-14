package b7_abstract_class_interface.bai_tap.b1_;

public class Circle extends Shape{
    private double radius;
    private String color;

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        return 3.14 * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void resizeable() {
        double percent=(Math.floor((Math.random()*100)+1))/100;
        System.out.println("Radius ban dau:"+getRadius());
        System.out.println("percent: "+ percent);
        setRadius((percent+1)*getRadius());
        System.out.println("radius sau:"+getRadius());
    }
}
