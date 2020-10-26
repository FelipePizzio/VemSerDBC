import java.util.*;

public class PaginatorInventory {
    private Inventory backpack;
    private int marker;
    
    public PaginatorInventory( Inventory backpack ) {
        this.backpack = backpack;
    }
    
    public void jumper( int marker ) {
        this.marker = marker > 0 ? marker : 0;
    }
    
    public ArrayList<Item> limiter( int qtt ) {
        ArrayList<Item> subConjunt = new ArrayList<>();
        int end = this.marker + qtt;
        
        for ( int i = this.marker; i < end && i < this.backpack.getItens().size(); i++) {
            subConjunt.add(this.backpack.getItemByPosition(i));
        }
        
        return subConjunt;
    }
}
