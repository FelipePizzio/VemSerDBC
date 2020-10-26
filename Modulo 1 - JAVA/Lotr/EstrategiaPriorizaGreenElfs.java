import java.util.*;

public class EstrategiaPriorizaGreenElfs implements EstrategiaDeAtaque{
    
    private ArrayList<Elf> ordenacao (ArrayList<Elf> elfs){
        Collections.sort(elfs, new Comparator<Elf>(){
            public int compare( Elf elfActual, Elf nextElf ){
                boolean sameType = elfActual.getClass() == nextElf.getClass();
                
                if ( sameType ){
                    return 0;
                }
                
                return elfActual instanceof GreenElf && nextElf instanceof NightElf ?
                -1 : 1;
            }
        });
        return elfs;
    }
    
    public ArrayList<Elf> getOrdemAtaque(ArrayList<Elf> atacantes) {
        return ordenacao(atacantes);
    }
}
