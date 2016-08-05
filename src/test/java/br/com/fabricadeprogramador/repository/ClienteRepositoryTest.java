package br.com.fabricadeprogramador.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fabricadeprogramador.model.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {

	@Autowired
	private ClienteRepostitory clienteRepostitory;
	
	@Test
	public void testSave(){
		Cliente c = new Cliente();
		c.setNome("Jão");
		c.setEmail("jao@htcursos.com");
		
		clienteRepostitory.save(c);
		
	}
}
