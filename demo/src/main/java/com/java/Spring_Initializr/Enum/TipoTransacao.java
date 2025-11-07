package com.java.Spring_Initializr.Enum;

import lombok.Getter;

@Getter
public enum TipoTransacao {
    DEPOSITO("Depósito", 1),
    SAQUE("Saque", 2),
    TRANSFERENCIA("Transferência", 3),
    PAGAMENTO("Pagamento", 4);

    private final String descricaoTransacao;
    private final int idTransacao;

    TipoTransacao(String descricaoTransacao, int idTransacao){
        this.descricaoTransacao = descricaoTransacao;
        this.idTransacao = idTransacao;
    }
}