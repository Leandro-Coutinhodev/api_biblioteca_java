package com.app.biblioteca.services;

import com.app.biblioteca.entitys.Autor;
import com.app.biblioteca.repositorys.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public String save(Autor autor){
        autorRepository.save(autor);

        return "Autor registrado com sucesso!";
    }

    public Autor findById(Long id){

        return autorRepository.findById(id).get();
    }

    public List<Autor> findAll(){

        return autorRepository.findAll();
    }

    public String update(Autor autor, Long id){
        autor.setId(id);
        autorRepository.save(autor);

        return "Autor editado com sucesso!";
    }

    public String delete(Long id){
        autorRepository.deleteById(id);

        return "Autor excluído com sucesso!";
    }
}
