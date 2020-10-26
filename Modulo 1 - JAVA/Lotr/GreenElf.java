import java.util.*;

public class GreenElf extends Elf {
    
    private final ArrayList<String> VALID_DESCRIPTION = new ArrayList<>(
        Arrays.asList(
            "Flechas de vidro", 
            "Arco de vidro", 
            "Espada de aço valiriano"
            )
    );
    
    public GreenElf( String name ) {
        super(name);
        this.xpAtk = 2;
    }
       
    @Override
    public void gainItem(Item item) {
        boolean validDescription = VALID_DESCRIPTION.contains(item.getDescription());
        
        if (validDescription) {
            this.backpack.addItemOnBackpack(item);
        }
    }
    
    @Override
    public void loseItem(Item item) {
        boolean validDescription = VALID_DESCRIPTION.contains(item.getDescription());
        
        if (validDescription) {
            this.backpack.removeItemFromBackpack(item);
        }
    }
}
