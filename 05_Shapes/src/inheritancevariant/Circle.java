package inheritancevariant;

/**
 *
 * @author janvit
 */
public class Circle extends Shape { //Circle je typove kompatibilni s Shape, Circle IS A Shape
    //data
    private double r;

    //public Circle(double r) {
    private Circle(double r) {
        this.r = r;
    }
    
    /*public Circle(double d) { //tohle nejde
        this.r = d/2;
    }*/
    
    //tovarni metoda - factory method
    public static Circle getInstanceD(double d){
        return new Circle(d/2);
    }
    
    public static Circle getInstanceR(double r){
        return new Circle(r);
    }
    

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        //return "Circle{" + "r=" + r + '}';
        return super.toString() + String.format(" r = %.2f", r); //super je Shape
    }
    
    //prekryti abstraktni metody z Shape
    @Override
    public double computeArea(){
        return Math.PI*r*r;
    }
    
    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceR(4);
        System.out.println(c1);
        System.out.println(c1.computeArea());
        System.out.println(c1.name);                //atribut zdedený z Shape
        System.out.println(c1.getShapeName());      //metoda zdedena z Shape
    }
}
