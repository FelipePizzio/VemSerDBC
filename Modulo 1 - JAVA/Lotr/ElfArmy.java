import java.util.*;

public class ElfArmy {
    
    private final ArrayList<Class> PERMITED_TYPES = new ArrayList<>(
        Arrays.asList(
            GreenElf.class,
            NightElf.class
        )
    );
    private ArrayList<Elf> elfs = new ArrayList<>();
    private HashMap<Status, ArrayList<Elf>> byStatus = new HashMap<>();
    
    public ArrayList<Elf> getElfs() {
        return this.elfs;
    }
    
    public void enlist( Elf elf ) {
        boolean mayEnlist = PERMITED_TYPES.contains(elf.getClass());
        if ( mayEnlist ){
            elfs.add(elf);
            ArrayList<Elf> elfStatus = byStatus.get( elf.getStatus() );
            if ( elfStatus == null ) {
                elfStatus = new ArrayList<>();
                byStatus.put(elf.getStatus(), elfStatus);
            }
            elfStatus.add(elf);
        }
    }
    
    public ArrayList<Elf> getByStatus( Status status) {
        return this.byStatus.get(status);
    }
}
