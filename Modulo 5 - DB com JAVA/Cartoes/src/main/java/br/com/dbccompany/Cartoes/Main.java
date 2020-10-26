package br.com.dbccompany.Cartoes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.dbccompany.Cartoes.Entity.BandeiraEntity;
import br.com.dbccompany.Cartoes.Entity.CartaoEntity;
import br.com.dbccompany.Cartoes.Entity.ClienteEntity;
import br.com.dbccompany.Cartoes.Entity.CredenciadorEntity;
import br.com.dbccompany.Cartoes.Entity.EmissorEntity;
import br.com.dbccompany.Cartoes.Entity.HibernateUtil;
import br.com.dbccompany.Cartoes.Entity.LancamentoEntity;
import br.com.dbccompany.Cartoes.Entity.LojaEntity;
import br.com.dbccompany.Cartoes.Entity.LojaXCredenciador;

public class Main {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			LojaEntity loja = new LojaEntity();
			loja.setNome("BAR DO ZÉ");
			
			List<LojaEntity> lojas = new ArrayList<>();
			lojas.add(loja);
			
			CredenciadorEntity credenciador = new CredenciadorEntity();
			credenciador.setNome("ZÉ");
			
			List<CredenciadorEntity> credenciadores = new ArrayList<>();
			credenciadores.add(credenciador);
			
			BandeiraEntity bandeira = new BandeiraEntity();
			bandeira.setNome("ZOEIRA");
			bandeira.setTaxa(0.2);
			
			EmissorEntity emissor = new EmissorEntity();
			emissor.setNome("ZOEIRA Ltda");
			emissor.setTaxa(0.2);

			ClienteEntity cliente = new ClienteEntity();
			cliente.setNome("Alguem");
			
			LojaXCredenciador Loja_Credenciador = new LojaXCredenciador();
			Loja_Credenciador.setLojas(lojas);
			Loja_Credenciador.setCredenciadores(credenciadores);
			Loja_Credenciador.setTaxa(0.2);
			
			CartaoEntity cartao = new CartaoEntity();
			cartao.setChip(true);
			cartao.setCliente(cliente);
			cartao.setBandeira(bandeira);
			cartao.setEmissor(emissor);
			cartao.setVencimento("31/02/3000");
			
			LancamentoEntity lancamento = new LancamentoEntity();
			lancamento.setCartao(cartao);
			lancamento.setLoja(loja);
			lancamento.setEmissor(emissor);
			lancamento.setDescricao("10 Litrão de Cristal");
			lancamento.setValor(70.0);
			lancamento.setData_compra("10/02/2020");
			
			session.save(loja);
			session.save(credenciador);
			session.save(bandeira);
			session.save(emissor);
			session.save(cliente);
			session.save(Loja_Credenciador);
			session.save(cartao);
			session.save(lancamento);
			
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
}