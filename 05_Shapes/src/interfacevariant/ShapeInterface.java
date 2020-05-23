package interfacevariant;

/**
 *
 * @author janvit
 */
public interface ShapeInterface {
    final String NAME = "Geometric shape";
    
    public double computeArea();

    default String getShapeName(){
        return this.getClass().getSimpleName();
    }    
}
