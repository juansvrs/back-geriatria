package com.geriatria.app.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "paciente_actividad")
@IdClass(PacienteActividadId.class)
@Setter
@Getter
@NoArgsConstructor
public class PacienteActividadEntity {

    @Id
    @Column(name = "id_paciente")
    private String idPaciente;

    @Id
    @Column(name = "id_actividad")
    private Integer idActividad;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente",insertable = false,updatable = false)
    private PacienteEntity paciente;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="id_actividad",referencedColumnName ="id_actividad",insertable = false,updatable = false )
    private ActividadEntity actividad;

}
