package br.com.zupacademy.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.casadocodigo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
