package com.sena.seconPlant.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="IdUsuario", nullable = false, length =36)
    private String IdUsuario;

    @Column(name="Nombre", nullable = false, length = 45)
    private String Nombre;

    @Column(name="Apellido", nullable = false, length = 45)
    private String Apellido;

    @Column(name="TipoDocumento", nullable = false, length = 35)
    private String TipoDocumento;

    @Column(name="CorreoElectronico", nullable = false, length = 60)
    private String CorreoElectronico;
    
    @Column(name="Nacimiento", nullable = false, length = 15)
    private Date Nacimiento;
    
    @Column(name="Notificacion", nullable = false, length = 15)
    private Date Notificacion;

    @Column(name="Actualizacion", nullable = false, length = 15)
    private Date Actualizacion;

    @Column(name="Estado", nullable = false, length = 15)
    private String Estado;

    @Column(name="InicioSesion", nullable = false, length = 15)
    private String InicioSesion;

    @Column(name="Contra", nullable = false, length = 15)
    private String Contra;
    

}
