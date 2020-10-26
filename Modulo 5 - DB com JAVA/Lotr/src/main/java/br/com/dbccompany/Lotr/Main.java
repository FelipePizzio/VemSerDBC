package br.com.dbccompany.Lotr;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.dbccompany.Lotr.Entity.HibernateUtil;
import br.com.dbccompany.Lotr.Entity.PersonagemEntity;
import br.com.dbccompany.Lotr.Entity.Tipo;

public class Main {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			PersonagemEntity personagem = new PersonagemEntity();
			personagem.setNome("Alguem");
			personagem.setTipo(Tipo.ELFO);
			
			session.save(personagem);
			
			transaction.commit();
			
		} catch (Exception e) {
			if( transaction != null ) {
				transaction.rollback();
			}
			System.exit(1);
		}finally {
			System.exit(0);
		}
	}
	
//	public static void main(String[] args) {
//		Connection conn = Connector.connect();
//		try {
//			
//			ResultSet rs = conn.prepareStatement(" select tname from tab where tname = 'PAISES' ")
//								.executeQuery();
//			if( !rs.next() ) {
//				conn.prepareStatement(" CREATE TABLE PAISES(\n"
//						+ "ID_PAISES INTEGER PRIMARY KEY NOT NULL, \n"
//						+ "NOME VARCHAR(100) NOT NULL\n"
//						+ ")").execute();
//			}
//			
//			PreparedStatement pst = conn.prepareStatement(" INSERT INTO PAISES( ID_PAISES, NOME ) "
//					+ "VALUES (SEQ_PAISES.NEXTVAL, ?)");
//			pst.setString(1, "China");
//			pst.executeUpdate();
//			
//			rs = conn.prepareStatement(" SELECT * FROM PAISES ").executeQuery();
//			while( rs.next() ) {
//				System.out.println(String.format("Nome do Pais: %s", rs.getString("NOME")));
//			}
//			
//		} catch (SQLException ex) {
//			Logger.getLogger(Connector.class.getName()).log(Level.SEVERE,"ERRO DE CONSULTA DO MAIN", ex);
//		}
//	}
}