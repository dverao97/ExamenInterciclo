package com.example.ExamenPracticoM5B.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo",nullable = false)
    private Integer codigo;
    @Column(length = 100, name="descripcion",nullable = false)
    private String descripcion;

    @Column(name = "precio",scale = 2,nullable = false)
    private Double precio;

    @Column(name = "cantidad",nullable = false)
    @Min(value = 0,message = "Debe ser mayor a 0 el valor")
    private Integer cantidad;


}
