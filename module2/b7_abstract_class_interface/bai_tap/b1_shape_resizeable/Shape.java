package b7_abstract_class_interface.bai_tap.b1_;

public abstract class Shape implements Resizeable{
    private String color="green";
    private boolean filled=true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of "
                +color
                + " and "
                +(filled?" filled":" not filled");
    }

    @Override
    public abstract void resizeable() ;
    public abstract double getArea();

}
