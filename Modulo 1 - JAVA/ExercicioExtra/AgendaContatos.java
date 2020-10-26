import java.util.*;

public class AgendaContatos {
    private HashMap<String, String> agendaContatos;
    private String nome, numeroTelefone;
    
    public AgendaContatos(){
        agendaContatos = new LinkedHashMap<>();
    }
    
    public void adicionar ( String nome, String numeroTelefone ) {
        agendaContatos.put(nome, numeroTelefone);
    }
        
    public String getTelefone ( String nome ) {
        return this.agendaContatos.get(nome);
    }
    
    public String getNome ( String numeroTelefone ) {
        for ( HashMap.Entry<String, String> par : agendaContatos.entrySet() ){
            if ( par.getValue().equals(numeroTelefone) ){
                return par.getKey();
            }
        }
        return null;
    }
    
    public String csv() {
        StringBuilder builder = new StringBuilder();
        String separador = System.lineSeparator();
        
        for( HashMap.Entry<String, String> par : agendaContatos.entrySet() ){
            String chave = par.getKey();
            String valor = par.getValue();
            String contato = String.format("%s,%s%s", chave, valor, separador);
            builder.append(contato);
        }
        return builder.toString();
    }
}
