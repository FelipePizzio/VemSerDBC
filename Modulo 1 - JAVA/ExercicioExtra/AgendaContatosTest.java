import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AgendaContatosTest {
    @Test
    public void adicionarContato(){
        AgendaContatos agenda = new AgendaContatos();
        
        agenda.adicionar("Marcos", "555555");
        
        assertEquals("555555" ,agenda.getTelefone("Marcos"));
    }
    
    @Test
    public void adicionarContatosMsmNomeNumeroDiferenteSubstituiNumero(){
        AgendaContatos agenda = new AgendaContatos();
        
        agenda.adicionar("Marcos", "555555");
        agenda.adicionar("Marcos", "555551");
        
        assertEquals("555551" ,agenda.getTelefone("Marcos"));
    }
    
    @Test
    public void adicionarContatosNomesDiferentes(){
        AgendaContatos agenda = new AgendaContatos();
        
        agenda.adicionar("Marcos", "555555");
        agenda.adicionar("Felipe", "555555");
        
        assertEquals("555555" ,agenda.getTelefone("Marcos"));
        assertEquals("555555" ,agenda.getTelefone("Felipe"));
    }
    
    @Test
    public void adicionarContatox2(){
        AgendaContatos agenda = new AgendaContatos();
        
        agenda.adicionar("Marcos", "555555");
        
        assertEquals("Marcos" ,agenda.getNome("555555"));
    }
}
