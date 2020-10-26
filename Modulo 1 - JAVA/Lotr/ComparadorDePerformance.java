import java.util.*;

public class ComparadorDePerformance{

    public void comparar(){
        ArrayList<Elf> arrayElfos = new ArrayList<>();
        HashMap<String, Elf> hashMapElfos = new HashMap<>();
        int qtdElfos = 1500000;
        for ( int i = 0; i < qtdElfos; i++ ){
            String nome = "Elfo "+ i;
            Elf elfo = new Elf(nome);
            arrayElfos.add(elfo);
            hashMapElfos.put(nome, elfo);
        }
        
        String nomeBusca = "Elfo 100000";
        
        long mSeqInicio = System.currentTimeMillis();
        Elf elfoSeq = buscaSequencial(arrayElfos, nomeBusca);
        long mSeqFim = System.currentTimeMillis();
        
        long mHashInicio = System.currentTimeMillis();
        Elf elfoMap = buscaMap(hashMapElfos, nomeBusca);
        long mHashFim = System.currentTimeMillis();
        
        String tempoSeq = String.format("%.10f", (mSeqFim - mSeqInicio) / 1000.0);
        String tempoHash = String.format("%.10f", (mHashFim - mHashInicio) / 1000.0);
        
        System.out.println("ArrayList: " + tempoSeq);
        System.out.println("HashMap: " + tempoHash);
        
    }
    
    private Elf buscaSequencial( ArrayList<Elf> lista, String name ){
        for ( Elf elfo : lista ){
            if( elfo.getName().equals(name) ){
                return elfo;
            }
        }
        return null;
    }
    
    private Elf buscaMap(HashMap<String, Elf> lista, String name){
        return lista.get(name);
    }
    
    
    
    
    
    
    
    
    
    
}