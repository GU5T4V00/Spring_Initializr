package com.java.Spring_Initializr.DTO.Request;

import com.java.Spring_Initializr.Enum.TipoConta;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record ClienteRequest(

        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
        String nome,

        @Email(message = "Insira um e-mail válido")
        @NotBlank
        String email,

        @NotBlank(message = "O cpf é obrigatório")
        @Pattern(regexp = "^\\d{11}$", message = "O CPF deve conter 11 dígitos (somente números)")
        String cpf,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 8, max = 40)
        String senha,

        @NotNull(message = "A data de nascimento é obrigatória")
        @Past(message = "A data de nascimento deve ser menor que a data atual")
        LocalDate dataNascimento,

        @NotNull(message = "O tipo de conta é obrigatório")
        TipoConta tipoConta,

        Boolean ativo // Não precisa de @NotNull, pois o DTO aceita null no request
) {}