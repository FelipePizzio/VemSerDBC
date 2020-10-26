public class StatisticInventory {
    private Inventory statistic;
    
    public StatisticInventory( Inventory backpack ) {
        this.statistic = backpack;
    }
    
    public double calculateMedia() {
        if (this.statistic.getItens().isEmpty()){
            return Double.NaN; //parametro nativo que informa nao estar retornando nada.
        }
        
        double media = 0;
        for (Item item : this.statistic.getItens()) {
            media += item.getQuantity();
        }
                
        return media = media/statistic.getItens().size();
    }
    
    public double calculateMediana() {
        if (this.statistic.getItens().isEmpty()){
            return Double.NaN; //parametro nativo que informa nao estar retornando nada.
        }
        
        int qttItens = this.statistic.getItens().size();
        int mid = qttItens / 2;
        int qttMid = this.statistic.getItemByPosition(mid).getQuantity();
        
        if ( qttItens % 2 == 1) {
            return qttMid;
        }
        
        int qttMidMinusOne = this.statistic.getItemByPosition(mid - 1).getQuantity();
        return ( qttMid + qttMidMinusOne ) / 2.0;
    }
    
    public int qttItensAboveMedia() {
        double media = this.calculateMedia();
        int qttAbove = 0;
        
        for ( Item item : this.statistic.getItens()) {
            if ( item.getQuantity() > media){
                qttAbove++;
            }
        }
        
        return qttAbove;
    }
}
