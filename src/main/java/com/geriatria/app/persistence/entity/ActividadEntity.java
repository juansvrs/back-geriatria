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

    @Column(name = "nombre", length = 30,unique = true)
    private String nombre;

    @Column(nullable = false,length = 200)
    private String descripcion;

    @Column(name = "hora_recomendada")
    private String hora;

    @Column
    private  String url;

    @OneToMany(mappedBy = "actividad",fetch = FetchType.LAZY)
    private List<PacienteActividadEntity> actividadesPaciente;


}
