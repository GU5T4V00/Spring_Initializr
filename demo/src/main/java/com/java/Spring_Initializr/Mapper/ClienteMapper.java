package com.java.Spring_Initializr.Mapper;

import com.java.Spring_Initializr.Entity.Cliente;
import com.java.Spring_Initializr.DTO.Request.ClienteRequest;
import com.java.Spring_Initializr.DTO.Response.ClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

    // RequestDTO para Entidade
    // Note que ignoramos o ID (que será gerado) e o 'ativo' (que tem default na Entity)
    @Mapping(target = "idCliente", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    Cliente toEntity(ClienteRequest dto);

    // Entidade para ResponseDTO (Não mapeamos a senha por segurança)
    ClienteResponse toResponseDTO(Cliente cliente);
}