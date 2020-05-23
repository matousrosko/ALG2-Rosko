package interfacevariant;

import java.util.ArrayList;

/**
 *
 * @author janvit
 */
public class Main {

    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceD(8);
        Rectangle r1 = new Rectangle(2, 3);
        Circle c2 = Circle.getInstanceR(2.6);
        
        System.out.println("1. varianta");
        double allArea1 = c1.computeArea() + r1.getArea() + c2.computeArea();
        System.out.println(allArea1);
        
        System.out.println("2. varianta");
        ArrayList shapes2 = new ArrayList(); //dynamicke pole objektov typu Object
        //muze obsahovat cokoli, co je typove kompatibilni s Object (vsechno)
        shapes2.add(c1);
        shapes2.add(r1);
        shapes2.add(Circle.getInstanceR(2.6));
        
        double allArea2 = 0;
        for (int i = 0; i < shapes2.size(); i++) { //going through using index
            if (shapes2.get(i) instanceof Circle){
                allArea2 += ((Circle)shapes2.get(i)).computeArea();
            } else if (shapes2.get(i) instanceof Rectangle){
               allArea2 += ((Rectangle)shapes2.get(i)).getArea();
            } 
        }
        System.out.println(allArea2);
        
        System.out.println("3. varianta");
        ArrayList<ShapeInterface> shapes3 = new ArrayList<>(); //dynamicke pole objektů, ktere implementuji ShapeInterface
        //muze obsahovat cokoli, co je typove kompatibilni s ShapeInterface (Circle, Rectangle)
        //ShapeInterface s = new Rectangle(5, 6);
        //Rectangle r = new ShapeInterface(); //nejde ani priradit, ani vytvorit objekt
        shapes3.add(c1);
        shapes3.add(r1);
        shapes3.add(Circle.getInstanceR(2.6));
        
        double allArea3 = 0;
        for (ShapeInterface shape : shapes3) { //foreach
            allArea3 += shape.computeArea(); //polymorfism
        }
        System.out.println(allArea3);
    }
    
}
