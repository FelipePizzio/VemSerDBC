public class ItemSempreExistente extends Item {
    public ItemSempreExistente( int quantity, String description ){
        super( quantity, description );
    }
    
    @Override
    public void setQuantity( int newQuantity ){
        boolean podeAlterar = newQuantity > 0;
        this.quantity = podeAlterar ? newQuantity : 1;
    }
}
