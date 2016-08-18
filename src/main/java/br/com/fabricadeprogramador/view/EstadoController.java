package br.com.fabricadeprogramador.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fabricadeprogramador.model.Estado;
import br.com.fabricadeprogramador.service.EstadoService;

@Named
@ViewScoped
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	private List<Estado> estados;
	
	@PostConstruct
	public void init(){
		setEstados(estadoService.buscarTodos());
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
}