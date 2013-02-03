package teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import model.Cliente;
import model.Historico;
import model.Pedido;
import model.Produto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestaNovosModelos {

	public static void main(String[] args) {
		Cliente leo = new Cliente();
		leo.setCpf("0037503403");
		leo.setNome("Leonardo Castanheira");
		List<Historico> historicos = new ArrayList<Historico>();
		Historico historico = new Historico();
		historico.setCliente(leo);
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Pedido pedido = new Pedido();
		List<Produto> produtos = new ArrayList<Produto>();
		Produto produto = new Produto();
		produto.setNome("Hot Roll");
		produto.setPreco(15.0);
		produto.setDescricao("Hot Roll do osaka quentinho com shimeji encima");
		produtos.add(produto);
		pedido.setProdutos(produtos);
		pedidos.add(pedido);
		historico.setPedidos(pedidos);
		Calendar data;
		data = new GregorianCalendar(1979, 3, 20);
		historico.setData(data);
		historicos.add(historico);
		leo.setHistorico(historicos);
		System.out.println(leo.getNome());
		Configuration c = new Configuration();
		c.configure();
		SessionFactory factory = c.buildSessionFactory();
		Session session;
		session = factory.getCurrentSession();
		session.getTransaction().begin();
		session.save(historico);
		session.save(pedido);
		session.save(produto);
		session.save(leo);
		session.getTransaction().commit();
	}
}
