package b6_inheritance.thuc_hanh.b1_shape;

public class Square extends Rectangle{
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
        setLength(length);
    }

    @Override
    public void setWidth(double width) {
        setWidth(width);
    }

    @Override
    public String toString() {
        return "a square with side= "
                +getSize()
                +", which is a subclass of"
                +super.toString();
    }

}
