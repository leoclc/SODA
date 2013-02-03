package DAO;

import java.util.List;

import model.Cliente;

import org.hibernate.Query;
import org.hibernate.Session;

public class ClienteDAO {

	private final Session session;
	
	public ClienteDAO(Session session) {
		this.session = session;
	}

	public List<Cliente> lista(){
		Query query =  this.session.createQuery("from Cliente");
		try{
		List<Cliente> clientes = query.list();
		return clientes;
		}
		catch(Exception e){
			System.out.println("deu pau");
		}
		return null;
	}
	
}
