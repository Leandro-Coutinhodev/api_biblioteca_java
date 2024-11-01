package com.app.biblioteca.services;

import com.app.biblioteca.entitys.Usuario;
import com.app.biblioteca.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String save(Usuario usuario){
        this.usuarioRepository.save(usuario);

        return "Usuário registrado com sucesso!";
    }

    public Usuario findById(Long id){

        return this.usuarioRepository.findById(id).get();
    }

    public List<Usuario> findAll(){

        return this.usuarioRepository.findAll();
    }

    public String update(Usuario usuario, Long id){
        usuario.setId(id);
        this.usuarioRepository.save(usuario);

        return "Usuário editado com sucesso!";
    }

    public String delete(Long id){
        this.usuarioRepository.deleteById(id);

        return "Usuário excluído com sucesso!";
    }
}
