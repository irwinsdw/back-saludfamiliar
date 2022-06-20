package com.example.DIRESA.entity.empleado;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.DIRESA.entity.general.Familia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="encuesta")
@EqualsAndHashCode
public class Encuesta implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_familia")
    private Familia familia;

    @Column(name = "numero_visita", nullable = false, length = 100)
    private String numeroVisita;

    @Column(name = "forma_visita", nullable = false, length = 100)
    private String formaVisita;

    @Column(name = "fecha_visita", nullable = false)
    private Date fechaVisita;

    @Column(name = "condicion_encuesta", nullable = false, length = 100)
    private String condicionEncuesta;

    @Column(name = "observacion", nullable = false, length = 100)
    private String observacion;
}
