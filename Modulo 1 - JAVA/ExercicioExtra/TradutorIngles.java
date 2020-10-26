public class TradutorIngles implements Tradutor{
    
    public String traduzir( String textoEmBR ) {
        switch(textoEmBR){
            case "Sim": return "Yes";
            case "Obrigado": 
            case "Obrigada": return "Thank You";
            
            default: return null;
        }
    }
}
