package com.example.endevinaelnumero;

import java.util.Comparator;

public class Record implements Comparator<Record> {

    String nombre;
    int intentos;

    public Record(String nombre, int intentos) {
        this.nombre = nombre;
        this.intentos = intentos;
    }

    Record(){

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

    @Override
    public String toString() {
        return nombre +
                " : " + intentos;
    }

    @Override
    public int compare(Record record, Record t1) {
        return record.getIntentos() - t1.getIntentos();
    }
}
