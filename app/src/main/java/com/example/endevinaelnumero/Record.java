package com.example.endevinaelnumero;

public class Record {

    String nombre;
    int intentos;

    public Record(String nombre, int intentos) {
        this.nombre = nombre;
        this.intentos = intentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
}
