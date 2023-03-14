package com.generation.firstspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name= "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name= "nombre_usuario")
    @Range(min = 5, max = 30, message = "Debe introducir un mínimo de 5 caracteres y un máximp de 30")
    private String nombreDeUsuario;

    @Range (min = 8, message = "Debe introducir un mínimo de 8 caracteres")
    private String password;
    
    @Column(name = "email_usuario")
    @Email
    private String email;
}
