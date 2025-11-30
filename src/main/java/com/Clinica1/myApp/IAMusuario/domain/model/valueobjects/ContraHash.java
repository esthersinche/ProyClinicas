package com.Clinica1.myApp.IAMusuario.domain.model.valueobjects;

import java.util.Objects;

public class ContraHash {
    //contraseña ya convertida fym lo estaban usando como si esto fuera bcrypt, like, huh??
    private final String valor_contra_hash;

    private ContraHash(String valor_contra_hash) {
        this.valor_contra_hash = valor_contra_hash;
    }

    //metodo factory q recibe una contraseña ya convertida a hash y la convierte a ContraHash
    public static ContraHash deHash(String contra_hash){
        return new ContraHash(contra_hash);

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
