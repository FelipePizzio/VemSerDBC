public class Elf extends Character {
    
    private int indexArrow;
    private static int qttElf;
    
    {
        indexArrow = 0;
    }
    
    public Elf( String name ) {
        super(name);
        this.life = 100.0;
        this.damageTaken = 0.0;
        this.damageHealed = 0.0;
        this.backpack.addItemOnBackpack( new Item(2, "Flechas para Arco"));
        this.backpack.addItemOnBackpack( new Item(1, "Arco para usar as Flechas"));
        Elf.qttElf++;
    }
    
    protected void finalize() throws Throwable {
        Elf.qttElf--;
    }
    
    public static int getQttElf(){
        return Elf.qttElf;
    }
    
    public Item getArrow() {
        return this.backpack.getItemByPosition(indexArrow);
    }

    public int getQttArrow() {
        return this.getArrow().getQuantity();
    }
    
    public boolean mayShootArrow() {
        return this.getQttArrow() > 0;
    }
    
    public void bowAttack( Dwarf dwarf) {
        if (this.mayShootArrow() && dwarf.getLife() > 0 && this.mayTakeDamage()) {
            this.getArrow().setQuantity( this.getQttArrow() - 1 );
            this.upXP();
            dwarf.takeDamage();
            this.takeDamage();
        }
    }
    
    public String imprimirResumo(){
        return "Elfo";
    }
}