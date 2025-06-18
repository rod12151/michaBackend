package com.micha.elecciones.exception;

public class IdNoExiste extends RuntimeException{
    private static final String ERROR_MESSAGE="El id: %s ingresado no se encuentra registrado en la tabla %s. ";
    public IdNoExiste(String id,String nameTable){
        super(String.format(ERROR_MESSAGE,id,nameTable));
    }
}
