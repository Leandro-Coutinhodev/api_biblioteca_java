package com.app.biblioteca.controllers;

import com.app.biblioteca.entitys.Livro;
import com.app.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livro")
@CrossOrigin("*")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Livro livro){
        try {
            String retorno = livroService.save(livro);

            return new ResponseEntity<>(retorno, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>("Erro ao salvar livro!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        try {
            Livro livro = livroService.findById(id);

            return new ResponseEntity<>(livro, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Livro>> findAll(){
        try {
            List<Livro> lista = livroService.findAll();

            return ResponseEntity.ok(lista);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Livro livro, @PathVariable Long id){
        try {
            String retorno = livroService.update(livro, id);

            return new ResponseEntity<>(retorno, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>("Erro ao atualizar livro!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            String retorno = livroService.delete(id);

            return  new ResponseEntity<>(retorno, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Erro ao deletar livro!", HttpStatus.BAD_REQUEST);
        }
    }
}
