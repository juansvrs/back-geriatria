package com.geriatria.app.persistence.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "registro_diario")
@Getter
@Setter
@NoArgsConstructor
public class RegistroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date fecha;

    @Column(columnDefinition = "varchar(255) default 'sin realizar'")
    private String estado;

    @Column
    private String detallesRegistro;

    @Column(name = "id_paciente",nullable = false)
    private String idPaciente;

    @Column(name = "id_actividad", nullable = false)
    private Integer idActividad;


    /*
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente",insertable = false,updatable = false)
    private PacienteEntity paciente;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="id_actividad",referencedColumnName ="id_actividad",insertable = false,updatable = false )
    private ActividadEntity actividad;

     */
}
