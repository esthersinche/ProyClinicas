package com.Clinica1.myApp.SharedKernel;

import com.zaxxer.hikari.SQLExceptionOverride;

import java.util.UUID;

public final class IDEntidad {
    private final String idmostlyall;

    private IDEntidad(String idmostlyall) {
        this.idmostlyall = idmostlyall;
    }

    public static IDEntidad generar(){
        return new IDEntidad(UUID.randomUUID().toString());
    }

    public static IDEntidad astring(String idmostlyall){
        return new IDEntidad(idmostlyall);
    }

    public String obtenerid(){
        return idmostlyall;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        IDEntidad that= (IDEntidad) o;
        return idmostlyall.equals(that.idmostlyall);
    }

    @Override
    public int hashCode(){
        return idmostlyall.hashCode();
    }


}
