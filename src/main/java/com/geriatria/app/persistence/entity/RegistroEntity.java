package com.geriatria.app.persistence.entity;


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
    private Date fecha;

    @Column
    private Boolean estado;

    @Column(name = "id_paciente", insertable = false, updatable = false)
    private String idPaciente;

    @Column(name = "id_actividad", insertable = false, updatable = false)
    private Integer idActividad;

    @ManyToOne
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente",insertable = false,updatable = false)
    private PacienteEntity paciente;

    @ManyToOne
    @JoinColumn(name ="id_actividad",referencedColumnName ="id_actividad",insertable = false,updatable = false )
    private ActividadEntity actividad;
}
