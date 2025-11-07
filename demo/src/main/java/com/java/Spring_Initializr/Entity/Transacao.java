package com.java.Spring_Initializr.Entity;

import com.java.Spring_Initializr.Enum.TipoTransacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "transacoes")
@AllArgsConstructor
@NoArgsConstructor

public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Valor da conta não pode ser nulo")
    private Double valor;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTransacao tipoTransacao;

    @Column(nullable = false)
    private java.time.LocalDate data = java.time.LocalDate.now();

    @NotBlank
    @Column(nullable = false, length = 200)
    private String descricao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_conta", nullable = false)
    private ContaBancaria conta;
}
