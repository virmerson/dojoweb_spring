package br.com.fabricadeprogramador.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fabricadeprogramador.model.Cliente;
import br.com.fabricadeprogramador.service.ClienteService;


@Named
@ViewScoped
public class ClienteController implements Serializable {
	private static final long serialVersionUID = -6517721820588630887L;

	@Autowired
	private ClienteService clienteService;
	private Cliente cliente;
	private List<Cliente> clientes;
	
	
	@PostConstruct
	public void init() {
		cliente = new Cliente();
		clientes = clienteService.buscarTodos();
	}

	public void salvar() {
		clienteService.salvar(cliente);
		clientes.add(cliente);
		cliente =  new Cliente();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
