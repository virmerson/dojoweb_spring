package br.com.fabricadeprogramador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.model.Cliente;
import br.com.fabricadeprogramador.repository.ClienteRepostitory;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepostitory clienteRepostitory;
	
	public Cliente salvar(Cliente cliente){
		return clienteRepostitory.save(cliente);
	}
}