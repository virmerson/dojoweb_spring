package br.com.fabricadeprogramador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricadeprogramador.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado,Integer>{

}