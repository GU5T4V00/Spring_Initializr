package com.java.Spring_Initializr.Repository;

import com.java.Spring_Initializr.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface Repository para a Entidade Cliente.
 * Estende JpaRepository para herdar métodos CRUD prontos.
 * Parâmetros: <Tipo da Entidade, Tipo da Chave Primária>
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // O JpaRepository já fornece: save, findById, findAll, delete, etc.

    // --- Exemplos de Query Methods Personalizados (Opcionais) ---

    // Encontrar um cliente pelo CPF (Útil para login ou checagem de unicidade)
    // O Spring Data JPA implementa este método automaticamente.
    // Optional<Cliente> findByCpf(String cpf);

    // Encontrar clientes pelo status ativo
    // List<Cliente> findByAtivo(Boolean ativo);
}