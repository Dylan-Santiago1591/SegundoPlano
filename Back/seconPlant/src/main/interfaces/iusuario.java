package com.sena.seconPlant.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Libreria.Models.Usuario;



@Repository
public interface IUsuario extends CrudRepository<Usuario, String> {

    @Query("SELECT U FROM Usuario U WHERE U.Nombre LIKE %?1%")
    List<Usuario> FiltrarNombre(String Nombre);

    @Query ("SELECT U FROM Usuario U WHERE U.Estado = 'Activo' AND TIMESTAMPDIFF(YEAR, U.Nacimiento, NOW())>=18 AND TipoDocumento = 'TI' ")
    List<usuario> CambiarTipoDocumento();

    @Query ("SELECT U FROM Usuario U WHERE U.Estado = 'Activo' AND DATEDIFF(NOW(), U.Actualizacion) >= 90")
    List<usuario> ActualizacionContra();

    @Query ("SELECT U FROM Usuario U WHERE U.Estado = 'Activo' AND DATEDIFF(NOW(), U.InicioSesion) >= 30")
    List<usuario> InicioSesionNotificacion();

    @Query ("SELECT U FROM Usuario U WHERE U.Notificado is NULL")
    List<usuario> RegistroNotificado();
}
