import java.util.*;

public class LightElf extends Elf {
    
    private int qttAttacks;
    private final ArrayList<String> INVALID_DESCRIPTION = new ArrayList<>(
        Arrays.asList(
            "Espada Galvorn"
            )
    );
    
    {
        qttAttacks = 0;
    }
    
    public LightElf( String name ) {
        super(name);
        this.damageTaken = 21.0;
        this.damageHealed = 10.0;   
        super.gainItem( new ItemSempreExistente(1, "Espada Galvorn"));
    }
    
    public boolean attack() {
        return qttAttacks % 2 != 0;
    }
    
    public void swordAttack( Dwarf dwarf ) {
        if (this.mayTakeDamage() && dwarf.getLife() > 0) {
            qttAttacks++;
            this.upXP();
            dwarf.takeDamage();
            if ( attack() ){
                this.takeDamage();
            } else {
                this.healDamage();
            }
        }
    }
    
    @Override
    public void loseItem(Item item) {
        boolean validDescription = INVALID_DESCRIPTION.contains(item.getDescription());
        
        if (!validDescription) {
            super.loseItem(item);
        }
    }
}
