package b4_lop_va_doi_tuong_trong_java.bai_tap._1_quadratic_equation;

public class QuadraticEquation {
    private double a,b,c;
    public QuadraticEquation(){

    }
    public QuadraticEquation(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public double getA(){
        return this.a;
    }
    public double getB(){
        return this.b;
    }
    public double getC(){
        return this.c;
    }
    public double getDiscriminant(){

        return b*b-4*a*c;
    }
    public double getRoot1(){

        if(getDiscriminant()>=0){

            return (-b+Math.sqrt(getDiscriminant()))/(2*a);
        }else {
            return -100;
        }
    }
    public double getRoot2(){
        if(getDiscriminant()>=0){

            return (-b-Math.sqrt(getDiscriminant()))/(2*a);
        }else {
            return -100;
        }
    }
}
