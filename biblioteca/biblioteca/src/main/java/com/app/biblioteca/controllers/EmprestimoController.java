package com.app.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.biblioteca.entitys.Emprestimo;
import com.app.biblioteca.services.EmprestimoService;

@RestController
@RequestMapping("/api/emprestimo")
@CrossOrigin("*")
public class EmprestimoController {

  @Autowired
  private EmprestimoService emprestimoService;

  @PostMapping("/save")
  public ResponseEntity<String> save(@RequestBody Emprestimo emprestimo){
    try {
      String retorno = this.emprestimoService.save(emprestimo);

      return new ResponseEntity<>(retorno, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Erro ao salvar!", HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/findById/{id}")
  public ResponseEntity<Emprestimo> findById(@PathVariable Long id){
    try {
      Emprestimo emprestimo = this.emprestimoService.findById(id);

      return new ResponseEntity<>(emprestimo, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/findAll")
  public ResponseEntity<List<Emprestimo>> findAll(){
    try {
      List<Emprestimo> lista = this.emprestimoService.findAll();

      return new ResponseEntity<>(lista, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Emprestimo emprestimo){
    try {
      String retorno = this.emprestimoService.update(id, emprestimo);

      return new ResponseEntity<>(retorno, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Erro ao atualizar empréstimo.", HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id){
    try {
      String mensagem = this.emprestimoService.delete(id);

      return new ResponseEntity<>(mensagem, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Erro ao excluir empréstimo!", HttpStatus.BAD_REQUEST);
    }
  }
}
