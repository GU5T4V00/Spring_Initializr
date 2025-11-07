package com.java.Spring_Initializr.Entity;

import com.java.Spring_Initializr.Enum.Cargo;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "funcionarios")
@AllArgsConstructor
@NoArgsConstructor

public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFuncionario;

    @NotBlank(message = "Insira um nome válido")
    @Size(max = 80)
    @Column(nullable = false, length = 80)
    private String nome;

    @Size(max = 30)
    @NotBlank
    @Column(nullable = false, length = 30, unique = true)
    private String matricula;

    @Column(nullable = false)
    private Double salario;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cargo cargo;

    @Column(nullable = false)
    private Boolean ativo = true;
}