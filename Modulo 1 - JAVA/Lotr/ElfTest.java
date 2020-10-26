import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfTest {
    @After
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void shootArrowx1LoseArrowx1GainXPx1() {
        Elf newElf = new Elf("Legolas");
        Dwarf newDwarf = new Dwarf("Gimli");
        
        newElf.bowAttack(newDwarf);
        assertEquals(1, newElf.getXP());
        assertEquals(1, newElf.getQttArrow());
    }
    
    @Test
    public void shootArrowx2LoseArrowx2GainXPx2() {
        Elf newElf = new Elf("Legolas");
        Dwarf newDwarf = new Dwarf("Gimli");
        
        newElf.bowAttack(newDwarf);
        newElf.bowAttack(newDwarf);
        assertEquals(2, newElf.getXP());
        assertEquals(0, newElf.getQttArrow());
    }
    
    @Test
    public void shootArrowx3LoseArrowx2GainXPx2() {
        Elf newElf = new Elf("Legolas");
        Dwarf newDwarf = new Dwarf("Gimli");
        
        newElf.bowAttack(newDwarf);
        newElf.bowAttack(newDwarf);
        newElf.bowAttack(newDwarf);
        assertEquals(2, newElf.getXP());
        assertEquals(0, newElf.getQttArrow());
    }
    
    @Test
    public void elfBornStatusJustMade() {
        Elf newElf = new Elf("Legolas");
        assertEquals(Status.JUST_MADE, newElf.getStatus());
    }
    
    @Test
    public void shootArrowElfDead() {
        Elf newElf = new Elf("Legolas");
        Dwarf newDwarf = new Dwarf("Gimli");
        
        newElf.life = 0.0; 
        
        newElf.bowAttack(newDwarf);
        
        assertEquals(0.0, newElf.getLife(), 1e-9);
        assertEquals(0, newElf.getXP());
        assertEquals(2, newElf.getQttArrow());
        assertEquals(110.0, newDwarf.getLife(), 1e-9);
    }
    
    @Test
    public void dontCreateElfDontIncrement() {
        assertEquals(0, Elf.getQttElf());
    }
}