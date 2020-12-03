package com.retobg.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retobg.controlador.UsuarioControlador;
import com.retobg.modelo.Usuario;

@RestController
@RequestMapping ("/api/v1/users") //(localhost:8080/api/v1/users)

public class UsuarioRest {

	@Autowired
	private UsuarioControlador usercon;
	
	//METODOS PARA LAS SOLICITUDES EN SERVIDOR POR HTTP
	
	/*METODO GET 
	 * RESPONDE POR LA URL (localhost:8080/api/v1/users) 
	 *EL RESULTADO OBTENIDO ES LISTA DE USUARIOS
	 */
	@GetMapping
	public List<Usuario> listar(){
		return usercon.findAll();
	}
	
	/*METODO GET POR ID
	 * RESPONDE POR LA URL (localhost:8080/api/v1/users/id) 
	 * id ES INTRODUCIDO EN LA PETICION
	 * SE OBTIENE EL USUARIO DE LA BASDE DE DATOS DEPENDIENDO DEL id QUE 
	 * SE ENCUENTRE EN LA PETICION 
	 */
	@RequestMapping(value="{id}")
	public ResponseEntity<Usuario> listarId(@PathVariable("id") Integer ids){
		Optional <Usuario> usuario = usercon.findById(ids);
		
		//if PARA VALIDAR QUE EL USUARIO EXISTE
		if (usuario.isPresent()){
		return ResponseEntity.ok(usuario.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	/*METODO POST
	 * RESPONDE POR EL URL (localhost:8080/api/v1/users)
	 * SE CREA UN NUEVO REGISTRO DE USUARIO EN LA BASE DE DATOS
	 */
	@PostMapping 
	public ResponseEntity<Usuario> guardar(@RequestBody Usuario user){
		usercon.save(user);
	    return ResponseEntity.ok(user);
	}
	
	/*METODO PUT
	 * RESPONDE POR EL URL (localhost:8080/api/v1/users/id)
	 * id ES INTRODUCIDO EN LA PETICION
	 * SE MODIFICA EL NOMBRE DEL USUARIO DEPENDIENDO DEL id 
	 * INTRODUCIDO EN LA PETICION
	 */
	@PutMapping(value="{id}")
	public ResponseEntity<Usuario> modificar(@PathVariable("id") Integer id, @RequestBody Usuario user) {
		Optional <Usuario> usuario = usercon.findById(id);
		
		//if PARA VALIDAR QUE EL USUARIO EXISTE
		if (usuario.isPresent()){
			Usuario usuarioMod = usuario.get();
			usuarioMod.setNombre(user.getNombre());
			usercon.save(usuarioMod);
		    return ResponseEntity.ok(usuarioMod);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	/*METODO DELETE
	 * RESPONDE POR LA URL (localhost:8080/api/v1/users/id)
	 * SE ELIMINA EL USUARIO DEPENDIENDO DEL id INTRODUCIDO EN LA PETICION
	 */
		@DeleteMapping(value="{id}")
		public ResponseEntity<Void> eliminar(@PathVariable("id") Integer ids) {
		
			Optional <Usuario> usuario = usercon.findById(ids);
		
			//if PARA VALIDAR QUE EL USUARIO EXISTE
		  if (usuario.isPresent()){
		    usercon.deleteById(ids);
		    return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.noContent().build();
		}
		 
		
		}
}
