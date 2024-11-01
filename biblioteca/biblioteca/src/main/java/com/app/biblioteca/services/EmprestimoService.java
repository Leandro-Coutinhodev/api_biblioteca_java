package com.app.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.biblioteca.entitys.Emprestimo;
import com.app.biblioteca.repositorys.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	public String save(Emprestimo emprestimo) {
		
		this.emprestimoRepository.save(emprestimo);
		
		return "Empréstimo registrado!";
	}
	
	public Emprestimo findById(Long id) {
		
		Emprestimo emprestimo = this.emprestimoRepository.findById(id).get();
		
		return emprestimo;
	}
	
	public List<Emprestimo> findAll(){
		
		return this.emprestimoRepository.findAll();
	}
	
	public String update(Long id, Emprestimo emprestimo) {
		
		emprestimo.setId(id);
		this.emprestimoRepository.save(emprestimo);

		return "Empréstimo atualizado!";
	}

	public String delete(Long id){

		this.emprestimoRepository.deleteById(id);

		return "Empréstimo excluído com sucesso!";
	}
}
