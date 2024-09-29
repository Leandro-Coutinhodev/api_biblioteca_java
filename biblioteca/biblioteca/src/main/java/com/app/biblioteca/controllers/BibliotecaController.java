package com.app.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.biblioteca.entitys.Emprestimo;
import com.app.biblioteca.services.BibliotecaService;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

  @Autowired
  private BibliotecaService bibliotecaService;

  @PostMapping("/save")
  public ResponseEntity<String> save(@RequestBody Emprestimo emprestimo){
    try {
      String retorno = this.bibliotecaService.save(emprestimo);

      return new ResponseEntity<>(retorno, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Erro ao salvar!", HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/findById/{id}")
  public ResponseEntity<Emprestimo> findById(@PathVariable Long id){
    try {
      Emprestimo emprestimo = this.bibliotecaService.findById(id);

      return new ResponseEntity<>(emprestimo, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/findAll")
  public ResponseEntity<List<Emprestimo>> findAll(){
    try {
      List<Emprestimo> lista = this.bibliotecaService.findAll();

      return new ResponseEntity<>(lista, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Emprestimo emprestimo){
    try {
      String retorno = this.bibliotecaService.update(id, emprestimo);

      return new ResponseEntity<>(retorno, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Erro ao atualizar empréstimo.", HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id){
    try {
      String mensagem = this.bibliotecaService.delete(id);

      return new ResponseEntity<>(mensagem, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Erro ao excluir empréstimo!", HttpStatus.BAD_REQUEST);
    }
  }
}
