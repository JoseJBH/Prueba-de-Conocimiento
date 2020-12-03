package com.retobg.controlador;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retobg.modelo.Usuario;

//CREACION DE LA INTERFACE UsuarioControlador 
// ES UN CONTROLADOR SE PUEDE CREAR LA LOGICA DEL PROYECTO

//LA INTERFACE UsuarioControlador HEREDA DE LA CLASE JpaRepository
public interface UsuarioControlador extends JpaRepository<Usuario,Integer> {

}
