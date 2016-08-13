package br.com.fabricadeprogramador.view;

import java.io.Serializable;

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
	ClienteService clienteService;
	private String nome = "Jão da Silva";

	public void salvar() {
		Cliente c = new Cliente();
		c.setNome(nome);

		clienteService.salvar(c);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
