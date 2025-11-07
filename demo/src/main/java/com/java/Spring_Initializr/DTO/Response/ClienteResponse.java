package com.java.Spring_Initializr.DTO.Response;

import com.java.Spring_Initializr.Enum.TipoConta;
import java.time.LocalDate;

/**
 * Record para enviar dados de Cliente como resposta.
 * Substitui a classe tradicional com @Data do Lombok.
 */
public record ClienteResponse(

        Long idCliente,
        String nome,
        String email,
        String cpf,
        LocalDate dataNascimento,
        TipoConta tipoConta,
        Boolean ativo

) {}