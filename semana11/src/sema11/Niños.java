/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sema11;

/**
 *
 * @author jeiss
 */
public class Niños {
    private String tipo;
    private String nombre;
    private String raza;
    private String color; 
    private double edad;

    public Niños() {
    }
    
    

    public Niños(String tipo, String nombre, String raza, String color, double edad) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.edad = edad;
        
    }
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

   
}