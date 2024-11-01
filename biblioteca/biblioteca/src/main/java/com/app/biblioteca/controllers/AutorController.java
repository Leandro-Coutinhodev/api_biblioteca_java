package com.app.biblioteca.controllers;

import com.app.biblioteca.entitys.Autor;
import com.app.biblioteca.services.AutorService;
import org.aspectj.lang.annotation.DeclareWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autor")
@CrossOrigin("*")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Autor autor){
        try {
            String retorno = autorService.save(autor);

            return new ResponseEntity<>(retorno, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Erro ao registrar um novo autor!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Autor> findById(@PathVariable Long id){
        try {
            Autor autor = autorService.findById(id);

            return new ResponseEntity<>(autor, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Autor>> findAll(){
        try {
            List<Autor> lista = autorService.findAll();

            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Autor autor, Long id){
        try {
            String retorno = autorService.update(autor, id);

            return new ResponseEntity<>(retorno, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Erro ao editar autor!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            String retorno = autorService.delete(id);

            return new ResponseEntity<>(retorno, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Erro ao excluir autor!", HttpStatus.BAD_REQUEST);
        }
    }

}
