public class Item {
    
    protected int quantity;
    private String description;
    
    public Item( int quantity, String description ) {
        this.quantity = quantity;
        this.description = description;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription( String description ) {
        this.description = description;
    }
    
    public boolean equals ( Object obj ) {
        Item otherItem = (Item)obj;
        return this.quantity == otherItem.getQuantity() &&
            this.description.equals(otherItem.getDescription());
    }
}
