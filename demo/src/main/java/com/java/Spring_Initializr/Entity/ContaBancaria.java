package com.java.Spring_Initializr.Entity;


import com.java.Spring_Initializr.Enum.TipoConta;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "contas_bancarias")
@AllArgsConstructor
@NoArgsConstructor

public class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contaId;

    @NotBlank(message = "Número inválido ou indisponível")
    @Size(max = 20)
    @Column(nullable = false, unique = true, length = 20)
    private String numeroConta;

    @NotNull(message = "válor informado é inválido")
    @PositiveOrZero(message =  "O saldo deve ser positivo ou zero")
    @Column(nullable = false)
    private Double saldo;

    @NotBlank(message = "Tipo de conta obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
}