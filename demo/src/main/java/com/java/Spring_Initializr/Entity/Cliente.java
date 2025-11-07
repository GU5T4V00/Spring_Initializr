package com.java.Spring_Initializr.Entity;

import com.java.Spring_Initializr.Enum.Cargo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @NotBlank(message = "O nome do cliente é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String nome;

    @Email(message = "Insira um e-mail válido")
    @Column(nullable = false, length = 100)
    private String email;


    @NotBlank(message = "O cpf do cliente é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 caracteres")
    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 8, max = 40)
    @Column(nullable = false, length = 40)
    private String senha;

    @Past(message = "A data de nascimento deve ser menor que a data atual")
    @Column(nullable = false)
    private java.time.LocalDate dataNascimento;

    @Enumerated
    @Column(nullable = false, length = 20)
    private Cargo cargo;

    @Column(nullable = false)
    private Boolean ativo = true;
}