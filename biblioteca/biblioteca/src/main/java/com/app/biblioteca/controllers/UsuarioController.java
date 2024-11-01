package com.app.biblioteca.controllers;

import com.app.biblioteca.entitys.Usuario;
import com.app.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Usuario usuario){
        try {
            String retorno = this.usuarioService.save(usuario);

            return new ResponseEntity<>(retorno, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>("Erro ao registrar um novo usuário!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        try {
            Usuario usuario = this.usuarioService.findById(id);

            return  new ResponseEntity<>(usuario, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Usuario>> findAll(){
        try {
            List<Usuario> lista = this.usuarioService.findAll();

            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Usuario usuario, @PathVariable Long id){
        try {
            String retorno = this.usuarioService.update(usuario, id);

            return new ResponseEntity<>(retorno, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Erro ao editar usuário!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            String retorno = this.usuarioService.delete(id);

            return new ResponseEntity<>(retorno, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Erro ao excluir usuário!", HttpStatus.BAD_REQUEST);
        }
    }
}
