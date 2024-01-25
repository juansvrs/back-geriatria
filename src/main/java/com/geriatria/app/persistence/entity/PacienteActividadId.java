package com.geriatria.app.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteActividadId implements Serializable {
    private Integer idActividad;
    private String idPaciente;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PacienteActividadId that)) return false;
        return Objects.equals(idActividad, that.idActividad) && Objects.equals(idPaciente, that.idPaciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActividad, idPaciente);
    }
}
