package com.java.Spring_Initializr.Enum;

import lombok.Getter;

@Getter
public enum TipoConta {
    CORRENTE("Conta corrente", 1),
    POUPANCA("Conta poupança", 2),
    INVESTIMENTO("Conta de investimentos", 3),
    SALARIO("Conta salário", 4);

    private final String descricaoConta;
    private final int idConta;

    TipoConta(String descricaoConta, int idConta){
        this.descricaoConta = descricaoConta;
        this.idConta = idConta;
    }
}
