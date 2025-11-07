package com.java.Spring_Initializr.Service;

import com.java.Spring_Initializr.Entity.Cliente;
import com.java.Spring_Initializr.DTO.Request.ClienteRequest;
import com.java.Spring_Initializr.DTO.Response.ClienteResponse;
import com.java.Spring_Initializr.Mapper.ClienteMapper;
import com.java.Spring_Initializr.Repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final PasswordEncoder passwordEncoder;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper, PasswordEncoder passwordEncoder) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public ClienteResponse criarCliente(ClienteRequest dto) {
        Cliente cliente = clienteMapper.toEntity(dto);

        String senhaHashed = passwordEncoder.encode(dto.senha());
        cliente.setSenha(senhaHashed);

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

        // 1. Atualiza campos básicos do Record (uso de dto.campo())
        clienteExistente.setNome(dto.nome());
        clienteExistente.setEmail(dto.email());
        clienteExistente.setDataNascimento(dto.dataNascimento());

        clienteExistente.setTipoConta(dto.tipoConta());

        // 2. Mantenha o CPF (Se a regra de negócio for não permitir a alteração)
        // Se a regra for permitir a alteração: clienteExistente.setCpf(dto.cpf());

        // 3. Lógica de Senha (só atualiza se a nova senha for fornecida)
        if (dto.senha() != null && !dto.senha().isEmpty()) {
            String novaSenhaHashed = passwordEncoder.encode(dto.senha());
            clienteExistente.setSenha(novaSenhaHashed);
        }

        // 4. Lógica de Ativo (Soft Delete)
        if (dto.ativo() != null) {
            clienteExistente.setAtivo(dto.ativo());
        }

        Cliente savedCliente = clienteRepository.save(clienteExistente);
        return clienteMapper.toResponseDTO(savedCliente);
    }

    @Transactional
    public void deletarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + id));

        // Soft Delete
        cliente.setAtivo(false);
        clienteRepository.save(cliente);
    }
}