package br.com.fabricadeprogramador.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fabricadeprogramador.model.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ClienteRepositoryTest {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ClienteRepository clienteRepostitory;
	
	@Test
	public void testSave(){
		Cliente c = new Cliente();
		c.setNome("Jão");
		c.setEmail("jao@htcursos.com");
		clienteRepostitory.save(c);
	}
	
	@Test
	public void testBuscarPorNome(){
		Cliente c = new Cliente();
		c.setNome("ze");
		c.setEmail("ze@htcursos.com");
		entityManager.persist(c);
		
		Cliente cliEncontrado = clienteRepostitory.buscarPorEmail("ze@htcursos.com");
		Assert.assertNotNull(cliEncontrado);
		Assert.assertTrue(cliEncontrado.getNome().equals(c.getNome()));
		Assert.assertTrue(cliEncontrado.getEmail().equals(c.getEmail()));
		
	}
}
