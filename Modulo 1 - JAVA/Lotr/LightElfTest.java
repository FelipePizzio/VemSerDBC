import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LightElfTest
{
    @Test
    public void lightElfCreation() {
        LightElf newElf = new LightElf("Calaquendi");
        Inventory backpack = newElf.getBackpack();
        
        assertEquals(new Item(2, "Flechas para Arco"), backpack.getItemByPosition(0));
        assertEquals(new Item(1, "Arco para usar as Flechas"), backpack.getItemByPosition(1));
        assertEquals(new Item(1, "Espada Galvorn"), backpack.getItemByPosition(2));
    }
    
    @Test
    public void swordAttackx1() {
        LightElf newElf = new LightElf("Calaquendi");
        Dwarf newDwarf = new Dwarf("Gimli");
        
        newElf.swordAttack(newDwarf);
        
        assertEquals(79.0, newElf.getLife(), 1e-9);
    }
    
    @Test
    public void swordAttackx2StatusTookDamage() {
        LightElf newElf = new LightElf("Calaquendi");
        Dwarf newDwarf = new Dwarf("Gimli");
        
        for ( int i = 0; i < 2; i++){
            newElf.swordAttack(newDwarf);
        }
        
        assertEquals(89.0, newElf.getLife(), 1e-9);
        assertEquals(Status.TOOK_DAMAGE, newElf.getStatus());
    }
    
    @Test
    public void dontLoseItemCorrectDescription() {
        LightElf newElf = new LightElf("Legolas");
        Inventory backpack = newElf.getBackpack();
        Item galvorn = new Item(1, "Espada Galvorn");
        
        newElf.loseItem(galvorn);
        
        assertEquals(galvorn, backpack.getItemByDescription("Espada Galvorn"));
    }
    
    @Test
    public void swordAttackx2StatusDead() {
        LightElf newElf = new LightElf("Calaquendi");
        Dwarf newDwarf = new Dwarf("Gimli");
        
        newElf.life = 10.0;
        
        for ( int i = 0; i < 2; i++){
            newElf.swordAttack(newDwarf);
        }
        
        assertEquals(0.0, newElf.getLife(), 1e-9);
        assertEquals(1, newElf.getXP());
        assertEquals(100.0, newDwarf.getLife(), 1e-9);
        assertEquals(Status.DEAD, newElf.getStatus());
    }
    
    @Test
    public void bowAttackx1() {
        LightElf newElf = new LightElf("Calaquendi");
        Dwarf newDwarf = new Dwarf("Gimli");
        
        newElf.bowAttack(newDwarf);
        
        assertEquals(1, newElf.getXP());
        assertEquals(1, newElf.getQttArrow());
    }
}
