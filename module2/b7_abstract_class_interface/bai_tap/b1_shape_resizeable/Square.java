package b7_abstract_class_interface.bai_tap.b1_;

public class Square extends Rectangle implements Resizeable {
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
    public void resizeable() {
        double percent=(Math.floor((Math.random()*100)+1))/100;
        System.out.println("Hinh vuong: ");
        System.out.println("Canh Hinh vuong ban dau: "+getWidth());
        setLength((percent+1)*getSize());
        setWidth((percent+1)*getSize());
        System.out.println("phan tram: "+percent);
        System.out.println("Canh hinh vuong sau: "+getWidth());
    }
}
