import java.util.*;

public class AttackArmy extends ElfArmy {
    
    private EstrategiaDeAtaque estrategia;
    
    public AttackArmy ( EstrategiaDeAtaque estrategia ){
        this.estrategia = estrategia;
    }
    
    public void changeEstrategia ( EstrategiaDeAtaque estrategia ){
        this.estrategia = estrategia;
    }
    
    public void attack(ArrayList<Dwarf> dwarves) {
        ArrayList<Elf> ordem = this.estrategia.getOrdemAtaque(this.getElfs());
        for (Elf elf : ordem) {
            for (Dwarf dwarf : dwarves) {
                elf.bowAttack(dwarf);
            }
        }
    }
}
