package inheritancevariant;

/**
 *
 * @author janvit
 */
public abstract class Shape { //predek
    //data
    protected String name = "Geometric object"; //protected - bude viditelne v potomcich
    
    //methods
    // musi byt prekryta v potomcich
    public abstract double computeArea();
    
    //jen prepouzita v potomcich
    public String getShapeName(){          
        return this.getClass().getSimpleName();
    }
    
    //prekryva toString tridy Object, defaultni implementace, ktera muze byt prekryta
    @Override
    public String toString(){
        return name + ": " + getShapeName();
    }
}
