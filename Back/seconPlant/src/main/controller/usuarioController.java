package com.sena.seconPlant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Libreria.InterfaceService.IUsuarioService;
import com.example.Libreria.Models.Usuario;

@RequestMapping("api/v1/Usuario/")
@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService UsuarioService;

    @PostMapping("/")
    public ResponseEntity<Object> save(@ModelAttribute("Usuario") Usuario Usuario) {
        if (Usuario.getNombre().equals("")) {
            return new ResponseEntity<>("Este campo es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (Usuario.getApellido().equals("")) {
            return new ResponseEntity<>("Este campo es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (Usuario.getCorreoElectronico().equals("")) {
            return new ResponseEntity<>("Este campo es obligatorio", HttpStatus.BAD_REQUEST);
        }
        // Verificar unicidad del correo electrónico
        if (UsuarioService.findByCorreoElectronico(Usuario.getCorreoElectronico()).isPresent()) {
            return new ResponseEntity<>("El correo electrónico ya está registrado", HttpStatus.BAD_REQUEST);
        }

        UsuarioService.save(Usuario);
        return new ResponseEntity<>(Usuario, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        var ListaUsuario = UsuarioService.findAll();
        return new ResponseEntity<>(ListaUsuario, HttpStatus.OK);
    }

    @GetMapping("FiltrarNombre/{Nombre}")
    public ResponseEntity<Object> findNombre(@PathVariable String Nombre) {
        var ListaUsuario = UsuarioService.FiltrarNombre(Nombre);
        return new ResponseEntity<>(ListaUsuario, HttpStatus.OK);
    }

    @GetMapping("FiltrarApellido/{Apellido}")
    public ResponseEntity<Object> findApellido(@PathVariable String Apellido) {
        var ListaUsuario = UsuarioService.FiltrarApellido(Apellido);
        return new ResponseEntity<>(ListaUsuario, HttpStatus.OK);
    }

    @GetMapping("FiltrarCorreoElectronico/{CorreoElectronico}")
    public ResponseEntity<Object> findCorreoElectronico(@PathVariable String CorreoElectronico) {
        var ListaUsuario = UsuarioService.FiltrarCorreoElectronico(CorreoElectronico);
        return new ResponseEntity<>(ListaUsuario, HttpStatus.OK);
    }

    @GetMapping("/existsByCorreoElectronico/{CorreoElectronico}")
    public ResponseEntity<Boolean> existsByCorreoElectronico(@PathVariable String CorreoElectronico) {
        boolean exists = UsuarioService.findByCorreoElectronico(CorreoElectronico).isPresent();
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable String id) {
        var Usuario = UsuarioService.findOne(id);
        return new ResponseEntity<>(Usuario, HttpStatus.OK);
    }

    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        UsuarioService.delete(id);
        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("Usuario") Usuario UsuarioUpdate) {
        var Usuario = UsuarioService.findOne(id).get();
        if (Usuario != null) {
            Usuario.setNombre(UsuarioUpdate.getNombre());
            Usuario.setApellido(UsuarioUpdate.getApellido());
            Usuario.setDireccion(UsuarioUpdate.getDireccion());
            Usuario.setCorreoElectronico(UsuarioUpdate.getCorreoElectronico());
            Usuario.setTipoUsuario(UsuarioUpdate.getTipoUsuario());
            UsuarioService.save(Usuario);
            return new ResponseEntity<>(Usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error Usuario no encontrado", HttpStatus.BAD_REQUEST);
        }
    }

}
