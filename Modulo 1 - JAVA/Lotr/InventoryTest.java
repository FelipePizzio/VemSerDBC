import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class InventoryTest {
    
    @Test
    public void addItem() {
        Inventory backpack = new Inventory(11);
        Item sword = new Item(1, "Espada sem fio");
        
        backpack.addItemOnBackpack(sword);
        
        assertEquals(sword, backpack.getItemByPosition(0));
    }
    
    @Test
    public void addx2Item() {
        Inventory backpack = new Inventory(11);
        Item sword = new Item(1, "Espada sem fio");
        Item shield = new Item(1, "Escudo redondo");
        
        backpack.addItemOnBackpack(sword);
        backpack.addItemOnBackpack(shield);
        
        assertEquals(sword, backpack.getItemByPosition(0));
        assertEquals(shield, backpack.getItemByPosition(1));
    }
    
    @Test
    public void getItem() {
        Inventory backpack = new Inventory(11);
        Item sword = new Item(1, "Espada sem fio");
        
        backpack.addItemOnBackpack(sword);
        
        assertEquals(sword, backpack.getItemByPosition(0));
    }
    
    @Test
    public void removeItem() {
        Inventory backpack = new Inventory(11);
        Item sword = new Item(1, "Espada sem fio");
        Item shield = new Item(1, "Escudo redondo");
        
        backpack.addItemOnBackpack(sword);
        backpack.addItemOnBackpack(shield);
        backpack.removeItemFromBackpack(sword);
        
        assertEquals(1, backpack.getItens().size());
    }
    
    @Test
    public void getItemByDescription() {
        Inventory backpack = new Inventory(11);
        Item sword = new Item(1, "Espada sem fio");
        Item shield = new Item(1, "Escudo redondo");
        
        backpack.addItemOnBackpack(sword);
        backpack.addItemOnBackpack(shield);
        
        assertEquals(sword, backpack.getItemByDescription("Espada sem fio"));
    }
    
    @Test
    public void getItemByDescriptionSameDescription() {
        Inventory backpack = new Inventory(11);
        Item sword = new Item(1, "Espada sem fio");
        Item sword1 = new Item(1, "Espada sem fio");
        
        backpack.addItemOnBackpack(sword);
        backpack.addItemOnBackpack(sword1);
        
        assertEquals(sword, backpack.getItemByDescription("Espada sem fio"));
    }   
    
    @Test
    public void getDescriptionMultiItens() {
        Inventory backpack = new Inventory(11);
        Item sword = new Item(1, "Espada sem fio");
        Item shield = new Item(1, "Escudo redondo");
        Item spear = new Item(1, "Lança pra espetar curioso");
        
        backpack.addItemOnBackpack(sword);
        backpack.addItemOnBackpack(spear);
        backpack.addItemOnBackpack(shield);
        
        assertEquals("Espada sem fio,Lança pra espetar curioso,Escudo redondo", 
        backpack.getDescriptionItens());
        
    }
    
    @Test
    public void getDescriptionNoItem() {
        Inventory backpack = new Inventory(11);
        
        assertEquals("", backpack.getDescriptionItens());
    }
    
    @Test
    public void getItemHigherQtt() {
        Inventory backpack = new Inventory(11);
        Item sword = new Item(1, "Espada sem fio");
        Item shield = new Item(5, "Escudo redondo");
        Item spear = new Item(3, "Lança pra espetar curioso");
        
        backpack.addItemOnBackpack(sword);
        backpack.addItemOnBackpack(spear);
        backpack.addItemOnBackpack(shield);
        
        assertEquals(shield, backpack.getItemHigherQtt());
        
    }
    
    @Test
    public void getItemHigherQttEvenQtt() {
        Inventory backpack = new Inventory(11);
        Item sword = new Item(1, "Espada sem fio");
        Item shield = new Item(1, "Escudo redondo");
        Item spear = new Item(1, "Lança pra espetar curioso");
        
        backpack.addItemOnBackpack(sword);
        backpack.addItemOnBackpack(spear);
        backpack.addItemOnBackpack(shield);
        
        assertEquals(sword, backpack.getItemHigherQtt());
    }
    
    @Test
    public void invertEmptyInventory() {
        Inventory backpack = new Inventory(1);
        assertTrue(backpack.invertBackpack().isEmpty());
    }
    
    @Test
    public void invertBackpack1Item() {
        Inventory backpack = new Inventory(1);
        Item sword = new Item(1, "Espada sem fio");
                
        backpack.addItemOnBackpack(sword);
                
        assertEquals(sword, backpack.invertBackpack().get(0));
        assertEquals(1, backpack.invertBackpack().size());
    }
    
    @Test
    public void invertBackpack2Item() {
        Inventory backpack = new Inventory(1);
        Item sword = new Item(1, "Espada sem fio");
        Item shield = new Item(1, "Escudo redondo");
        
        backpack.addItemOnBackpack(sword);
        backpack.addItemOnBackpack(shield);
        
        assertEquals(shield, backpack.invertBackpack().get(0));
        assertEquals(sword, backpack.invertBackpack().get(1));
        assertEquals(2, backpack.invertBackpack().size());
    }
}
