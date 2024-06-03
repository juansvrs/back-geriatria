package com.geriatria.app.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo")
@Getter
@Setter
@NoArgsConstructor
public class TipoActividadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name ="id_actividad",referencedColumnName ="id_actividad",insertable = false,updatable = false )
    private ActividadEntity actividad;



}
