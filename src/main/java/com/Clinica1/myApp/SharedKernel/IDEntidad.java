package com.Clinica1.myApp.SharedKernel;

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


}
