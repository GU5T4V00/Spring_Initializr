package com.java.Spring_Initializr.Service;

import com.java.Spring_Initializr.Entity.Cliente;
import com.java.Spring_Initializr.DTO.Request.ClienteRequest;
import com.java.Spring_Initializr.DTO.Response.ClienteResponse;
import com.java.Spring_Initializr.Mapper.ClienteMapper;
import com.java.Spring_Initializr.Repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Transactional
    public ClienteResponse criarCliente(ClienteRequest dto) {
        Cliente cliente = clienteMapper.toEntity(dto);
        // Regra de negócio: Você pode adicionar lógica para criptografar a senha aqui

        Cliente savedCliente = clienteRepository.save(cliente);
        return clienteMapper.toResponseDTO(savedCliente);
    }

    @Transactional(readOnly = true)
    public ClienteResponse buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + id));
        return clienteMapper.toResponseDTO(cliente);
    }

    @Transactional(readOnly = true)
    public List<ClienteResponse> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ClienteResponse atualizarCliente(Long id, ClienteRequest dto) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado para atualização com ID: " + id));

        // Mapeia os dados do DTO para a Entidade existente
        Cliente clienteAtualizado = clienteMapper.toEntity(dto);
        clienteAtualizado.setIdCliente(id); // Garante que o ID original seja mantido

        // Mantém a senha existente se a nova senha não for fornecida no DTO (lógica de PATCH)
        if (dto.getSenha() == null || dto.getSenha().isEmpty()) {
            clienteAtualizado.setSenha(clienteExistente.getSenha());
        }

        // Você deve gerenciar a lógica de 'ativo' e 'cpf' separadamente, se não quiser que sejam alterados.

        Cliente savedCliente = clienteRepository.save(clienteAtualizado);
        return clienteMapper.toResponseDTO(savedCliente);
    }

    @Transactional
    public void deletarCliente(Long id) {
        // Opção 1: Soft Delete (Recomendado)
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + id));
        cliente.setAtivo(false);
        clienteRepository.save(cliente);

        // Opção 2: Hard Delete (Descomente apenas se realmente precisar)
        // clienteRepository.deleteById(id);
    }
}