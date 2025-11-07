package com.java.Spring_Initializr.Enum;

import lombok.Getter;

@Getter
public enum Cargo {

    ANALISTA_JR("Analista Júnior", 1),
    DESENVOLVEDOR_PLENO("Desenvolvedor Pleno", 2),
    GERENTE_PROJETO("Gerente de Projeto", 3),
    COORDENADOR_RH("Coordenador de RH", 4),
    DIRETOR_EXECUTIVO("Diretor Executivo", 5);

    private final String titulo;
    private final int idInterno;

    Cargo(String titulo, int idInterno) {
        this.titulo = titulo;
        this.idInterno = idInterno;
    }
}