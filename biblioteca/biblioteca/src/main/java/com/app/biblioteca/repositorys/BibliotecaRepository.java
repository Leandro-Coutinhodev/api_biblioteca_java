package com.app.biblioteca.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.biblioteca.entitys.Emprestimo;

@Repository
public interface BibliotecaRepository extends JpaRepository<Emprestimo, Long>{

}
