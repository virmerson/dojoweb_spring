package br.com.fabricadeprogramador.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fabricadeprogramador.model.Cliente;
import br.com.fabricadeprogramador.service.ClienteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteServiceTest {
	
	@Autowired
	private ClienteService clienteService;
	
	public void testSalvar(){
		clienteService.salvar(new Cliente("jao","jao@htcursos.com"));
	}
}
