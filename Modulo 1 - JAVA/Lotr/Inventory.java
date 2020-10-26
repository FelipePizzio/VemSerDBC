import java.util.*;

public class Inventory {
   
    private ArrayList<Item> backpack;
    
    public Inventory( int quantity ) {
        this.backpack = new ArrayList<Item>(quantity);
    }
    
    public ArrayList<Item> getItens() {
        return this.backpack;
    }
    
    public Item getItemByPosition( int position ) {
        if ( position >= this.backpack.size() ){
            return null;
        }
        return this.backpack.get(position);
    }
    
    public Item getItemByDescription( String description ) {
        /*int index = 0;
        
        for ( int i = 0; i < this.backpack.size(); i++){
            if( backpack.get(i).getDescription() == (description)){
                index = i;
            }
        }
        return this.backpack.get(index);*/
        
        for ( Item itemActual : this.backpack) {
            boolean encontrei = itemActual.getDescription().equals(description);
            if ( encontrei ) {
                return itemActual;
            }
        }   
        return null;      
    }   
    
    public void addItemOnBackpack( Item item ) {
        this.backpack.add(item);
    }
    
    public void removeItemFromBackpack( Item item ){
        this.backpack.remove(item);
    }
    
    public String getDescriptionItens() {
        StringBuilder description = new StringBuilder();
        
        for ( int i = 0; i < this.backpack.size(); i++){
            Item item = this.backpack.get(i);
            if ( item != null){
                description.append(item.getDescription());
                description.append(",");
            }
        }
        return (description.length() > 0 ? 
        description.substring(0, (description.length() -1)) : 
        description.toString());
    }
    
    public Item getItemHigherQtt() {
        int index = 0, higherQtt = 0;
        
        for ( int i = 0; i < this.backpack.size(); i++){
            Item item = this.backpack.get(i);
            if ( item != null){    
                if ( item.getQuantity() > higherQtt) {
                    higherQtt = item.getQuantity();
                    index = i;
                }
            }
        }   
        
        return this.backpack.size() > 0 ? this.backpack.get(index) : null;
    }
    
    public ArrayList<Item> invertBackpack() {
        ArrayList<Item> invertBackpack = new ArrayList<>(this.backpack.size());
        
        for (int i = this.backpack.size() - 1; i >= 0; i--) {
            invertBackpack.add(this.backpack.get(i));
        }
        return invertBackpack;
    }
    
    public void orderInventory() {
        this.orderInventory(OrderType.ASC);
    }
    
    public void orderInventory( OrderType order ) {
        for ( int i = 0; i < this.backpack.size(); i++) {
            for ( int j = 0; j < this.backpack.size() - 1; j++) {
                Item actual = this.backpack.get(j);
                Item next = this.backpack.get(j + 1);
                
                boolean mustChange = order == OrderType.ASC ?
                actual.getQuantity() > next.getQuantity() : 
                actual.getQuantity() < next.getQuantity(); //ordenaçao DESC
                
                if ( mustChange ) {
                    Item changeItem = actual;
                    this.backpack.set(j, next);
                    this.backpack.set(j + 1, changeItem);
                }
            } 
        }
    }
}