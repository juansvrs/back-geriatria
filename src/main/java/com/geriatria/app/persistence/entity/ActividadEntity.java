package com.geriatria.app.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "actividad")
@Getter
@Setter
@NoArgsConstructor
public class ActividadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_actividad", nullable = false)
    private Integer idActividad;

    @Column(name = "nombre",length = 255)
    private String nombre;

    @Column(nullable = false,length = 255)
    private String descripcion;

    @Column(name = "tipo_actividad")
    private String tipoActividad;

    @Column(name = "hora_recomendada")
    private String hora;

    @Column
    private  String url;

    @OneToMany(mappedBy = "actividad",fetch = FetchType.LAZY)
    private List<PacienteActividadEntity> actividadesPaciente;


    /*
    @OneToMany(mappedBy = "actividad",fetch = FetchType.LAZY)
    private List<RegistroEntity> registros;*/


}
