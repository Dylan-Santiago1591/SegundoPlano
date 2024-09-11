package com.sena.seconPlant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Libreria.InterfaceService.IUsuarioService;
import com.example.Libreria.Interfaces.IUsuario;
import com.example.Libreria.Models.Usuario;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuario data;

    @Override
    public String save(Usuario Usuario) {
        data.save(Usuario);
        return Usuario.getIdUsuario();
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> ListaUsuario = (List<Usuario>) data.findAll();
        return ListaUsuario;
    }

    @Override
    public List<Usuario> FiltrarNombre(String Nombre) {
        List<Usuario> ListaUsuario = data.FiltrarNombre(Nombre);
        return ListaUsuario;
    }

    @Override
    public List<Usuario> FiltrarApellido(String Apellido) {
        List<Usuario> ListaUsuario = data.FiltrarApellido(Apellido);
        return ListaUsuario;
    }

    @Override
    public List<Usuario> FiltrarCorreoElectronico(String CorreoElectronico) {
        List<Usuario> ListaUsuario = data.FiltrarCorreoElectronico(CorreoElectronico);
        return ListaUsuario;
    }

    @Override
    public Optional<Usuario> findOne(String id) {
        Optional<Usuario> Usuario = data.findById(id);
        return Usuario;
    }

    @Override
    public boolean delete(String id) {
        if (data.existsById(id)) {
            data.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<Usuario> findByCorreoElectronico(String CorreoElectronico) {
        
        return data.findByCorreoElectronico(CorreoElectronico);
    }

    @Override
    public List<usuario> CambiarTipoDocumento(){
        List<usuario> ListaUsuario = data.CambiarTipoDocumento();
        return ListaUsuario; 
    }
    

}
