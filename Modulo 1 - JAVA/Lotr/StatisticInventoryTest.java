import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StatisticInventoryTest {
    @Test
    public void calculateMediaEmptyInventory() {
        Inventory backpack = new Inventory(2);
        StatisticInventory statistic = new StatisticInventory(backpack);
               
        assertTrue(Double.isNaN(statistic.calculateMedia()));
        
    }
    
    @Test
    public void calculateMediaInventory1ItensResultInt() {
        Inventory backpack = new Inventory(2);
        StatisticInventory statistic = new StatisticInventory(backpack);
        
        Item shield = new Item(2, "Escudo redondo");
        
        backpack.addItemOnBackpack(shield);
        
        assertEquals(2.0, statistic.calculateMedia(), 1e-9);
        
    }
    
    @Test
    public void calculateMediaInventory2ItensResultDouble() {
        Inventory backpack = new Inventory(2);
        StatisticInventory statistic = new StatisticInventory(backpack);
        
        Item sword = new Item(5, "Espada sem fio");
        Item shield = new Item(2, "Escudo redondo");
        
        backpack.addItemOnBackpack(shield);
        backpack.addItemOnBackpack(sword);
        
        assertEquals(3.5, statistic.calculateMedia(), 1e-9);
        
    }
    
    @Test
    public void calculateMediaInventory3ItensResultInt() {
        Inventory backpack = new Inventory(2);
        StatisticInventory statistic = new StatisticInventory(backpack);
        Item sword = new Item(5, "Espada sem fio");
        Item shield = new Item(2, "Escudo redondo");
        Item spear = new Item(2, "Lança pra espetar curioso");
        
        backpack.addItemOnBackpack(sword);
        backpack.addItemOnBackpack(spear);
        backpack.addItemOnBackpack(shield);
        
        assertEquals(3.0, statistic.calculateMedia(), 1e-9);
        
    }
}