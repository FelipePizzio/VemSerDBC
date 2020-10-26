import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NightElfTest {
    @Test
    public void shootArrowx1LoseArrowx1GainXPx3LoseLifex1() {
        NightElf newElf = new NightElf("Legolas");
        Dwarf newDwarf = new Dwarf("Gimli");
        
        newElf.bowAttack(newDwarf);
        assertEquals(3, newElf.getXP());
        assertEquals(1, newElf.getQttArrow());
        assertEquals(85.0, newElf.getLife(), 1e-9);
        assertEquals(Status.TOOK_DAMAGE, newElf.getStatus());
    }
    
    @Test
    public void shootArrowx2LoseArrowx2GainXPx2LoseLifex2() {
        NightElf newElf = new NightElf("Legolas");
        Dwarf newDwarf = new Dwarf("Gimli");
        
        newElf.bowAttack(newDwarf);
        newElf.bowAttack(newDwarf);
        assertEquals(6, newElf.getXP());
        assertEquals(0, newElf.getQttArrow());
        assertEquals(70.0, newElf.getLife(), 1e-9);
    }
    
    @Test
    public void shootArrowx3LoseArrowx2GainXPx2LoseLifex2() {
        NightElf newElf = new NightElf("Legolas");
        Dwarf newDwarf = new Dwarf("Gimli");
        
        newElf.bowAttack(newDwarf);
        newElf.bowAttack(newDwarf);
        newElf.bowAttack(newDwarf);
        assertEquals(6, newElf.getXP());
        assertEquals(0, newElf.getQttArrow());
        assertEquals(70.0, newElf.getLife(), 1e-9);
    }
    
    @Test
    public void shootMaxLoseAllLife() {
        NightElf newElf = new NightElf("Legolas");
        Dwarf newDwarf = new Dwarf("Gimli");
        newElf.getArrow().setQuantity(1000);
        
        for (int i = 0; i < 1000; i++){
          newElf.bowAttack(newDwarf);
        }
        
        assertEquals(0.0, newElf.getLife(), 1e-9);
        assertEquals(Status.DEAD, newElf.getStatus());
    }
}
