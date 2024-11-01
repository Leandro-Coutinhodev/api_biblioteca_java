package com.app.biblioteca.services;

import com.app.biblioteca.entitys.Livro;
import com.app.biblioteca.repositorys.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public String save(Livro livro){
        this.livroRepository.save(livro);

        return "Livro registrado com sucesso!";
    }

    public Livro findById(Long id){

        return this.livroRepository.findById(id).get();
    }

    public List<Livro> findAll(){
        return this.livroRepository.findAll();
    }

    public String update(Livro livro, Long id){
        livro.setId(id);
        this.livroRepository.save(livro);

        return "Livro editado com sucesso!";
    }

    public String delete(Long id){
        this.livroRepository.deleteById(id);

        return "Livro excluído com sucesso!";
    }

}
