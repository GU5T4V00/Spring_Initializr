package com.java.Spring_Initializr.Mapper;

import com.java.Spring_Initializr.Entity.Cliente;
import com.java.Spring_Initializr.Entity.ContaBancaria;
import com.java.Spring_Initializr.DTO.Request.ClienteRequest;
import com.java.Spring_Initializr.DTO.Response.ClienteResponse;
import com.java.Spring_Initializr.DTO.Response.ContaBancariaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {ContaBancariaMapper.class}
)
public interface ClienteMapper {

    // RequestDTO para Entidade
    @Mapping(target = "idCliente", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "contasBancarias", ignore = true)
    Cliente toEntity(ClienteRequest dto);

    // Entidade para ResponseDTO
    @Mapping(target = "senha", ignore = true)
    ClienteResponse toResponseDTO(Cliente cliente);

    // Mapeamento de lista de Clientes
    List<ClienteResponse> toResponseDTOList(List<Cliente> clientes);

    // Métodos delegados para ContaBancariaMapper (Necessários para OneToMany)
    ContaBancariaResponse contaToResponseDTO(ContaBancaria conta);
    List<ContaBancariaResponse> contasToResponseDTOList(List<ContaBancaria> contas);
}