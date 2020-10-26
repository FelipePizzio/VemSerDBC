import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LongBearDwarfTest {
    @Test
    public void barbaLongaTomaDano() {
        DadoFalso dado = new DadoFalso();
        dado.simularValor(3);
        LongBearDwarf dwarf = new LongBearDwarf("Gimli", dado);
        
        dwarf.takeDamage();

        assertEquals(100.0, dwarf.getLife(), 1e-9);
    }
}
