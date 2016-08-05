package br.com.fabricadeprogramador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabricadeprogramador.model.Cliente;

@Repository
public interface ClienteRepostitory extends JpaRepository<Cliente, Integer>{

}
