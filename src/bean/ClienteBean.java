package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import model.Cliente;

import org.hibernate.Session;

import DAO.ClienteDAO;
import Util.HibernateUtil;
@ManagedBean
public class ClienteBean {

		
/* filteredCars */	private List<Cliente> clientesFiltrados = new ArrayList<Cliente>();
	
	private Cliente cliente = new Cliente();
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	
	public List<Cliente> lista(){
		Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
		ClienteDAO dao = new ClienteDAO(session);
		List<Cliente> clientes = dao.lista();
		this.clientes = clientes;
		session.close();
		return this.clientes;
		
	}
	
	    public List<Cliente> getFilteredCars() {  
	        return clientesFiltrados;  
	    }  
	  
	    public void setFilteredCars(List<Cliente> clientesFiltrados) {  
	        this.clientesFiltrados = clientesFiltrados;  
	    }  
	    
	    private SelectItem[] createFilterOptions(String[] data)  {  
	        SelectItem[] options = new SelectItem[data.length + 1];  
	  
	        options[0] = new SelectItem("", "Select");  
	        for(int i = 0; i < data.length; i++) {  
	            options[i + 1] = new SelectItem(data[i], data[i]);  
	        }  
	  
	        return options;  
	    }

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public List<Cliente> getClientes() {
			return this.lista();
		}

		public List<Cliente> setClientes(List<Cliente> clientes) {
			this.clientes = clientes;
			return clientes;
		}  
	  
	      
	}  
	             
	
