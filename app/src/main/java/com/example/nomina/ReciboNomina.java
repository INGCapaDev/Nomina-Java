package com.example.nomina;

import org.jetbrains.annotations.NotNull;

public class ReciboNomina {
    private int numRecibo;
    private String nombre;
    private double horasTrabNormal;
    private double horasTrabExtras;
    private int puesto;
    private double impuestoPorc;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getHorasTrabNormal() {
        return horasTrabNormal;
    }

    public void setHorasTrabNormal(double horasTrabNormal) {
        this.horasTrabNormal = horasTrabNormal;
    }

    public double getHorasTrabExtras() {
        return horasTrabExtras;
    }

    public void setHorasTrabExtras(double horasTrabExtras) {
        this.horasTrabExtras = horasTrabExtras;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public double getImpuestoPorc() {
        return impuestoPorc;
    }

    public void setImpuestoPorc(double impuestoPorc) {
        this.impuestoPorc = impuestoPorc;
    }

    public int getNumRecibo() {
        return numRecibo;
    }

    public void setNumRecibo(int numRecibo) {
        this.numRecibo = numRecibo;
    }



public ReciboNomina(int numRecibo, String nombre, double horasTrabNormal, double horasTrabExtras, int puesto, double impuestoPorc){
    this.numRecibo = numRecibo;
    this.nombre = nombre;
    this.horasTrabNormal = horasTrabNormal;
    this.horasTrabExtras = horasTrabExtras;
    this.puesto = puesto;
    this.impuestoPorc = impuestoPorc;
}

    public final double calcularSubtotal() {
        double pagoBase = 200.0;
        switch (this.puesto) {
            case 1:
                pagoBase *= 1.2;
                break;
            case 2:
                pagoBase *= 1.5;
                break;
            case 3:
                pagoBase *= 2.0;
        }

        double pagoExtras = pagoBase * 2.0;
        return (pagoBase * this.horasTrabNormal) + (pagoExtras * this.horasTrabExtras);
    }

    public final double calcularImpuesto() {
        double subtotal = this.calcularSubtotal();
        return subtotal * this.impuestoPorc;
    }

    public final double calcularTotal() {
        double subtotal = this.calcularSubtotal();
        double impuesto = this.calcularImpuesto();
        return subtotal - impuesto;
    }
}
