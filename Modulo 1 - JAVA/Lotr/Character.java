
public abstract class Character {
    protected String name;
    protected Status status;
    protected Inventory backpack;
    protected double life, damageTaken, damageHealed;
    protected int xp, xpAtk;
    
    {
        status = Status.JUST_MADE;
        backpack = new Inventory(0);
        xp = 0;
        xpAtk = 1;
        damageTaken = 0;
        damageHealed = 0;
    }
    
    public Character ( String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName( String name ) {
        this.name = name;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public double getLife() {
        return this.life;
    }
    
    public int getXP() {
        return this.xp;
    }
    
    public Inventory getBackpack() {
        return this.backpack;
    }
    
    public boolean mayTakeDamage() {
        return this.life > 0;
    }
    
    public void gainItem(Item item) {
        this.backpack.addItemOnBackpack(item);
    }
    
    public void loseItem(Item item) {
        this.backpack.removeItemFromBackpack(item);
    }
    
    public void upXP() {
        this.xp += xpAtk;
    }
    
    public void takeDamage() {
        if ( this.mayTakeDamage() && this.damageTaken > 0.0 ) {
            //comparaçao ? verdadeiro : falso;
            this.life = this.life >= this.damageTaken ? 
            this.life - this.damageTaken : 0.0;
            if ( this.life == 0.0) {
                this.status = Status.DEAD;
            }
            else {
                this.status = Status.TOOK_DAMAGE;
            }
        }
    }
    
    public void healDamage() {
        if ( this.mayTakeDamage() && this.damageHealed > 0.0 ) {
            this.life += this.damageHealed;
        }
    }
    
    public abstract String imprimirResumo();
}
