import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {
  
  @Test
  public void dwarfBorn110Life() {
      Dwarf newDwarf = new Dwarf("Mulungrid");
      
      assertEquals(110.0, newDwarf.getLife(), 1e-9);
  }
  
  @Test
  public void dwarfLose10Life() {
      Dwarf newDwarf = new Dwarf("Mulungrid");
      
      newDwarf.takeDamage();
      assertEquals(100.0, newDwarf.getLife(), 1e-9);
  }
  
  @Test
  public void dwarfLoseAllLife11Atks() {
      Dwarf newDwarf = new Dwarf("Mulungrid");
      
      for (int i = 0; i < 11; i++){
          newDwarf.takeDamage();
      }
      
      assertEquals(0.0, newDwarf.getLife(), 1e-9);
  }
  
  @Test
  public void dwarfLoseAllLife12Atks() {
      Dwarf newDwarf = new Dwarf("Mulungrid");
      
      for (int i = 0; i < 12; i++){
          newDwarf.takeDamage();
      }
      
      assertEquals(0.0, newDwarf.getLife(), 1e-9);
  }
  
  @Test
    public void dwarfBornStatusJustMade() {
        Dwarf newDwarf = new Dwarf("Mulungrid");
        assertEquals(Status.JUST_MADE, newDwarf.getStatus());
  }
  
  @Test
  public void dwarfLoseLife2AtkStatusTookDamage() {
      Dwarf newDwarf = new Dwarf("Mulungrid");
      
      for (int i = 0; i < 2; i++){
          newDwarf.takeDamage();
      }
      
      assertEquals(90.0, newDwarf.getLife(), 1e-9);
      assertEquals(Status.TOOK_DAMAGE, newDwarf.getStatus());
  }
  
  @Test
  public void dwarfLoseAllLife11AtksStatusDead() {
      Dwarf newDwarf = new Dwarf("Mulungrid");
      
      for (int i = 0; i < 11; i++){
          newDwarf.takeDamage();
      }
      
      assertEquals(0.0, newDwarf.getLife(), 1e-9);
      assertEquals(Status.DEAD, newDwarf.getStatus());
  }
  
  @Test
  public void dwarfLoseAllLife12AtksStatusDead() {
      Dwarf newDwarf = new Dwarf("Mulungrid");
      
      for (int i = 0; i < 12; i++){
          newDwarf.takeDamage();
      }
      
      assertEquals(0.0, newDwarf.getLife(), 1e-9);
      assertEquals(Status.DEAD, newDwarf.getStatus());
  }
  
  @Test
  public void dwarfEquipsShieldHalfDamageTaken() {
      Dwarf newDwarf = new Dwarf("Mulungrid");
      
      newDwarf.equipShield();
      newDwarf.takeDamage();
      assertEquals(105.0, newDwarf.getLife(), 1e-9);
  }
  
  @Test
  public void dwarfDontEquipsShieldFullDamage(){
      Dwarf newDwarf = new Dwarf("Mulungrid");
      
      newDwarf.takeDamage();
      assertEquals(100.0, newDwarf.getLife(), 1e-9);
  }
}
