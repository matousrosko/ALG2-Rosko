package arrayofpoints;

import java.util.ArrayList;

/**
 *
 * @author janvit
 */
public class NShape {
    //data
    private ArrayList<Point> points = new ArrayList<>();

    //constructors
    //default prazdny konstruktor
    public NShape(){

    }

    //TODO
    public NShape (Point[] a){
        for (Point p : a) {
            this.points.add(p);
        }
    }

    //TODO
    public NShape (ArrayList<Point> a){
        this.points.addAll(a);
    }

    public void add(Point p){
        points.add(p);
    }

    public void add(double x, double y){
        points.add(new Point(x, y));
    }

    //TODO vyuzit prochazeni ArrayListu po indexech
    public double perim(){
        double perim = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            perim = perim + points.get(i).distanceTo(points.get(i + 1)); 
        }
        perim = perim + points.get(points.size() - 1).distanceTo(points.get(0));
        return perim;
    }

    public Point getPointAt(int index){
        return points.get(index);
    }

    public Point getNearest(){
        double min = Double.MAX_VALUE;
        Point nearest = null; //inicializace objektu
        double distance;
        for (Point point : points) { //prechadzanie ArrayListu pomocou foreach
            distance = point.getDistance();
            if(distance < min){
                min = distance;
                nearest = point;
            }
        }
        return nearest;
    }

    public Point getFurthest(){
        double max = Double.MIN_VALUE;
        Point furthest = null;
        double distance;
        for (Point point : points) {
            distance = point.getDistance();
            if(distance > max){
                max = distance;
                furthest = point;
            }
        }
        return furthest;
    }

    //TODO vrati min vzdalenost mezi body
    public double minDistanceBetween(){
        int i = 0;
	int j = 1;
	double distance = Double.MAX_VALUE;
	double temp;
	while (i < points.size()){
		temp = points.get(i).distanceTo(points.get(j));
		if (distance > temp){
			distance = temp;
		}
		if (j < points.size() - 1){
			j++;
		}else{
			i++;
			j = i;
		}
	}
	return distance;
    }

    //TODO vrati max vzdalenost mezi body
    public double maxDistanceBetween(){
        int i = 0;
	int j = 1;
	double distance = 0;
	double temp;
	while (i < points.size()){
		temp = points.get(i).distanceTo(points.get(j));
		if (distance < temp){
			distance = temp;
		}
		if (j < points.size() - 1){
			j++;
		}else{
			i++;
			j = i;
		}
	}
	return distance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Point point : points) {
            sb.append(point.toString()).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NShape myShape = new NShape();
        myShape.add(new Point(3, 4));
        myShape.add(6, 4);
        myShape.add(6, 0);
        myShape.add(3, 0);
        System.out.println(myShape.perim());
        System.out.println(myShape.maxDistanceBetween());
    }
}
