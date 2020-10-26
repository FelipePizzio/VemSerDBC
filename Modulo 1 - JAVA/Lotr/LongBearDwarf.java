public class LongBearDwarf extends Dwarf {

    private Sorteador sorteador;
    
    public LongBearDwarf ( String name) {
        super(name);
        sorteador = new D6();
    }
    
    public LongBearDwarf ( String name, Sorteador sorteador) {
        super(name);
        this.sorteador = sorteador;
    }
    
    @Override
    public void takeDamage() {
        boolean devePerderVida = sorteador.sortear() <= 4;
        if(devePerderVida){
            super.takeDamage();
        }
    }
}
