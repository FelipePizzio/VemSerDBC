import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreenElfTest {
    @Test
    public void shootArrowx1LoseArrowx1GainXPx2() {
        GreenElf newElf = new GreenElf("Legolas");
        
        newElf.bowAttack(new Dwarf("Gimli"));
        
        assertEquals(2, newElf.getXP());
        assertEquals(1, newElf.getQttArrow());
    }
    
    @Test
    public void shootArrowx2LoseArrowx2GainXPx4() {
        GreenElf newElf = new GreenElf("Legolas");
        Dwarf newDwarf = new Dwarf("Gimli");
        
        newElf.bowAttack(new Dwarf("Gimli"));
        newElf.bowAttack(new Dwarf("Gimli"));
        
        assertEquals(4, newElf.getXP());
        assertEquals(0, newElf.getQttArrow());
    }
    
    @Test
    public void shootArrowx3LoseArrowx2GainXPx4() {
        GreenElf newElf = new GreenElf("Legolas");
        Dwarf newDwarf = new Dwarf("Gimli");
        
        newElf.bowAttack(new Dwarf("Gimli"));
        newElf.bowAttack(new Dwarf("Gimli"));
        newElf.bowAttack(new Dwarf("Gimli"));
        
        assertEquals(4, newElf.getXP());
        assertEquals(0, newElf.getQttArrow());
    }
    
    @Test
    public void gainItemCorrectDescription() {
        GreenElf newElf = new GreenElf("Legolas");
        Item glassBow = new Item(1, "Arco de vidro");
        Inventory backpack = newElf.getBackpack();
        
        newElf.gainItem(glassBow);
        
        assertEquals(new Item(2, "Flechas para Arco"), backpack.getItemByPosition(0));
        assertEquals(new Item(1, "Arco para usar as Flechas"), backpack.getItemByPosition(1));
        assertEquals(glassBow, backpack.getItemByPosition(2));
    }
    
    @Test
    public void gainItemWrongDescription() {
        GreenElf newElf = new GreenElf("Legolas");
        Item woodBow = new Item(1, "Arco de madeira");
        Inventory backpack = newElf.getBackpack();
        
        newElf.gainItem(woodBow);
        
        assertEquals(new Item(2, "Flechas para Arco"), backpack.getItemByPosition(0));
        assertEquals(new Item(1, "Arco para usar as Flechas"), backpack.getItemByPosition(1));
        assertNull(backpack.getItemByDescription("Arco de madeira"));
    }
    
    @Test
    public void loseItemCorrectDescription() {
        GreenElf newElf = new GreenElf("Legolas");
        Item glassBow = new Item(1, "Arco de vidro");
        Inventory backpack = newElf.getBackpack();
        
        newElf.gainItem(glassBow);
        newElf.loseItem(glassBow);
        
        assertEquals(new Item(2, "Flechas para Arco"), backpack.getItemByPosition(0));
        assertEquals(new Item(1, "Arco para usar as Flechas"), backpack.getItemByPosition(1));
        assertNull(backpack.getItemByDescription("Arco de vidro"));
    }
    
    @Test
    public void loseItemWrongDescription() {
        GreenElf newElf = new GreenElf("Legolas");
        Item woodBow = new Item(1, "Arco para usar as Flechas");
        Inventory backpack = newElf.getBackpack();
        
        newElf.loseItem(woodBow);
        
        assertEquals(new Item(2, "Flechas para Arco"), backpack.getItemByPosition(0));
        assertEquals(new Item(1, "Arco para usar as Flechas"), backpack.getItemByPosition(1));
    }
}
