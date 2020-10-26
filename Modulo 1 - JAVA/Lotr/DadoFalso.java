public class DadoFalso implements Sorteador {
    private int valorFalso = 0;
    
    public void simularValor( int valor ) {
        this.valorFalso = valor;
    }
    
    public int sortear() {
        return this.valorFalso;
    }
}
