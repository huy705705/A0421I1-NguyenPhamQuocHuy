package b7_abstract_class_interface.bai_tap.b1_;

public class Rectangle extends Shape{
    private double length = 1.0;
    private double width = 1.0;
    private String color;
    private boolean filled;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(String color, boolean filled, double length, double width) {
        this.color = color;
        this.filled = filled;
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return (length + width) * 2;
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + width
                + "and length="
                + length
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resizeable() {
        double percent=(Math.floor((Math.random()*100)+1))/100;
        System.out.println("Chieu dai ban dau: "+getLength());
        System.out.println("Chieu rong ban dau: "+getWidth());
        System.out.println("phan tram: "+percent);
        setLength((percent+1)*getLength());
        System.out.println("chieu dai sau: "+getLength());
        setWidth((percent+1)*getWidth());
        System.out.println("chieu dai sau: "+getWidth());
    }
}
