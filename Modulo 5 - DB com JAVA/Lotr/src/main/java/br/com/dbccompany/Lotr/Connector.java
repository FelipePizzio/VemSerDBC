package br.com.dbccompany.Lotr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

/* 
	Arquivo de conexão com o banco de dados oracle, verifica se a conexão é valida.
	Caso não possua conexão valida cria uma classe com o drive de conexão, seta os dados e executa um get
	
	ERRO: Caso caio no catch criar um log de erro de conexão
*/
public class Connector {

	private static Connection conn;
	
	public static Connection connect() {
		try {
			if (conn != null && conn.isValid(10)) {
				return conn;
			}
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:XE", "system", "oracle");
			
		}catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(Connector.class.getName()).log(Level.SEVERE,"ERRO DE CONEXÃO", ex);
		}
		return conn;
	}
}