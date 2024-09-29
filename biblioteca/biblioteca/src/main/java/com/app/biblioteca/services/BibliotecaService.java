package com.app.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.biblioteca.entitys.Emprestimo;
import com.app.biblioteca.repositorys.BibliotecaRepository;

@Service
public class BibliotecaService {

	@Autowired
	private BibliotecaRepository bibliotecaRepository;
	
	public String save(Emprestimo emprestimo) {
		
		this.bibliotecaRepository.save(emprestimo);
		
		return "Empréstimo registrado!";
	}
	
	public Emprestimo findById(Long id) {
		
		Emprestimo emprestimo = this.bibliotecaRepository.findById(id).get();
		
		return emprestimo;
	}
	
	public List<Emprestimo> findAll(){
		
		return this.bibliotecaRepository.findAll();
	}
	
	public String update(Long id, Emprestimo emprestimo) {
		
		emprestimo.setId(id);
		this.bibliotecaRepository.save(emprestimo);

		return "Empréstimo atualizado!";
	}

	public String delete(Long id){

		this.bibliotecaRepository.deleteById(id);

		return "Empréstimo excluído com sucesso!";
	}
}
