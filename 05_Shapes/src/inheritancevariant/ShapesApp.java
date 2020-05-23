package inheritancevariant;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author janvit
 */
public class ShapesApp {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Shape> shapes = new ArrayList<>();
    
    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = readChoice();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    clearObjects();
                    break;
                case 2:
                    addSquare();
                    break;
                case 3:
                    addRectangle();
                    break;
                case 4:
                    addCircle();
                    break;
                case 5:
                    getAllObjectsInfo();
                    break;
                case 6:
                    computeArea();
                    break;
                case 7:
                    findWithMaxArea();
                    break;
                case 8:
                    getObjectInfo();
                    break;
                default:
                    System.out.println("Chybna volba");
            }
        } while (choice != 0);

    }

    private static void displayMenu() {
        System.out.println("");
        System.out.println("1. Nova sada");
        System.out.println("2. Pridej ctverec");
        System.out.println("3. Pridej obdelnik");
        System.out.println("4. Pridej kruh");
        System.out.println("5. Vypis geometricke utvary");
        System.out.println("6. Vypocti celkovou plochu");
        System.out.println("7. Vypis utvar s najvetsi plochou");
        System.out.println("8. Vypis plochu vybraneho utvaru");
        System.out.println("0. Konec programu");
    }
    
    //TODO
    private static int readChoice() {
        return sc.nextInt();
    }
    
    //TODO umozni zadat novou sadu utvaru
    private static void clearObjects() {
        ArrayList<Shape> shapes = new ArrayList<>();
    }
    
    //TODO pouzijte dedicnost Square IS A Rectangle
    private static void addSquare() {
        System.out.println("Zadej stranu ctverce:");
        shapes.add(new Square(sc.nextDouble()));
    }
    
    //TODO
    private static void addRectangle() {
        System.out.print("Zadej strany a & b:");
        shapes.add(new Rectangle(sc.nextDouble(), sc.nextDouble()));
    }
    
    //TODO
    private static void addCircle() {
        System.out.print("Zadej polomer:");
        shapes.add(Circle.getInstanceR(sc.nextDouble()));
    }
    
    //TODO o vsech utvarech: typ, rozmery, obsah
    private static void getAllObjectsInfo() {
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
    }
    
    //TODO vsech dohromady
    private static void computeArea() {
        double area = 0;
        for (Shape shape : shapes) {
            area = area + shape.computeArea();
        }
        System.out.println(area);
    }
    
    //TODO info o objekte s max area
    private static void findWithMaxArea() {
        double maxArea = Double.MIN_VALUE;
        String type = "";
        for (Shape shape : shapes) {
            if (shape.computeArea() > maxArea){
                maxArea = shape.computeArea();
                type = shape.getShapeName();
            }
        }
        System.out.println(type + " : " + maxArea);
    }
    
    //TODO zobrazit vsechny, nechat vybrat a o vybranem zobrazit info
    private static void getObjectInfo() {
        for (Shape shape : shapes) {
            System.out.println(shape.getShapeName());
            System.out.println(shape.computeArea());
        }
    }
}
