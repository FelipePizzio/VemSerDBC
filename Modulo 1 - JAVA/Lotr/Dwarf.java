public class Dwarf extends Character {

    private boolean equipped;
    
    {
        equipped = false;
    }

    public Dwarf( String name ) {
        super(name);
        this.life = 110.0;
        this.damageTaken = 10.0;
        this.backpack.addItemOnBackpack( new Item(1, "Escudo Quebrado"));
    }
    
    public void equipShield() {
        this.damageTaken = 5.0;
    }
    
    public String imprimirResumo(){
        return "Dwarf";
    }
}
