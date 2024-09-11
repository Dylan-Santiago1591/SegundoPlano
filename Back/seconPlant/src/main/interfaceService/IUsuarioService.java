package com.sena.seconPlant.interfaceService;

import java.util.List;
import java.util.Optional;


public interface IUsuarioService {
    public String save(Usuario Usuario);
    public List<Usuario> findAll();
    public List<Usuario> FiltrarNombre(String Nombre);
    public List<Usuario> FiltrarApellido(String Apellido);
    public List<Usuario> FiltrarCorreoElectronico(String CorreoElectronico);
    public Optional<Usuario> findOne(String id);
    public boolean delete(String id);

    public Optional<Usuario> findByCorreoElectronico(String CorreoElectronico);

    
}
