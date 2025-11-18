package com.Clinica1.myApp.IAMusuario.domain.model.valueobjects;

import java.util.Objects;

public class ContraHash {
    private final String valor_contra_hash;

    private ContraHash(String valor_contra_hash) {

        this.valor_contra_hash = valor_contra_hash;
    }

    //metodo factory
    public static ContraHash hasheandocB(String valor_contra_hash){
        return new ContraHash(valor_contra_hash);

    }

    public String getValor_contra_hash() {
        return valor_contra_hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;//si no son iguales
        ContraHash that = (ContraHash) o;
        return Objects.equals(valor_contra_hash, that.valor_contra_hash);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valor_contra_hash);
    }

    //idk
    //usar bcrypt pls
}
