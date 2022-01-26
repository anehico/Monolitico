package com.example.monolito.model;

import javax.persistence.*;

@Entity
@Table(name= "cliente")
public class clienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private String nombres;
    private int tipo_identificacion;
    @Column(unique = true, nullable = false)
    private String codigo_identificacion;
    private int edad;
    private String ciudad_nacimiento;

    public clienteModel(){

    }

    public clienteModel(int id, String nombres, int tipo_identificacion, String codigo_identificacion, int edad, String ciudad_nacimiento) {
        this.id = id;
        this.nombres = nombres;
        this.tipo_identificacion = tipo_identificacion;
        this.codigo_identificacion = codigo_identificacion;
        this.edad = edad;
        this.ciudad_nacimiento = ciudad_nacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public  void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getTipo_identificacion() {
        return tipo_identificacion;
    }

    public  void setTipo_identificacion(int tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getCodigo_identificacion() {
        return codigo_identificacion;
    }

    public  void setCodigo_identificacion(String codigo_identificacion) {
        this.codigo_identificacion = codigo_identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad_nacimiento() {
        return ciudad_nacimiento;
    }

    public void setCiudad_nacimiento(String ciudad_nacimiento) {
        this.ciudad_nacimiento = ciudad_nacimiento;
    }

    @Override
    public String toString() {
        return "clienteModel{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", tipo_identificacion=" + tipo_identificacion +
                ", codigo_identificacion='" + codigo_identificacion + '\'' +
                ", edad=" + edad +
                ", ciudad_nacimiento='" + ciudad_nacimiento + '\'' +
                '}';
    }
}
