package br.com.dbccompany.coworking.Security;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Criptografia {

    public static  String cripto( String senha ){
        String retorno = "";
        MessageDigest md;
        try{
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger( 1, md.digest(senha.getBytes()));
            retorno = hash.toString(16);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

        return retorno;
    }
}
