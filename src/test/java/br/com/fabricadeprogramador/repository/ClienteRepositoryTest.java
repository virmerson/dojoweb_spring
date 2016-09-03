package br.com.fabricadeprogramador.repository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fabricadeprogramador.model.Cliente;
/**
 * Classe de teste
 * do Curso Veja mais sobre assertJ em http://joel-costigliola.github.io/assertj/
 * @author Virmerson
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest   
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ClienteRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
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
		//Primeiro Cadastra no banco
		Cliente c = new Cliente();
		c.setNome("ze");
		c.setEmail("ze@htcursos.com");
		entityManager.persist(c);
		
		//Depois busca e compara
		Cliente cliEncontrado = clienteRepostitory.buscarPorEmail("ze@htcursos.com");
		
		assertThat(cliEncontrado.getNome()) .isEqualTo(c.getNome());
		assertThat(cliEncontrado.getEmail()).isEqualTo(c.getEmail());
	}
	
	@Test
	public void testBuscarTodos(){
		Cliente c1 = new Cliente();
		c1.setNome("ze");
		c1.setEmail("ze@htcursos.com");
		entityManager.persist(c1);
		
		Cliente c2 = new Cliente();
		c2.setNome("jao");
		c2.setEmail("jao@htcursos.com");
		entityManager.persist(c2);
		
		
		List<Cliente> lista = clienteRepostitory.buscarTodos();
		
		 assertThat(lista.get(0).getEmail()).isEqualTo("ze@htcursos.com");
		 assertThat(lista.get(1).getEmail()).isEqualTo("jao@htcursos.com");
	}
}