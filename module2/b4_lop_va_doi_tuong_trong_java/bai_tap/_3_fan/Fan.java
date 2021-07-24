package b4_lop_va_doi_tuong_trong_java.bai_tap._3_fan;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
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
    public Fan(){

    }
    public Fan(int speed,boolean on,String color,double radius){
        this.speed=speed;
        this.on=on;
        this.color=color;
        this.radius=radius;
    }
    public String toString(){
        if(isOn()){
            return "Fan{"+
                    "speed='"+speed+'\''+
                    ",radius='"+radius+'\''+
                    ",color='"+color+'\''+
                    ",fan is on}";

        }else {
            return "Fan{"+
                    "speed='"+speed+'\''+
                    ",radius='"+radius+'\''+
                    ",color='"+color+'\''+
                    ",fan is off}";
        }
    }
}
