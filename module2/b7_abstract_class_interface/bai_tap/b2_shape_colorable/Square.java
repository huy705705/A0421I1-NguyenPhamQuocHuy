package b7_abstract_class_interface.bai_tap.b2;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double size) {
        super(size,size);
    }

    public Square(String color, boolean filled, double size) {
        super(color, filled, size,size);
    }
    public double getSize(){
        return getWidth();
    }
    public void setSize(double size){
        setWidth(size);
        setLength(size);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public String toString() {
        return "a square with side= "
                +getSize()
                +", which is a subclass of"
                +super.toString();
    }

    @Override
    public void howToColor() {
        System.out.println("Color all 4 sides");
    }
}
