package com.Clinica1.myApp.SharedKernel;

import com.zaxxer.hikari.SQLExceptionOverride;

import java.util.UUID;

public final class IDEntidad {
    private final String idmostlyall;

    private IDEntidad(String idmostlyall) {

        this.idmostlyall = idmostlyall;
    }

    public static IDEntidad generar(){
        //genera el uuid devuelto en un obj IDEntidad
        return new IDEntidad(UUID.randomUUID().toString());
    }

    public static IDEntidad astring(String idmostlyall){
        //para q convierta un string a coso, reconstruye el uuid q se paso a string xsia
        return new IDEntidad(idmostlyall);
    }

    public String obtenerid(){
        //retorna id
        return idmostlyall;
    }

    @Override
    //para verificar q los ids sean iguales si es que el coso interno es igual
    public boolean equals(Object o){
        if (this == o){//variables q apuntan al mismo obj en memoria ya q son iguales
            return true;
        }
        if (o == null || getClass() != o.getClass()){//si es q fuera null o algo q no sea un obj IDEntidad
            return false;
        }
        IDEntidad that= (IDEntidad) o;
        return idmostlyall.equals(that.idmostlyall);//
    }

    @Override
    public int hashCode(){

        return idmostlyall.hashCode();
    }


}
